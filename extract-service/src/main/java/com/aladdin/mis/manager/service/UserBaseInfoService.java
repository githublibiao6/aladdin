package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.bean.UserBaseInfo;
import org.springframework.stereotype.Service;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public interface UserBaseInfoService extends GlobalService<UserBaseInfo> {


    /**
     *
     * @param id
     */
    void init(Integer id);
}
