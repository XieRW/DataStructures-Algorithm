package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ15 ·´×ªÁ´±í
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: Ð»ÈÙÍú 1429382875@qq.com
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
