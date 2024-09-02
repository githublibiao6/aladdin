package com.aladdin.mis.identity.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.base.qo.Condition;
import com.aladdin.mis.common.currency.DefaultParam;
import com.aladdin.mis.common.currency.DefaultTools;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.dao.identity.UserDao;
import com.aladdin.mis.identity.qo.UserQo;
import com.aladdin.mis.identity.vo.UserVo;
import com.aladdin.mis.manager.bean.User;
import com.aladdin.mis.identity.service.UserBaseInfoService;
import com.aladdin.mis.identity.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class UserServiceImpl extends GlobalServiceImpl<User> implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private UserBaseInfoService userBaseInfoService;

    @Override
    public PageInfo<User> page(com.aladdin.mis.identity.qo.UserQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<User> list = dao.listUser(qo);
        return new PageInfo<>(list);
    }

    @Override
    public List<User> list(String name) {
        UserQo qo = new UserQo();
        qo.setUserName(name);
        return dao.listUser(qo);
    }

    @Override
    public boolean add(User m) {
        return insertSelective(m);
    }

    @Override
    public boolean update(User m) {
        return updateSelective(m);
    }

    @Override
    public boolean remove(Integer id) {
        return  deleteById(id);
    }

    @Override
    public Result register(User entity) {
        User userPhone = getByCondition(Condition.newInstance().addExpression("phone", entity.getPhone()));
        if(userPhone != null){
            return Result.error(50015, "用户手机号已被占用");
        }
        User userAccount = getByCondition(Condition.newInstance().addExpression("account", entity.getAccount()));
        if(userAccount != null){
            return Result.error(50016, "用户名已存在");
        }
        String salt = RandomUtil.randomString(6);
        entity.setSalt(salt);

        // MD5 加密
        Digester md5 = DefaultTools.MD5_TOOL;
        // 密码加密 md5 加密后的密文加上salt 再进行一次 md5加密 生成数据库保存的密码
        String pass = md5.digestHex(entity.getPassword() + salt);
        String md5Hex1 = DigestUtil.md5Hex(entity.getPassword() + salt);
        entity.setPassword(pass);

        entity.setLastLoginTime(LocalDateTime.now());
        entity.setUpdatePwdTime(LocalDateTime.now());
        entity.setErrorTimes(0);
        // todo 生成唯一标识符 账号

        LocalDateTime now = LocalDateTime.now();
        int second = now.getSecond();
        String userNumber = (second + 36) + RandomUtil.randomNumbers(6);
        // 启用校验位

        User data = insertSelective(entity);

        userBaseInfoService.init(data.getId());
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(data, vo);
        return Result.success("注册成功", vo);
    }

    @Override
    public Result resetPass(Integer userId) {

        String salt = RandomUtil.randomString(6);
        User user = new User();
        user.setId(userId);
        user.setSalt(salt);
        // 希望下次登录时需要修改密码
        user.setSys006("01");

        // MD5 加密
        Digester md5 = DefaultTools.MD5_TOOL;
        // 密码加密 md5 加密后的密文加上salt 再进行一次 md5加密 生成数据库保存的密码
        String pass = md5.digestHex(DefaultParam.DEFAULT_PASSWORD + salt);
        user.setPassword(pass);

        user.setUpdatePwdTime(LocalDateTime.now());
        user.setErrorTimes(0);
        updateSelective(user);

        return Result.success("密码更新成功", null);
    }

    @Override
    public boolean updatePass(User user) {

        String salt = RandomUtil.randomString(6);
        user.setSalt(salt);
        user.setSys006("00");
        // MD5 加密
        Digester md5 = DefaultTools.MD5_TOOL;
        // 密码加密 md5 加密后的密文加上salt 再进行一次 md5加密 生成数据库保存的密码
        String pass = md5.digestHex(user.getPassword() + salt);
        user.setPassword(pass);
        return update(user);
    }

    @Override
    public User getByUserNumber(Integer userNumber) {
        return null;
    }
}
