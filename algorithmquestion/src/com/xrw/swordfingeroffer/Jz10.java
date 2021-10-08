package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ10 ¾ØÐÎ¸²¸Ç
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: Ð»ÈÙÍú 1429382875@qq.com
 * @create: 2021-09-26 10:39
 **/
public class Jz10 {
    public class Solution {
        public int rectCover(int target) {
            if (target == 0) {
                return 0;
            }
            int a = 1, b = 1;
            for (int i = 2; i <= target; i++) {
                a = a + b;
                b = a - b;
            }
            return a;
        }
    }
}
