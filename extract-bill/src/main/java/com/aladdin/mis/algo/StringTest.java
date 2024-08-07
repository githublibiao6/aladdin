package com.aladdin.mis.algo;
/*
 *  Created by cles on 2024/8/7 22:18
 */

/**
 * @author cles
 * @description:
 * @Date 2024/8/7 22:18
 * @version: 1.0.0
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "ddd";
        String s2 = "ddd";
        String s3 = new String("ddd");
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);

        StringBuilder s = new StringBuilder();
        s.append("1");
        StringBuffer ss = new StringBuffer();
        ss.append("1");
    }
}
