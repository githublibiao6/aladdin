package com.aladdin.mis.learn.algo;

/**
 * 插入排序
 */
public class PxCr {
    public static void main(String[] args) {
        int[] array = new int[]{101,88,1,2,12,4,5,188,7,7,8,18,20,22,39,49,100,999};
        cr(array);
        for (int i : array){
            System.err.print(i + ",");
        }
    }
    // 自己实现
    private static void cr(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            for (int j = i -1; j >= 0; j--) {
                if(num < array[j]){
                    array[j + 1] = array[j];
                    array[j] = num;
                }
            }
        }
    }

    /**
     * 本质也是
     * @param array array
     */
    private static void cr2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            int j = i - 1;
            while (j >= 0 && num < array[j] ){
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = num;
        }
    }
}
