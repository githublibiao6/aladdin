package com.aladdin.mis.file.service.impl;


import com.aladdin.mis.common.utils.FileUtil;
import com.aladdin.mis.file.service.FileVideoService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 上传图片
 * FilePicService
 * @author cles
 * @date 2022-05-25T00:29:11.438
*/
@Service
public class FileVideoServiceImpl implements FileVideoService {

    @Override
    public String uploadBase64(HttpServletRequest request, String base64) {
        // todo 上传文件工具
        return FileUtil.saveBase64Video(request, base64, "2");
    }
}
