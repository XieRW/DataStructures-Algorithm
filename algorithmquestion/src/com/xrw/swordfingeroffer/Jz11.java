package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ11 二进制中1的个数
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
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

        //解法二:独特思路,整数n，进行n&(n-1)运算，会把二进制表示中最右边的1变为0。
        public int NumberOf2(int n) {
            int num = 0;
            while (n != 0) {
                num++;
                n &= (n - 1);
            }
            return num;
        }
    }
}
