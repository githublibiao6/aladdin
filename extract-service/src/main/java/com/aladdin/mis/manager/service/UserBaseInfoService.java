package com.aladdin.mis.manager.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.bean.UserBaseInfo;


/**
 * 字典 Service
 * @author lb
 *
 */
public interface UserBaseInfoService extends GlobalService<UserBaseInfo> {

    /**
     * 初始化用户信息
     * @param id
     */
    void init(Integer id);
}
