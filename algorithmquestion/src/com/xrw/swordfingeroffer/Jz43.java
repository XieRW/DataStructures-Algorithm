package com.xrw.swordfingeroffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: DataStructures
 * @description: 链表中环的入口结点
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=23449&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-18 15:21
 **/
public class Jz43 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：用map去存储节点的val，当得到相同的val时，表明走到了重复的节点上，即环的入口
     */
    public class Solution {

        public ListNode EntryNodeOfLoop(ListNode pHead) {
            Map<Integer, Integer> map = new HashMap<>(16);
            while (pHead != null) {
                if (map.containsKey(pHead.val)) {
                    return pHead;
                }
                map.put(pHead.val, pHead.val);
                pHead = pHead.next;
            }
            return null;
        }
    }
}
