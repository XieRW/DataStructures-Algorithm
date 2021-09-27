package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 剑指offer第十四题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-27 11:16
 **/
public class Jz14 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param pHead ListNode类
         * @param k     int整型
         * @return ListNode类
         */
        //解法一：双指针法
        public ListNode FindKthToTail(ListNode pHead, int k) {
            // write code here
            if (pHead == null) {
                return pHead;
            }
            ListNode first = pHead;
            for (int i = 0; i < k; i++) {
                if (first == null) {
                    return null;
                }
                first = first.next;
            }
            ListNode last = pHead;
            while (first != null) {
                first = first.next;
                last = last.next;
            }
            return last;
        }
    }
}
