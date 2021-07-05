package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.bean.Img;
import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.bean.RoleMenu;
import com.apps.omnipotent.manager.dao.ImgDao;
import com.apps.omnipotent.manager.dao.RoleDao;
import com.apps.omnipotent.manager.service.ImgService;
import com.apps.omnipotent.manager.service.RoleService;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.apps.omnipotent.system.utils.EVMUtils;
import com.apps.omnipotent.system.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class ImgServiceImpl extends GlobalServiceImpl implements ImgService {

    @Autowired
    ImgDao dao;

    @Override
    public Img getImgUrl(String type, String id) {
        return dao.findByCodeAndId(type, id);
    }

    @Override
    public Img createImg(String code, String id) {
        Img img = new Img();
        img.setCode(code);
        img.setUniqueKey(id);
        String url = EVMUtils.zxingCodeCreate(id, "D:/voice/picture/2018/",500,"D:/voice/picture/2018/5.jpg");
        img.setUrl(url);
        String imgId = img.save();

        return img;
    }
}
