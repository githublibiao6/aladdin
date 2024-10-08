package com.aladdin.mis.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @description: 文件工具类
 * @author: sunhx
 * @date: 2018/7/17
 */
public class FileUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 上传附件
     * @param request
     * @param file
     * @param typePath
     * @param uploadPath 上传路径
     * @return
     */
    public static String saveFile(ServletRequest request, MultipartFile file, String typePath , String uploadPath) {
        String serverName = request.getServerName();
        String serverPort = String.valueOf(request.getServerPort());
        String contextPath = "http://"+serverName+":"+serverPort+"/";
        String url = contextPath + uploadPath + typePath + "/";

        LOGGER.debug("url : {}",url);
        File path = null;

        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            LOGGER.error(e.toString());
        }
        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), uploadPath + typePath + "/");
        if (!upload.exists()) {
            upload.mkdirs();
        }

        String absolutePath = upload.getAbsolutePath();
        String fileName = file.getOriginalFilename();
        String[] fileExt = fileName.split("\\.");
        String ext = fileExt[fileExt.length - 1];
        if (fileName.equals(ext)) {
            // 未知的文件类型
            LOGGER.error("-----unknow file type ,unknow file suffix-----");
            return null;
        }
        String newFileName = UUID.randomUUID().toString() + "." + ext;
        try {
            File newLocalFile = new File(absolutePath, newFileName);
            FileCopyUtils.copy((File) file, newLocalFile);
        } catch (IOException e1) {
            LOGGER.error("-----image file save local exceprion:{}-----", e1.getMessage());
        }
        return uploadPath  + typePath + "/" + newFileName;
    }

    /**
     *
     * @param request
     * @param file
     * @param typePath
     * @return
     */
    public static String saveFileWe(ServletRequest request, MultipartFile file, String typePath) {
        String serverName = request.getServerName();
        String serverPort = String.valueOf(request.getServerPort());
        String contextPath = "http://"+serverName+":"+serverPort+"/";
        String url = contextPath + Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/";

        LOGGER.debug("url : {}",url);

        File path = null;

        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {

            LOGGER.error(e.toString());
        }
        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/");
        if (!upload.exists()) {
            upload.mkdirs();
        }

        String absolutePath = upload.getAbsolutePath();
        String fileName = file.getOriginalFilename();
        String[] fileExt = fileName.split("\\.");
        String ext = fileExt[fileExt.length - 1];
        if (fileName.equals(ext)) {
            // 未知的文件类型
            LOGGER.error("-----unknow file type ,unknow file suffix-----");
            return null;
        }
        String newFileName = UUID.randomUUID().toString() + "." + ext;
        try {
            File newLocalFile = new File(absolutePath, newFileName);
            FileCopyUtils.copy((File) file, newLocalFile);
        } catch (IOException e1) {
            LOGGER.error("-----image file save local exceprion:{}-----", e1.getMessage());
        }
        return Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/" + newFileName;
    }


    public static String saveBase64File(HttpServletRequest request, String base64, String typePath) {
        String serverName = request.getServerName();
        String serverPort = String.valueOf(request.getServerPort());
        String contextPath = "http://"+serverName+":"+serverPort+"/";
        String url = contextPath + Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/";

        LOGGER.debug("url : {}",url);

        File path = null;

        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {

            LOGGER.error(e.toString());
        }
        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/");
        if (!upload.exists()) {
            upload.mkdirs();
        }

        String absolutePath = upload.getAbsolutePath();
        String[] pic = base64.split(";");
        String info = pic[0];
        String[] extArr = info.split("/");
        if (extArr.length < 2) {
            // 未知的文件类型
            LOGGER.error("-----unknow file type ,unknow file suffix-----");
            return null;
        }

        String newFileName = UUID.randomUUID().toString() + "." + extArr[1];
        try {
            File newLocalFile = new File(absolutePath, newFileName);
            Base64Utils.generateImage(base64 , newLocalFile.getAbsolutePath());
        } catch (Exception e1) {
            LOGGER.error("-----image file save local exceprion:{}-----", e1.getMessage());
        }
        return Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/" + newFileName ;
    }

    public static String saveBase64Video(HttpServletRequest request, String base64, String typePath) {
        String serverName = request.getServerName();
        String serverPort = String.valueOf(request.getServerPort());
        String contextPath = "http://"+serverName+":"+serverPort+"/";
        String url = contextPath + Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/";

        LOGGER.debug("url : {}",url);

        File path = null;

        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {

            LOGGER.error(e.toString());
        }
        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/");
        if (!upload.exists()) {
            upload.mkdirs();
        }

        String absolutePath = upload.getAbsolutePath();
        String[] pic = base64.split(";");
        String info = pic[0];
        String[] extArr = info.split("/");
        if (extArr.length < 2) {
            // 未知的文件类型
            LOGGER.error("-----unknow file type ,unknow file suffix-----");
            return null;
        }

        String newFileName = UUID.randomUUID().toString() + "." + extArr[1];
        try {
            File newLocalFile = new File(absolutePath, newFileName);
            Base64Utils.base64ToVideo(pic[1] , newLocalFile.getAbsolutePath());
        } catch (Exception e1) {
            LOGGER.error("-----image file save local exceprion:{}-----", e1.getMessage());
        }
        return Constant.UPLOAD_ATTACHMENT_URL  + typePath + "/" + newFileName ;
    }


    /**
     * @Description:  下载文件
     * @Param: [response, file]
     * @return: void
     * @Author: cles
     * @Date: 2020/4/15 0:20
     */
    public static void downLoadFile(HttpServletResponse response, File file) {
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=" + file.getName());
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
