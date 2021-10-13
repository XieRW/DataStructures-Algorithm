package com.xrw.swordfingeroffer;

import java.util.ArrayList;

/**
 * @program: DataStructures
 * @description: JZ42 和为S的两个数字
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-13 15:17
 **/
public class Jz42 {
    /**
     * 解法一：双循环暴力解法
     */
    public class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            ArrayList<Integer> list = new ArrayList<>();
            if (array.length < 2) {
                return list;
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] + array[j] == sum) {
                        list.add(array[i]);
                        list.add(array[j]);
                        return list;
                    }
                }
            }
            return list;
        }
    }

    /**
     * 解法二：双指针法
     */
    public class Solution2 {
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            ArrayList<Integer> list = new ArrayList<>();
            if (array.length < 2) {
                return list;
            }
            int start = 0, end = array.length - 1;
            while (start < end) {
                if (array[start] + array[end] > sum) {
                    end--;
                } else if (array[start] + array[end] < sum) {
                    start++;
                } else {
                    list.add(array[start]);
                    list.add(array[end]);
                    return list;
                }
            }
            return list;
        }
    }
}
