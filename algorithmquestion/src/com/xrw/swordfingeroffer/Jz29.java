package com.xrw.swordfingeroffer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: DataStructures
 * @description: JZ29 最小的K个数
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-08 10:53
 **/
public class Jz29 {

    public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            ArrayList<Integer> collect = (ArrayList<Integer>) Arrays.stream(input).boxed().collect(Collectors.toList());
            collect.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            return (ArrayList<Integer>) collect.stream().limit(k).collect(Collectors.toList());
        }
    }
}