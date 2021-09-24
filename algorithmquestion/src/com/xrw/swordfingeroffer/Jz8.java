package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: ½£Ö¸offerµÚ°ËÌâ
 * @author: Ğ»ÈÙÍú 1429382875@qq.com
 * @create: 2021-09-24 10:07
 **/
public class Jz8 {
    public class Solution {
        public int jumpFloor(int target) {
            int a=1,b=1;
            for (int i = 2; i <=target ; i++) {
                a=a+b;
                b=a-b;
            }
            return a;
        }
    }
}
