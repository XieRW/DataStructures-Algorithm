package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 剑指offer第九题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-24 10:29
 **/
public class Jz9 {
    public class Solution {
        //解法一
        public int jumpFloorII(int target) {
            int a = 1;
            for (int i = 2; i <= target; i++) {
                a *= 2;
            }
            return a;
        }

        //解法二
        public int jumpFloorII2(int target) {
            return (int) Math.pow(2, target - 1);
        }

        //解法三
        public int jumpFloorII3(int target) {
            return 1 << (target - 1);
        }
    }
}
