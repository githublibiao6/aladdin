package com.aladdin.mis.file.service.impl;


import com.aladdin.mis.common.utils.FileUtil;
import com.aladdin.mis.file.service.FilePictureService;
import com.aladdin.mis.file.service.FileVideoService;

import javax.servlet.http.HttpServletRequest;

/**
 * 上传图片
 * FilePicService
 * @author cles
 * @date 2022-05-25T00:29:11.438
*/
public class FileVideoServiceImpl implements FileVideoService {


    @Override
    public String uploadBase64(HttpServletRequest request, String base64) {
        //上传文件工具
        return FileUtil.saveBase64Video(request,base64, "2");
    }
}
