package com.xrw.swordfingeroffer;

import java.util.HashMap;

/**
 * @program: DataStructures
 * @description: JZ36 两个链表的第一个公共结点
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-12 16:44
 **/
public class Jz36 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：运用HasnMap的特性
     */
    public class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode current1 = pHead1;
            ListNode current2 = pHead2;

            HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
            while (current1 != null) {
                hashMap.put(current1, null);
                current1 = current1.next;
            }
            while (current2 != null) {
                if (hashMap.containsKey(current2)) {
                    return current2;
                }
                current2 = current2.next;
            }

            return null;

        }
    }

    /**
     * 方法2：
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 两连表的长度差

        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }

        }
        // 如果链表2的长度大于链表1的长度
        else if (length1 < length2) {
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }
        //开始齐头并进，直到找到第一个公共结点
        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1;

    }

    /**
     * 求指定链表的长度
     */
    public static int getLength(ListNode pHead) {
        int length = 0;

        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * 方法三：用两个指针扫描“两个链表”，最终两个指针到达 null 或者到达公共结点。
     */
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? pHead2 : temp1.next;
            temp2 = (temp2 == null) ? pHead1 : temp2.next;
        }

        return temp1;
    }
}
