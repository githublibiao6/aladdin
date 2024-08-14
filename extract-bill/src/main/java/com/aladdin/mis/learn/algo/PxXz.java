package com.aladdin.mis.learn.algo;

/**
 * 选择排序
 */
public class PxXz {
    public static void main(String[] args) {
        int[] array = new int[]{1010,88,1,3,12,4,5,188,6,45,7,8,18,20,22,39,49,100,999};
        xz(array);
        for (int i : array){
            System.err.print(i + ",");
        }
    }

    // 自己实现
    private static void xz(int[] array) {
        for (int i = array.length -1 ; i >= 0; i--) {

            int max = -1;
            int index = -1;
            for (int j = 0; j < array.length-1; j++) {
                if(array[j] > max){
                    max = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = max;
            array[index] = temp;

        }

    }

}
