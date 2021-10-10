package com.xrw.swordfingeroffer;

import java.util.LinkedList;

/**
 * @program: DataStructures
 * @description: JZ33 ³óÊı
 * @author: Ğ»ÈÙÍú 1429382875@qq.com
 * @create: 2021-10-10 23:25
 **/
public class Jz33 {
    public class Solution {
        public int GetUglyNumber_Solution(int index) {
            if (index < 7) return index;
            int i = 0, m = 0, n = 0;
            int[] num = new int[index];
            num[0] = 1;
            for (int j = 1; j < index; j++) {
                num[j] = Math.min(num[i] * 2, Math.min(num[m] * 3, num[n] * 5));
                if (num[j] == num[i] * 2) i++;
                if (num[j] == num[m] * 3) m++;
                if (num[j] == num[n] * 5) n++;
            }
            return num[index - 1];
        }
    }
}
