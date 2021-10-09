package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ31 整数中1出现的次数（从1到n整数中1出现的次数）
 * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-09 22:43
 **/
public class Jz31 {
    public class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            int num;
            int sum = 0;
            int x;
            for (int i = 1; i <= n; i++) {
                num = i;
                while (num != 0){
                    x = num%10;
                    if (x == 1){
                        sum++;
                    }
                    num = num/10;
                }
            }
            return sum;
        }
    }
}
