package com.aladdin.mis.file.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 上传图片
 * FilePicService
 * @author cles
 * @date 2022-05-25T00:29:11.438
*/
public interface FileExcelService {


    /**
     * 上传excel文件
     * @param request
     * @param base64
     * @return
     */
    String uploadBase64(HttpServletRequest request, String base64);
}
