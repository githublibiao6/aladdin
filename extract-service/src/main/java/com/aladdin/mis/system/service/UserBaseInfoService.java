package com.aladdin.mis.system.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.bean.UserBaseInfo;
import org.springframework.stereotype.Service;


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
