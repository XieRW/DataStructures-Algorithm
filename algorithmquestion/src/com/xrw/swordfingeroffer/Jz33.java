package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ33 丑数
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-10 23:25
 **/
public class Jz33 {

    public class Solution {
        /**
         * 思路：我们可以维护三个list，分别是乘2得到的丑数，
         * 乘3得到的丑数，乘5得到的丑数，但这样复杂度较高，
         * 而且会得到重复的丑数。实际上每次我们只用比较3个数：
         * 用于乘2的最小的数、用于乘3的最小的数，
         * 用于乘5的最小的数。这样只需要维护三个指针，
         * 而不用维护三个数组。
         */
        public int GetUglyNumber_Solution(int index) {
            if (index < 7) {
                return index;
            }
            int i = 0, m = 0, n = 0;
            int[] num = new int[index];
            num[0] = 1;
            for (int j = 1; j < index; j++) {
                num[j] = Math.min(num[i] * 2, Math.min(num[m] * 3, num[n] * 5));
                if (num[j] == num[i] * 2) {
                    i++;
                }
                if (num[j] == num[m] * 3) {
                    m++;
                }
                if (num[j] == num[n] * 5) {
                    n++;
                }
            }
            return num[index - 1];
        }
    }
}
