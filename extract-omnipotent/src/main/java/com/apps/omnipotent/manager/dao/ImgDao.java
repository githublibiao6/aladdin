package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.Img;
import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.bean.RoleMenu;

import java.util.List;

/**
 * 图片dao
* @Description 
* @MethodName  RoleDao
* @author lb
* @date 2018年8月20日 下午11:14:28
*
 */
public interface ImgDao {

    /**
     * 功能描述：
     *  < 根据主键获取数据 >
     * @Description: findById
     * @Author: cles
     * @Date: 2020/7/6 22:17
     * @param code 参数1
     * @param id 参数1
     * @return: com.apps.omnipotent.manager.bean.Role
     * @version: 1.0.0
     */
    Img findByCodeAndId(String code, String id);

}
