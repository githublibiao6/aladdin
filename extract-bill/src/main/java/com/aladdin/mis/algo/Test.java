package com.aladdin.mis.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 有字符串yujwedjhccdskdsewirewrwsadm,fnsdklwweqpq取出所有两个w之间的字符串并用归并排序
 * 归并排序
 */
public class Test {

    public static void main(String[] args) {
        String str = "yujwedjhccdskdsewirewrwsadm,fnsdklwweqpq";

        List<String> list = new ArrayList<>();
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if(array[i] == 'w' && i < array.length-1){
                for (int j = i+1; j < array.length; j++) {
                    if(array[j] == 'w'){
                        list.add(str.substring(i+1, j));
                    }
                }
            }
        }
//        for (String s : list){
//            if(s.length() > 1){
//                System.err.println(s);
//                char[] array1 = s.toCharArray();
//                sort(array1, 0, array1.length-1);
//                for (char c : array1){
//                    System.out.print(c);
//                }
//                System.out.println();
//            }
//        }
        String s ="edjhccdskdse";
        System.err.println(s);
        char[] array1 = s.toCharArray();
        sort(array1, 0, array1.length-1);
        for (char c : array1){
            System.out.print(c);
        }
        System.out.println();
    }

    private static void sort(char[] data, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        sort(data, left, mid);
        sort(data, mid + 1, right);
        // 合并
        merge2(data, left, mid, right);
    }

    public static void merge2(char[] data, int left, int center, int right) {
        char[] result = data.clone();
        int mid = center + 1;
        int temp = left;
        while (left <= center && mid <= right){
            if(result[left] <= result[mid] ){
                data[temp ++] = result[left ++];
            }else {
                data[temp ++] = result[mid ++];
            }
        }
    }

    public static void merge(char[] data, int left, int center, int right) {
        char[] tmpArr = new char[data.length];
        int mid = center + 1;
        int third = left;
        int tmp = left;
        // 对比复制到tmpArr
        while (left <= center && mid <= right) {
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 假设右侧多余，右侧全塞进去
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        // 假设左侧多余，左侧全塞进去
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 把temp复制到data
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }
}