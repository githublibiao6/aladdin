package com.aladdin.mis.algo;

/**
 * 快速排序
 */
public class PxXe {
    public static void main(String[] args) {
        int[] array = new int[]{1010,88,1,3,12,4,5,188,6,45,7,8,18,20,22,39,49,100,999};
        xe(array);
        for (int i : array){
            System.err.print(i + ",");
        }
    }
    // 自己实现
    private static void xe(int[] array) {
        int dk = array.length/2;
        while( dk >= 1 ){
            xe(array, 1);
            dk = dk/2;
        }

    }

    private static void xe(int[] a, int dk) {

        for(int i=dk;i<a.length;i++){
            if(a[i]<a[i-dk]){
                int j;
                //x 为待插入元素
                int x=a[i];
                a[i]=a[i-dk];
                for(j=i-dk; j>=0 && x<a[j];j=j-dk){
                    //通过循环，逐个后移一位找到要插入的位置。
                    a[j+dk]=a[j];
                }
                a[j+dk]=x;//插入
            }
        }
    }

    private static void xea(int[] array, int dk) {

        for (int i = dk; i < array.length; i++) {
            if(array[i] < array[i-dk]){
                int temp = array[i];
                array[i] = array[i-dk];
                array[i-dk] = temp;
            }
        }
    }
}
