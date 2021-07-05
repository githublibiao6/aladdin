package com.apps.omnipotent.system.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
* @Description: 文件工具类
* @Author: cles
* @Date: 2020/4/15 0:18
*/
public class FileUtil {

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
