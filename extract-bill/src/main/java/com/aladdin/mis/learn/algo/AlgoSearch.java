package com.aladdin.mis.learn.algo;

/**
 * 二分查找
 */
public class AlgoSearch {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,18,20,22,39,49};

        int temp = search(array, 1, 0, array.length-1);
        System.err.println("查询到下标位置" + temp);

    }

    private static int search(int[] array, int num, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(array[mid] == num){
            return mid;
        }else if(array[mid] > num){
            return search(array, num, 0, mid-1);
        }else if(array[mid] < num) {
            return search(array, num, mid + 1 , end);
        }
        return -1;
    }
}
