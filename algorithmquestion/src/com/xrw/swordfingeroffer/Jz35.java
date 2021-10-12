package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ35 数组中的逆序对
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-12 10:15
 **/
public class Jz35 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int count = 0;
        while (count>=0){
            count++;
        }
        System.out.println(2147483647+1);
    }
    public class Solution {

        public int InversePairs(int [] array) {
            if (array.length == 0){
                return 0;
            }
            int count = 0;
            for (int i = 0; i < array.length-1; i++) {
                for (int j = i+1; j < array.length; j++) {
                    if (array[i] > array[j]){
                        count++;
                        count%=1000000007;
                    }
                }
            }
            return count;
        }


    }
}
