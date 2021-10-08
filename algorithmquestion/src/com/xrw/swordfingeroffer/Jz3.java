package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: DataStructures
 * @description: JZ3 从尾到头打印链表
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
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
