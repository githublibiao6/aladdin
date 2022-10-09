package com.aladdin.mis.file.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 上传图片
 * FilePicService
 * @author cles
 * @date 2022-05-25T00:29:11.438
*/
@Service
public interface FilePictureService {

    /**
     * 处理上传图片
     * @param request
     * @param base64
     * @return
     */
    String uploadBase64(HttpServletRequest request, String base64);
}
