package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 数组中重复的数字
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-11-02 16:00
 **/
public class Jz56 {


    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param numbers int整型一维数组
         * @return int整型
         */
        public int duplicate(int[] numbers) {
            // write code here
            int[] ints = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] >= numbers.length || numbers[i] < 0) {
                    return -1;
                }
                if (ints[numbers[i]] != 1) {
                    ints[numbers[i]] = 1;
                } else {
                    return numbers[i];
                }
            }
            return -1;
        }
    }
}
