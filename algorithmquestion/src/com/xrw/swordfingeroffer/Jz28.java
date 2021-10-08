package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ28 数组中出现次数超过一半的数字
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-08 10:29
 **/
public class Jz28 {
    public class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            if (array.length == 0){
                return 0;
            }
            int count = 1;
            int preValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] == preValue){
                    count++;
                }else {
                    count--;
                    if (count == 0){
                        preValue = array[i];
                        count = 1;
                    }
                }
            }

            int num = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == preValue){
                    num++;
                }
            }
            return (num>array.length/2)?preValue:0;
        }
    }
}
