package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ16 合并两个排序的链表
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
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
