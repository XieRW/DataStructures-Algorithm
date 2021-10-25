package com.xrw.swordfingeroffer;

import java.util.ArrayList;

/**
 * @program: DataStructures
 * @description: JZ41 和为S的连续正数序列
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-13 14:48
 **/
public class Jz41 {
    /**
     * 思路：
     * 输入sum=20（1，2，3，4，5，6，7，8，9，10，11，12，13，14，15
     * 1，定义两个指针，左指针从1开始，右指针从2开始
     * 循环开始
     * 2，求和（1+2 = 3
     * 3，如果判断3小于20，右指针++，2变为3，求和3+3=6。循环一直到右指针=6，和为21。
     * 4，else if 判断21大于20，左指针++，1变为2，和减去左指针值，和为21-1=20。
     * 5，else 和与输入一样，存数。   【再把右指针++，求和，求剩余组合】
     * 循环结束
     */
    public class Solution {
        public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            if (sum <= 1) {
                return lists;
            }
            int left = 1, right = 2, tempSum = left + right;
            while (right <= sum / 2 + 1) {
                if (tempSum < sum) {
                    right++;
                    tempSum += right;
                } else if (tempSum > sum) {
                    tempSum -= left;
                    left++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = left; i <= right; i++) {
                        list.add(i);
                    }
                    lists.add(list);
                    right++;
                    tempSum += right;
                }
            }
            return lists;
        }
    }
}
