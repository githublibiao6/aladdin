package com.company.system.common.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 工具类 MD5加密
 * @author lb
 * @date 2018年6月14日 下午10:06:43
 */
public class MD5Util {
 /***
 * MD5加码 生成32位md5码
 */
public static String MD5(String inStr){
    MessageDigest md5 = null;
    try{  
        md5 = MessageDigest.getInstance("MD5");  
    }catch (Exception e){   
        return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }  
  
    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertTwo(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
    
	private static  Key key ;  
	static{
		setKey("1278gggg48854");
}
private static void setKey(String strKey) {  
   try {  
       KeyGenerator _generator = KeyGenerator.getInstance ( "DES" );  
       _generator.init( new SecureRandom(strKey.getBytes()));  
        key = _generator.generateKey();  
       _generator = null ;  
   } catch (Exception e) {  
       throw new RuntimeException(  
              "Error initializing SqlMap class. Cause: " + e);  
   }  
}  
//   
/**
 * 加密 String 明文输入 ,String 密文输出
 */
public static String encryptStr(String strMing) {  
   byte [] byteMi = null ;  
   byte [] byteMing = null ;  
   String strMi = "" ;  
   BASE64Encoder base64en = new BASE64Encoder();  
   try {  
       byteMing = strMing.getBytes( "UTF8" );  
       byteMi = encryptByte(byteMing);  
       strMi = base64en.encode(byteMi);  
   } catch (Exception e) {  
       throw new RuntimeException(  
              "Error initializing SqlMap class. Cause: " + e);  
       } finally {  
           base64en = null ;  
           byteMing = null ;  
           byteMi = null ;  
       }  
       return strMi;  
    }  
   
    /**
 * 解密 以 String 密文输入 ,String 明文输出
 *
 * @param strMi
 * @return
 */
public static String decryptStr(String strMi) {  
   BASE64Decoder base64De = new BASE64Decoder();  
   byte [] byteMing = null ;  
   byte [] byteMi = null ;  
   String strMing = "" ;  
   try {  
       byteMi = base64De.decodeBuffer(strMi);  
       byteMing = decryptByte(byteMi);  
       strMing = new String(byteMing, "UTF8" );  
   } catch (Exception e) {  
       throw new RuntimeException(  
              "Error initializing SqlMap class. Cause: " + e);  
       } finally {  
           base64De = null ;  
           byteMing = null ;  
           byteMi = null ;  
       }  
       return strMing;  
    }  
   
    /**
 * 加密以 byte[] 明文输入 ,byte[] 密文输出
 *
 * @param byteS
 * @return
 */
private static byte [] encryptByte( byte [] byteS) {  
   byte [] byteFina = null ;  
   Cipher cipher;  
   try {  
       cipher = Cipher.getInstance ( "DES" );  
       cipher.init(Cipher. ENCRYPT_MODE , key );  
       byteFina = cipher.doFinal(byteS);  
   } catch (Exception e) {  
       throw new RuntimeException(  
              "Error initializing SqlMap class. Cause: " + e);  
       } finally {  
           cipher = null ;  
       }  
       return byteFina;  
    }  
   
    /**
 * 解密以 byte[] 密文输入 , 以 byte[] 明文输出
 *
 * @param byteD
 * @return
 */
private static byte [] decryptByte( byte [] byteD) {  
   Cipher cipher;  
   byte [] byteFina = null ;  
   try {  
       cipher = Cipher.getInstance ( "DES" );  
       cipher.init(Cipher. DECRYPT_MODE , key );  
       byteFina = cipher.doFinal(byteD);  
   } catch (Exception e) {  
       throw new RuntimeException(  
              "Error initializing SqlMap class. Cause: " + e);  
       } finally {  
           cipher = null ;  
       }  
       return byteFina;  
    }  
   
    /**
 * 文件 file 进行加密并保存目标文件 destFile 中
 *
 * @param file
 *             要加密的文件 如 c:/test/srcFile.txt
 * @param destFile
 *             加密后存放的文件名 如 c:/ 加密后文件 .txt
 */
public static void encryptFile(String file, String destFile) throws Exception {  
   Cipher cipher = Cipher.getInstance ( "DES" );  
   // cipher.init(Cipher.ENCRYPT_MODE, getKey());  
       cipher.init(Cipher. ENCRYPT_MODE ,  key );  
       InputStream is = new FileInputStream(file);  
       OutputStream out = new FileOutputStream(destFile);  
       CipherInputStream cis = new CipherInputStream(is, cipher);  
       byte [] buffer = new byte [1024];  
       int r;  
       while ((r = cis.read(buffer)) > 0) {  
           out.write(buffer, 0, r);  
       }  
       cis.close();  
       is.close();  
       out.close();  
    }  
   
    /**
 * 文件采用 DES 算法解密文件
 *
 * @param file
 *             已加密的文件 如 c:/ 加密后文件 .txt *
 * @param destFile  解密后存放的文件名 如 c:/ test/ 解密后文件 .txt
 */
public static void decryptFile(String file, String dest) throws Exception {  
   Cipher cipher = Cipher.getInstance ( "DES" );  
       cipher.init(Cipher. DECRYPT_MODE ,  key );  
       InputStream is = new FileInputStream(file);  
       OutputStream out = new FileOutputStream(dest);  
       CipherOutputStream cos = new CipherOutputStream(out, cipher);  
       byte [] buffer = new byte [1024];  
       int r;  
       while ((r = is.read(buffer)) >= 0) {  
           cos.write(buffer, 0, r);  
       }  
       cos.close();  
       out.close();  
       is.close();  
    }  

}