package com.aladdin.mis.system.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.ImgDao;
import com.aladdin.mis.manager.bean.Img;
import com.aladdin.mis.system.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class ImgServiceImpl extends GlobalServiceImpl<Img> implements ImgService {

    @Autowired
    private ImgDao dao;

    @Override
    public Img getImgUrl(String type, String id) {
        return dao.findByCodeAndId(type, id);
    }

    @Override
    public Img createImg(String code, String id) {
        Img img = new Img();
        img.setCode(code);
        img.setUniqueKey(id);
//        String url = EVMUtils.zxingCodeCreate(id, "D:/voice/picture/2018/",500,"D:/voice/picture/2018/5.jpg");
//        img.setUrl(url);
//        Integer imgId = img.save();

        return img;
    }
}
