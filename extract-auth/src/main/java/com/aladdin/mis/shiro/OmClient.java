package com.aladdin.mis.shiro;
/*
 *  Created by cles on 2023/2/2 23:34
 */

import com.aladdin.mis.system.user.vo.OmUser;
import org.apache.shiro.SecurityUtils;

/**
 * @author cles
 * @description: 用户的设置
 * @Date 2023/2/2 23:34
 * @version: 1.0.0
 */
public class OmClient {

    /**
     * 获取当前用户
     * @return
     */
    public static OmUser getCurrentUser(){
        return (OmUser) SecurityUtils.getSubject().getPrincipal();
    }
}
