package com.aladdin.mis.learn.algo;

/**
 * 冒泡排序
 */
public class PxMp {
    public static void main(String[] args) {
        int[] array = new int[]{88,1,2,12,4,5,6,7,8,18,20,22,39,49};

        mp(array);
        for (int i : array){
            System.err.print(i + ",");
        }

    }

    private static void mp(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
