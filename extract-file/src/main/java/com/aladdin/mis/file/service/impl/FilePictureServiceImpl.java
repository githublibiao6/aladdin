package com.aladdin.mis.file.service.impl;


import com.aladdin.mis.common.utils.FileUtil;
import com.aladdin.mis.file.service.FilePictureService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 上传图片
 * FilePicService
 * @author cles
 * @date 2022-05-25T00:29:11.438
*/
@Service
public class FilePictureServiceImpl implements FilePictureService {


    @Override
    public String uploadBase64(HttpServletRequest request, String base64) {
        //上传文件工具
        return FileUtil.saveBase64File(request, base64, "1");
    }

    public static void main(String[] args) {

    }
}
