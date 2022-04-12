package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.bean.UserBaseInfo;


/**
 * 字典 Service
 * @author lb
 *
 */
public interface UserBaseInfoService extends GlobalService<UserBaseInfo> {


    /**
     *
     * @param id
     */
    void init(Integer id);
}
