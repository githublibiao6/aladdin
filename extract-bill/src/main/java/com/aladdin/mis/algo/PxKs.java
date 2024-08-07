package com.aladdin.mis.algo;

/**
 * 快速排序
 */
public class PxKs {
    public static void main(String[] args) {
        int[] array = new int[]{1010,88,1,3,12,4,5,188,6,45,7,8,18,20,22,39,49,100,999};
        ks(array, 0, array.length-1);
        for (int i : array){
            System.err.print(i + ",");
        }
    }
    // 自己实现
    // Hoare版本快排
    private static void ks(int[] array, int begin , int over) {
        int start = begin;
        int end = over;
        if(start >= end){
            return;
        }
        int num = array[start];
        while (start < end){
            while (start < end && num <= array[end]){
                end --;
            }
            while (start < end && num >= array[start]){
                start ++;
            }
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        // 基数替换到指定位置
        array[begin] = array[end];
        array[end] = num;
        // 快速左侧
        ks(array, begin, end - 1);
        // 快速右侧
        ks(array, end + 1, over);
    }

    private static void ksdesc(int[] array, int begin , int over) {
        int start = begin;
        int end = over;
        if(start >= end){
            return;
        }
        int num = array[start];
        while (start < end){
            while (start < end && num <= array[end]){
                end --;
            }
            while (start < end && num >= array[start]){
                start ++;
            }
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        // 基数替换到指定位置
        array[begin] = array[end];
        array[end] = num;
        // 快速左侧
        ksdesc(array, begin, end - 1);
        // 快速右侧
        ksdesc(array, end + 1, over);
    }

    // 挖坑法
    private static void ks2(int[] array, int begin , int over ) {
        int start = begin;
        int end = over;
        if(start >= end){
            return;
        }
        int index = begin;
        int num = array[start];
        while (start < end){
            while (start < end && array[end] >= num){
                end --;
            }
            if(array[end] <= num){
                array[start] = array[end];
                index = end;
            }
            while (start < end && array[start] <= num){
                start ++;
            }
            if(array[start] >= num){
                array[end] = array[start];
                index = start;
            }
            array[index] = num;
        }
        ks2(array, begin, index - 1);
        // 快速右侧
        ks2(array, index + 1, over);
    }
}
