package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 剑指offer第十一题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-26 10:56
 **/
public class Jz11 {
    public static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.NumberOf1(-1));
        }

        //解法1
        public int NumberOf1(int n) {
            int num = 0, flag = 1;
            //因为jvm本身就将n当做补码存储，不需要多此一举
//            if (n<0){
//                n = (1<<31)|(~n + 1);
//            }
            while (flag != 0) {
                if ((flag & n) != 0) {
                    num++;
                }
                flag <<= 1;
            }
            return num;
        }


    }
}
