package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 剑指offer第十题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-26 10:39
 **/
public class Jz10 {
    public class Solution {
        public int rectCover(int target) {
            if (target == 0){
                return 0;
            }
            int a=1,b=1;
            for (int i = 2; i <= target; i++) {
                a = a + b;
                b = a - b;
            }
            return a;
        }
    }
}
