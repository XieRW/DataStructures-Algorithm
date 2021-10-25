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
        solution.FindNumsAppearOnce(new int[]{3, 6});
    }

    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 解法一：用一个元素去保存原数组中每个元素出现的次数，然后取其中出现次数为1的元素
         *
         * @param array int整型一维数组
         * @return int整型一维数组
         */
        public int[] FindNumsAppearOnce(int[] array) {
            // write code here
            int[] nums = new int[1000001];
            for (int i = 0; i < array.length; i++) {
                nums[array[i]]++;
            }
            int[] target = new int[2];
            int p = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    target[p] = i;
                    p++;
                }
            }
            return target;
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 解法二：用map去保存原数组中每个元素出现的次数，然后取其中出现次数为1的元素
         *
         * @param array int整型一维数组
         * @return int整型一维数组
         */
        public int[] FindNumsAppearOnce2(int[] array) {
            // write code here
            Map<Integer, Integer> map = new HashMap<>(16);
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])) {
                    map.put(array[i], map.get(array[i]) + 1);
                } else {
                    map.put(array[i], 1);
                }
            }
            int[] target = new int[2];
            int p = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    target[p] = entry.getKey();
                    p++;
                }
            }
            int min = Math.min(target[0], target[1]);
            int max = Math.max(target[0], target[1]);
            target[0] = min;
            target[1] = max;
            return target;
        }

        /**
         * 解法三：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
         * 先考虑另一个问题，一个整型数组里除了一个数字之外，其他的数字都出现了两次，那把所有的数据异或起来，异或的结果就是那一个数字。
         * （因为出现过两次的数字异或起来就抵消了）
         * <p>
         * 对于这个题来说，如果把数字全异或起来，最后异或出来的结果是不同的那两个数的异或，
         * 然后随便从异或结果里面找一位1，因为某一位上异或结果是1的话，说明要找两个数，这一位上一个是1，一个是0。
         * 那么就可以把原来数组中，这一位是1的分成一组，这一位是0的分成一组。
         * 这样就有了两组每一组中会包含一个不同的数和一部分出现两次的数。 然后组内异或就可以了。
         *
         * @param array
         * @return
         */
        public int[] FindNumsAppearOnce3(int[] array) {
            int[] ans = new int[2];
            int ans1 = 0, ans2 = 0;
            int XORsum = 0;
            for (int i = 0; i < array.length; i++) {
                XORsum ^= array[i];
            }
            int t = 1;//找出异或和中哪一位是1
            while ((XORsum & t) == 0) {
                t <<= 1;
            }
            for (int i = 0; i < array.length; i++) {
                if ((t & array[i]) == 0) {
                    ans1 ^= array[i];
                } else {
                    ans2 ^= array[i];
                }
            }
            if (ans1 < ans2) {
                ans[0] = ans1;
                ans[1] = ans2;
            } else {
                ans[0] = ans2;
                ans[1] = ans1;
            }
            return ans;
        }
    }
}
