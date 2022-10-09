package com.aladdin.mis.common.utils;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * base64 一些转换
 * @author libia
 */
public class Base64Utils {

    /**
     * 图片转化成base64字符串
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     *
     * @param imgPath
     * @return
     */
    public static String GetImageStr(String imgPath) {
        // 待处理的图片
        String imgFile = imgPath;
        InputStream in = null;
        byte[] data = null;
        // 返回Base64编码过的字节数组字符串
        String encode = null;
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return encode;
    }

    public static void base64ToVideo(String base64, String videoFilePath) {
        if(base64.contains("base64,")){
            base64 = base64.substring(base64.indexOf("base64,")+7);
        }
        try {
            //base解密
            byte[] videoByte = new BASE64Decoder().decodeBuffer(base64);
            File videoFile = new File(videoFilePath);
            //输入视频文件
            FileOutputStream fos = new FileOutputStream(videoFile);
            fos.write(videoByte, 0, videoByte.length);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.err.println("base64转换为视频异常");
        }
    }

    /**
     * base64字符串转化成图片
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imgData
     *            图片编码
     * @param imgFilePath
     *            存放到本地路径
     * @return
     * @throws IOException
     */
    @SuppressWarnings("finally")
    public static boolean GenerateImage(String imgData, String imgFilePath) {
        // 图像数据为空
        if (StringUtils.isEmpty(imgData)) {
            return false;
        }
        if(imgData.contains("base64,")){
            imgData = imgData.substring(imgData.indexOf("base64,")+7);
        }
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgData);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.flush();
                out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return true;
        }
    }
}