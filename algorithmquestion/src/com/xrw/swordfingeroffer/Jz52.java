package com.xrw.swordfingeroffer;

import java.util.*;
/**
 * @program: DataStructures
 * @description: 滑动窗口的最大值
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-11-01 11:18
 **/
public class Jz52 {
    /**
     * 第一种方法，暴力递归
     */
    public class Solution {
        public ArrayList<Integer> maxInWindows(int [] num, int size) {
            ArrayList<Integer> list = new ArrayList<>();
            if (size==0 || size>num.length){
                return list;
            }
            for (int i = 0; i <= num.length-size; i++) {
                int[] ints = Arrays.copyOfRange(num, i, size + i);
                Arrays.sort(ints);
                list.add(ints[ints.length-1]);
            }
            return list;
        }
    }
    /**
     * 第二种方法，双端队列
     * 遍历数组的每一个元素，
     * 如果容器为空，则直接将当前元素加入到容器中。
     * 如果容器不为空，则让当前元素和容器的最后一个元素比较，如果大于，则将容器的最后一个元素删除，然后继续讲当前元素和容器的最后一个元素比较
     * 如果当前元素小于容器的最后一个元素，则直接将当前元素加入到容器的末尾
     * 如果容器头部的元素已经不属于当前窗口的边界，则应该将头部元素删除
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size==0 || size>num.length){
            return list;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= num.length; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()]<num[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst()+size<=i){
                deque.pollFirst();
            }
            if (i+1>=size){
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }
}
