package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 剑指offer第六题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-22 23:00
 **/
public class Jz6 {

    public class Solution {
        public int minNumberInRotateArray(int[] array) {
            if (array.length == 0) {
                return 0;
            }
            int low = 0;
            int mid = 0;
            int high = array.length - 1;
            while (low < high) {
                // 子数组是非递减的数组，10111
                if (array[low] < array[high]) {
                    return array[low];
                }
                mid = low + (high - low) / 2;
                if (array[mid] > array[low]) {
                    low = mid + 1;
                } else if (array[mid] < array[high]) {
                    high = mid;
                } else {
                    low++;
                }
            }
            return array[low];
        }
    }
}
