package com.xrw.swordfingeroffer;

import java.util.*;
/**
 * @program: DataStructures
 * @description: 滑动窗口的最大值
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-11-01 11:18
 **/
public class Jz52 {
    public class Solution {
        public ArrayList<Integer> maxInWindows(int [] num, int size) {
            if (size==0 || size>num.length){
                return null;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i <= num.length-size; i++) {
                int[] ints = Arrays.copyOfRange(num, i, size + i);
                Arrays.sort(ints);
                list.add(ints[ints.length-1]);
            }
            return list;
        }
    }
}
