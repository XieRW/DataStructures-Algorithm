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
        System.out.println(solution.PrintMinNumber(new int[]{3,5,1,4,2}));
    }

    public static class Solution {
        public String PrintMinNumber(int [] numbers) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i:numbers) {
                arrayList.add(i+"");
            }
            Collections.sort(arrayList,((o1, o2) -> (o1+o2).compareTo(o2+o1)));
            StringBuilder builder = new StringBuilder();
            for (String s:arrayList
                 ) {
                builder.append(s);
            }
            return builder.toString();
        }

    }
}
