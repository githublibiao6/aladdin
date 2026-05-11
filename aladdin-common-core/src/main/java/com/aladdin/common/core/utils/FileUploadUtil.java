package com.aladdin.common.core.utils;

import com.aladdin.common.core.exception.BusinessException;
import com.aladdin.common.core.exception.GlobalErrorCode;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 文件上传工具
 *
 * @author cles
 * @date 2026/05/06
 */
public class FileUploadUtil {

    private static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;
    private static final String[] DEFAULT_ALLOWED_EXTENSIONS = {
            "jpg", "jpeg", "png", "gif", "bmp", "webp",
            "pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx",
            "txt", "zip", "rar", "7z", "csv"
    };

    public static FileUploadResult upload(MultipartFile file, String basePath) {
        return upload(file, basePath, DEFAULT_MAX_SIZE, DEFAULT_ALLOWED_EXTENSIONS);
    }

    public static FileUploadResult upload(MultipartFile file, String basePath,
                                           long maxSize, String[] allowedExtensions) {
        if (file == null || file.isEmpty()) {
            throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "上传文件不能为空");
        }
        if (file.getSize() > maxSize) {
            throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "文件大小超过限制");
        }

        String originalFilename = file.getOriginalFilename();
        String extension = getExtension(originalFilename);
        if (!isAllowedExtension(extension, allowedExtensions)) {
            throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "不支持的文件类型");
        }

        String datePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String newFilename = UUID.randomUUID().toString().replace("-", "") + "." + extension;
        String relativePath = datePath + "/" + newFilename;

        Path uploadPath = Paths.get(basePath, datePath);
        try {
            Files.createDirectories(uploadPath);
        } catch (IOException e) {
            throw new BusinessException(GlobalErrorCode.INTERNAL_ERROR, "创建上传目录失败");
        }

        Path filePath = uploadPath.resolve(newFilename);
        try {
            file.transferTo(filePath.toFile());
        } catch (IOException e) {
            throw new BusinessException(GlobalErrorCode.INTERNAL_ERROR, "文件保存失败");
        }

        FileUploadResult result = new FileUploadResult();
        result.setOriginalName(originalFilename);
        result.setFileName(newFilename);
        result.setRelativePath(relativePath);
        result.setAbsolutePath(filePath.toString());
        result.setFileSize(file.getSize());
        result.setExtension(extension);
        return result;
    }

    private static String getExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
    }

    private static boolean isAllowedExtension(String extension, String[] allowedExtensions) {
        if (allowedExtensions == null || allowedExtensions.length == 0) {
            return true;
        }
        for (String allowed : allowedExtensions) {
            if (allowed.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }

    public static class FileUploadResult {
        private String originalName;
        private String fileName;
        private String relativePath;
        private String absolutePath;
        private long fileSize;
        private String extension;

        public String getOriginalName() { return originalName; }
        public void setOriginalName(String originalName) { this.originalName = originalName; }
        public String getFileName() { return fileName; }
        public void setFileName(String fileName) { this.fileName = fileName; }
        public String getRelativePath() { return relativePath; }
        public void setRelativePath(String relativePath) { this.relativePath = relativePath; }
        public String getAbsolutePath() { return absolutePath; }
        public void setAbsolutePath(String absolutePath) { this.absolutePath = absolutePath; }
        public long getFileSize() { return fileSize; }
        public void setFileSize(long fileSize) { this.fileSize = fileSize; }
        public String getExtension() { return extension; }
        public void setExtension(String extension) { this.extension = extension; }
    }
}
