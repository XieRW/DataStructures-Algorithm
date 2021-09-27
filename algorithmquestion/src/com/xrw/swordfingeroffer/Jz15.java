package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 剑指offer第十五题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-27 14:27
 **/
public class Jz15 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode ReverseList(ListNode head) {
            ListNode node = new ListNode(0);
            while (head != null) {
                ListNode temp = head;
                head = head.next;
                temp.next = node.next;
                node.next = temp;
            }
            return node.next;
        }
    }
}
