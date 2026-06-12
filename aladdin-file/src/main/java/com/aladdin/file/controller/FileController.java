package com.aladdin.file.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.file.service.FileService;
import com.aladdin.file.util.FileUploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传控制器
 *
 * @author cles
 * @date 2026/06/12
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    /** 上传文件 */
    @PostMapping("/upload")
    public R<FileUploadUtil.FileUploadResult> upload(@RequestParam("file") MultipartFile file) {
        return R.ok(fileService.upload(file));
    }

    /** 删除文件 */
    @DeleteMapping("/delete")
    public R<Void> delete(@RequestParam("path") String relativePath) {
        fileService.delete(relativePath);
        return R.ok();
    }
}
