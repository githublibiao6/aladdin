package com.aladdin.mis.shiro.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.shiro.entity.BeAuthUrl;
import com.aladdin.mis.shiro.vo.BeAuthUrlVo;

import java.util.List;

/**
 * BeAuthUrlService
 * @author cles
 * @date 2023-02-03 23:50:29
*/
public interface BeAuthUrlService extends GlobalService<BeAuthUrl>  {

    /**
     * 获取所有的shiro url配置
     * @return
     */
    List<BeAuthUrlVo> list();
}
