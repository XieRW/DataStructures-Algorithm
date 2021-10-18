package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 删除链表中重复的结点
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-18 15:46
 **/
public class Jz44 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：建立一个新的头结点，遍历原链表，如果有重复的，找到这些重复元素，然后删除，最后返回新的头结点的next
     */
    public class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            ListNode head = new ListNode(0);
            head.next = pHead;
            ListNode temp = head;
            while (pHead!=null){
                if (pHead.next!=null&&pHead.val == pHead.next.val){
                    pHead=pHead.next;
                    while (pHead.next!=null&&pHead.val == pHead.next.val){
                        pHead=pHead.next;
                    }
                    temp.next = pHead.next;
                }else {
                    temp = temp.next;
                }
                pHead = pHead.next;
            }
            return head.next;
        }
    }
}
