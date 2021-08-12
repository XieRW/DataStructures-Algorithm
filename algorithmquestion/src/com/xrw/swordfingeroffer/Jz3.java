package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: DataStructures
 * @description: 牛客网剑指offer第三题
 * 描述
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 * <p>
 * 如输入{1,2,3}的链表如下图:
 * <p>
 * 返回一个数组为[3,2,1]
 * <p>
 * 0 <= 链表长度 <= 10000
 * 示例1
 * 输入：
 * {1,2,3}
 * 复制
 * 返回值：
 * [3,2,1]
 * 复制
 * 示例2
 * 输入：
 * {67,0,24,58}
 * 复制
 * 返回值：
 * [58,24,0,67]
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-12 16:28
 **/
public class Jz3 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    //解法一
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        while (listNode != null) {
//            list.add(0, listNode.val);
//            listNode = listNode.next;
//        }
//        return list;
//    }

    //解法二 利用递归，即利用系统的栈
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
