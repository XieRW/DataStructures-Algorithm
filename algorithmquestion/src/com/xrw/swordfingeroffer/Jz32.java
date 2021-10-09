package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @program: DataStructures
 * @description: JZ32 把数组排成最小的数
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-09 23:23
 **/
public class Jz32 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.PrintMinNumber(new int[]{3, 5, 1, 4, 2}));
    }

    /**
     * 利用了贪心的思想，既然整个序列是最小的，
     * 那么越靠前的序列肯定也是最小的，
     * 任何两个序列的组合也是较小的。
     * 同时将两个字符串按不同顺序相加得到的长度也是相等的，
     * 此时就可以简单地使用compareTo的方法来做比较。
     */
    public static class Solution {
        public String PrintMinNumber(int[] numbers) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i : numbers) {
                arrayList.add(i + "");
            }
            Collections.sort(arrayList, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
            StringBuilder builder = new StringBuilder();
            for (String s : arrayList
            ) {
                builder.append(s);
            }
            return builder.toString();
        }

    }
}
