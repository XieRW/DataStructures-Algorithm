package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DataStructures
 * @description: JZ25 复杂链表的复制
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-29 17:22
 **/
public class Jz25 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 思路：把节点放到列表里，然后遍历列表复制节点数据，第二次遍历列表复制节点random指针
     */
    public class Solution {
        public RandomListNode Clone(RandomListNode pHead) {
            List<RandomListNode> list = new ArrayList<>();
            List<RandomListNode> list2 = new ArrayList<>();
            while (pHead != null) {
                list.add(pHead);
                pHead = pHead.next;
            }
            if (list.size() <= 0) {
                return null;
            }
            RandomListNode node = new RandomListNode(list.get(0).label);
            RandomListNode head = node;
            list2.add(node);
            for (int i = 1; i < list.size(); i++) {
                node.next = new RandomListNode(list.get(i).label);
                node = node.next;
                list2.add(node);
            }
            for (int i = 0; i < list.size(); i++) {
                int random = list.indexOf(list.get(i).random);
                if (random > -1) {
                    list2.get(i).random = list2.get(random);
                }
            }
            return head;
        }
    }
}
