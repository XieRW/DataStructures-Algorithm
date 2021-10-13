package com.xrw.swordfingeroffer;

import java.util.*;
/**
 * @program: DataStructures
 * @description: JZ40 数组中只出现一次的两个数字
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-13 14:11
 **/
public class Jz40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.FindNumsAppearOnce(new int[]{3,6});
    }

    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 解法一：用一个元素去保存原数组中每个元素出现的次数，然后取其中出现次数为1的元素
         *
         * @param array int整型一维数组
         * @return int整型一维数组
         */
        public int[] FindNumsAppearOnce (int[] array) {
            // write code here
            int[] nums = new int[1000001];
            for (int i = 0; i < array.length; i++) {
                nums[array[i]]++;
            }
            int[] target = new int[2];
            int p = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==1){
                    target[p] = i;
                    p++;
                }
            }
            return target;
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 解法二：用map去保存原数组中每个元素出现的次数，然后取其中出现次数为1的元素
         *
         * @param array int整型一维数组
         * @return int整型一维数组
         */
        public int[] FindNumsAppearOnce2 (int[] array) {
            // write code here
            Map<Integer,Integer> map = new HashMap<>(16);
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])){
                    map.put(array[i],map.get(array[i])+1);
                }else {
                    map.put(array[i],1);
                }
            }
            int[] target = new int[2];
            int p = 0;
            for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
                if (entry.getValue() == 1){
                    target[p] = entry.getKey();
                    p++;
                }
            }
            int min = Math.min(target[0],target[1]);
            int max = Math.max(target[0],target[1]);
            target[0] = min;
            target[1] = max;
            return target;
        }
    }
}
