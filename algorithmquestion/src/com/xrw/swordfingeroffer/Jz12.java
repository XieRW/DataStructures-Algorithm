package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ12 数值的整数次方
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-27 10:06
 **/
public class Jz12 {
    public class Solution {
        public double Power(double base, int exponent) {
            if (base == 0) {
                return 0;
            }
            if (exponent == 0) {
                return 1;
            }
            double sum = 1;
            for (int i = 0; i < Math.abs(exponent); i++) {
                sum *= base;
            }
            if (exponent < 0) {
                sum = 1 / sum;
            }
            return sum;
        }
    }
}
