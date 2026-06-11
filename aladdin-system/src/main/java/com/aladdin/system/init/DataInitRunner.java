package com.aladdin.system.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 数据初始化
 *
 * @author cles
 * @date 2026/06/11
 */
@Component
@Order(value = 2)
public class DataInitRunner implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitRunner.class);

    private final JdbcTemplate jdbcTemplate;

    public DataInitRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            resetDevPassword();
            initResources();
            initUser();
            initRoleResource();
            initUserRole();
            initDictData();
            log.info("数据初始化完成");
        } catch (Exception e) {
            log.warn("数据初始化异常: {}", e.getMessage());
        }
    }

    private void resetDevPassword() {
        jdbcTemplate.update("UPDATE sys_user SET password = '123456' WHERE username IN ('admin', 'user01') AND password LIKE '$2a$%'");
        log.info("重置开发环境密码完成");
    }

    private void initResources() {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM sys_resource WHERE id >= 7", Integer.class);
        if (count != null && count > 0) {
            return;
        }
        jdbcTemplate.update("INSERT INTO sys_resource (id, resource_name, parent_id, sort, path, component, resource_type, perms, icon, status, sys001, sys003, sys005, sys006) VALUES " +
                "(7, '用户新增', 2, 1, '', '', 'F', 'system:user:add', '', 1, NOW(), 1, 1, 'system'), " +
                "(8, '用户修改', 2, 2, '', '', 'F', 'system:user:edit', '', 1, NOW(), 1, 1, 'system'), " +
                "(9, '用户删除', 2, 3, '', '', 'F', 'system:user:remove', '', 1, NOW(), 1, 1, 'system'), " +
                "(10, '角色新增', 3, 1, '', '', 'F', 'system:role:add', '', 1, NOW(), 1, 1, 'system'), " +
                "(11, '角色修改', 3, 2, '', '', 'F', 'system:role:edit', '', 1, NOW(), 1, 1, 'system'), " +
                "(12, '角色删除', 3, 3, '', '', 'F', 'system:role:remove', '', 1, NOW(), 1, 1, 'system'), " +
                "(13, '资源新增', 4, 1, '', '', 'F', 'system:resource:add', '', 1, NOW(), 1, 1, 'system'), " +
                "(14, '资源修改', 4, 2, '', '', 'F', 'system:resource:edit', '', 1, NOW(), 1, 1, 'system'), " +
                "(15, '资源删除', 4, 3, '', '', 'F', 'system:resource:remove', '', 1, NOW(), 1, 1, 'system'), " +
                "(16, '部门新增', 5, 1, '', '', 'F', 'system:dept:add', '', 1, NOW(), 1, 1, 'system'), " +
                "(17, '部门修改', 5, 2, '', '', 'F', 'system:dept:edit', '', 1, NOW(), 1, 1, 'system'), " +
                "(18, '部门删除', 5, 3, '', '', 'F', 'system:dept:remove', '', 1, NOW(), 1, 1, 'system'), " +
                "(19, '字典新增', 6, 1, '', '', 'F', 'system:dict:add', '', 1, NOW(), 1, 1, 'system'), " +
                "(20, '字典修改', 6, 2, '', '', 'F', 'system:dict:edit', '', 1, NOW(), 1, 1, 'system'), " +
                "(21, '字典删除', 6, 3, '', '', 'F', 'system:dict:remove', '', 1, NOW(), 1, 1, 'system')");
        log.info("初始化资源权限数据完成");
    }

    private void initUser() {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM sys_user WHERE username = 'user01'", Integer.class);
        if (count != null && count > 0) {
            return;
        }
        jdbcTemplate.update("INSERT INTO sys_user (username, password, nickname, email, phone, dept_id, status, sys001, sys003, sys005, sys006) VALUES " +
                "('user01', '123456', '普通用户', 'user01@aladdin.com', '13800138001', 2, 1, NOW(), 1, 1, 'system')");
        log.info("初始化普通用户完成");
    }

    private void initRoleResource() {
        jdbcTemplate.update("DELETE FROM sys_role_resource WHERE role_id = 2 AND resource_id IN (1, 2, 3)");
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM sys_role_resource WHERE role_id = 1 AND resource_id >= 7", Integer.class);
        if (count != null && count > 0) {
            return;
        }
        // admin角色：所有资源和权限
        jdbcTemplate.update("INSERT INTO sys_role_resource (role_id, resource_id) VALUES " +
                "(1, 7), (1, 8), (1, 9), (1, 10), (1, 11), (1, 12), (1, 13), (1, 14), (1, 15), " +
                "(1, 16), (1, 17), (1, 18), (1, 19), (1, 20), (1, 21)");
        // user角色：只有部门管理和字典查询
        jdbcTemplate.update("INSERT IGNORE INTO sys_role_resource (role_id, resource_id) VALUES " +
                "(2, 5), (2, 6)");
        log.info("初始化角色资源关联完成");
    }

    private void initUserRole() {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM sys_user_role WHERE user_id = 2", Integer.class);
        if (count != null && count > 0) {
            return;
        }
        jdbcTemplate.update("INSERT INTO sys_user_role (user_id, role_id) VALUES (2, 2)");
        log.info("初始化用户角色关联完成");
    }

    private void initDictData() {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM sys_dict_type", Integer.class);
        if (count != null && count > 0) {
            return;
        }
        jdbcTemplate.update("INSERT INTO sys_dict_type (id, dict_name, dict_type, status, sys001, sys003, sys005, sys006) VALUES " +
                "(1, '性别', 'sys_user_sex', 1, NOW(), 1, 1, 'system'), " +
                "(2, '状态', 'sys_normal_disable', 1, NOW(), 1, 1, 'system'), " +
                "(3, '资源类型', 'sys_resource_type', 1, NOW(), 1, 1, 'system'), " +
                "(4, '数据权限', 'sys_data_scope', 1, NOW(), 1, 1, 'system')");

        jdbcTemplate.update("INSERT INTO sys_dict_data (dict_type_id, dict_label, dict_value, sort, list_class, status, sys001, sys003, sys005, sys006) VALUES " +
                "(1, '男', '0', 1, 'primary', 1, NOW(), 1, 1, 'system'), " +
                "(1, '女', '1', 2, 'danger', 1, NOW(), 1, 1, 'system'), " +
                "(1, '未知', '2', 3, 'info', 1, NOW(), 1, 1, 'system'), " +
                "(2, '正常', '1', 1, 'primary', 1, NOW(), 1, 1, 'system'), " +
                "(2, '停用', '0', 2, 'danger', 1, NOW(), 1, 1, 'system'), " +
                "(3, '菜单', 'M', 1, 'primary', 1, NOW(), 1, 1, 'system'), " +
                "(3, '接口', 'A', 2, 'success', 1, NOW(), 1, 1, 'system'), " +
                "(3, '按钮', 'F', 3, 'warning', 1, NOW(), 1, 1, 'system'), " +
                "(4, '全部数据', '1', 1, 'primary', 1, NOW(), 1, 1, 'system'), " +
                "(4, '自定义数据', '2', 2, 'success', 1, NOW(), 1, 1, 'system'), " +
                "(4, '本部门数据', '3', 3, 'warning', 1, NOW(), 1, 1, 'system'), " +
                "(4, '本部门及以下', '4', 4, 'info', 1, NOW(), 1, 1, 'system'), " +
                "(4, '仅本人数据', '5', 5, 'danger', 1, NOW(), 1, 1, 'system')");
        log.info("初始化字典数据完成");
    }
}
