package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 剑指offer第十六题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-27 14:41
 **/
public class Jz16 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode Merge(ListNode list1, ListNode list2) {
            ListNode node = new ListNode(0);
            ListNode last = node;

            while (list1 != null) {
                while (list2 != null) {
                    if (list2.val <= list1.val) {
                        last.next = list2;
                        last = last.next;
                        list2 = list2.next;
                    } else {
                        break;
                    }
                }
                last.next = list1;
                last = last.next;
                list1 = list1.next;
            }
            last.next = list2;
            return node.next;
        }
    }
}
