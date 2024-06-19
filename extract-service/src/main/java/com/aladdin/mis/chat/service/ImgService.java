package com.aladdin.mis.chat.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.chat.manager.bean.Img;

/**
* @Description: 图片service
* @Author: cles
* @Date: 2020/4/15 23:48
*/
public interface ImgService extends GlobalService<Img> {

    /**
     * 功能描述：
     *  < 获取图片地址 >
     * @Description: getImgUrl
     * @Author: cles
     * @Date: 2020/7/13 22:11
     * @param type 参数1
     * @param id 参数2
     * @return: Img
     * @version: 1.0.0
     */
    Img getImgUrl(String type, String id);

    /**
     * 功能描述：
     *  < 创建图片数据 >
     * @Description: createImg
     * @Author: cles
     * @Date: 2020/7/13 22:37
     * @param type 参数1
     * @param id 参数2
     * @return: Img
     * @version: 1.0.0
     */
    Img createImg(String type, String id);

}
