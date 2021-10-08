package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ8 ÌøÌ¨½×
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: Ð»ÈÙÍú 1429382875@qq.com
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
