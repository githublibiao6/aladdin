package com.aladdin.mis.omnipotent.manager.service.impl;

import com.aladdin.mis.omnipotent.manager.service.ImgService;
import com.aladdin.mis.omnipotent.manager.bean.Img;
import com.aladdin.mis.omnipotent.manager.dao.ImgDao;
import com.aladdin.mis.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.aladdin.mis.omnipotent.system.utils.EVMUtils;
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
