package com.aladdin.system.service.impl;

import com.aladdin.common.core.constant.RedisKeyConstant;
import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;
import com.aladdin.common.core.exception.BusinessException;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.common.security.config.SecurityProperties;
import com.aladdin.common.security.redis.RedisService;
import com.aladdin.system.dao.SysUserDao;
import com.aladdin.system.entity.SysUser;
import com.aladdin.system.service.SysUserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    private final SecurityProperties securityProperties;
    private final RedisService redisService;
    private final PasswordEncoder passwordEncoder;

    public SysUserServiceImpl(SecurityProperties securityProperties, RedisService redisService, @Lazy PasswordEncoder passwordEncoder) {
        this.securityProperties = securityProperties;
        this.redisService = redisService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public SysUser getByUsername(String username) {
        return getMapper().selectByUsername(username);
    }

    @Override
    public Set<String> getRoleKeysByUserId(Long userId) {
        return getMapper().selectRoleKeysByUserId(userId);
    }

    @Override
    public Set<String> getPermsByUserId(Long userId) {
        return getMapper().selectPermsByUserId(userId);
    }

    @Override
    public Set<String> getAllPerms() {
        return getMapper().selectAllPerms();
    }

    @Override
    public SysUser getUserWithDeptById(Long id) {
        return getMapper().selectUserWithDeptById(id);
    }

    @Override
    public boolean resetPassword(Long id, String password) {
        // 重置密码后标记需要强制修改
        getMapper().updatePwdForceChange(id, 1);
        return getMapper().updatePassword(id, password) > 0;
    }

    @Override
    public boolean updateStatus(Long id, Integer status) {
        return getMapper().updateStatus(id, status) > 0;
    }

    @Override
    public boolean changePassword(Long userId, String oldPassword, String newPassword) {
        SysUser user = getById(userId);
        if (user == null) {
            throw new BusinessException(GlobalErrorCode.USER_NOT_FOUND);
        }
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new BusinessException(GlobalErrorCode.PASSWORD_ERROR);
        }
        // 校验新密码不能与最近N次相同
        SecurityProperties.Password pwdConfig = securityProperties.getPassword();
        if (pwdConfig.isEnabled() && pwdConfig.getHistoryCount() > 0) {
            List<Object> historyList = redisService.lRange(RedisKeyConstant.PWD_HISTORY + userId, 0, pwdConfig.getHistoryCount() - 1);
            for (Object obj : historyList) {
                String oldHash = (String) obj;
                if (passwordEncoder.matches(newPassword, oldHash)) {
                    throw new BusinessException(GlobalErrorCode.PASSWORD_SAME_AS_OLD);
                }
            }
        }
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        // 保存密码历史
        redisService.lPush(RedisKeyConstant.PWD_HISTORY + userId, encodedNewPassword);
        // 保留最近N条记录
        redisService.lSize(RedisKeyConstant.PWD_HISTORY + userId);
        // 更新密码和修改时间
        return getMapper().updatePasswordWithTime(userId, encodedNewPassword, LocalDateTime.now()) > 0;
    }

    @Override
    public boolean updateProfile(Long userId, String nickname, String email, String phone, String avatar) {
        SysUser user = new SysUser();
        user.setId(userId);
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAvatar(avatar);
        return updateById(user);
    }

    @Override
    public boolean isPasswordExpired(SysUser user) {
        SecurityProperties.Password pwdConfig = securityProperties.getPassword();
        if (!pwdConfig.isEnabled() || pwdConfig.getExpireDays() <= 0) {
            return false;
        }
        if (user.getPwdChangeTime() == null) {
            return true;
        }
        long daysBetween = ChronoUnit.DAYS.between(user.getPwdChangeTime(), LocalDateTime.now());
        return daysBetween > pwdConfig.getExpireDays();
    }

    @Override
    public boolean needForceChangePassword(SysUser user) {
        SecurityProperties.Password pwdConfig = securityProperties.getPassword();
        if (!pwdConfig.isEnabled() || !pwdConfig.isForceChangeOnFirstLogin()) {
            return false;
        }
        return user.getPwdForceChange() != null && user.getPwdForceChange() == 1;
    }

    @Override
    public PageResult<SysUser> listPage(PageQuery pageQuery, String username, Integer status, Long deptId) {
        int page = pageQuery.getPage();
        int limit = pageQuery.getLimit();
        int offset = (page - 1) * limit;
        List<SysUser> pageList = getMapper().selectUserListWithDept(username, status, deptId, offset, limit);
        long total = getMapper().countUserListWithDept(username, status, deptId);
        return new PageResult<>(page, limit, total, pageList);
    }
}
