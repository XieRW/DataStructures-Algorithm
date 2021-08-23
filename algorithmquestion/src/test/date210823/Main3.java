package test.date210823;

import java.util.Stack;

/**
 * 将单链表的每k个节点之间逆序
 * 详细描述
 * 给定单链表头节点head，实现一个调整单链表的函数，使得每k个节点之间逆序，如果最后不够K个节点，则不进行调整。
 * <p>
 * <p>
 * <p>
 * 其他
 * 时间限制: 1000ms
 * <p>
 * 内存限制: 256.0MB
 * <p>
 * 输入输出示例
 * 示例1
 * 输入
 * 复制
 * {1,2,3,4,5,6,7,8,9,10,11,12,13},3
 * 输出
 * 复制
 * {3,2,1,6,5,4,9,8,7,12,11,10,13}
 * 示例2
 * 输入
 * 复制
 * {1,2,3,4,5,6,7,8,9,10,11,12,13},4
 * 输出
 * 复制
 * {4,3,2,1,8,7,6,5,12,11,10,9,13}
 * 示例3
 * 输入
 * 复制
 * {1,2,3,4,5,6,7,8,9,10,11,12,13},1
 * 输出
 * 复制
 * {1,2,3,4,5,6,7,8,9,10,11,12,13}
 */
public class Main3 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        revertLinkList(listNode,4);
    }
    public static ListNode revertLinkList(ListNode head, int k) {
        // write code here
        int group = k;
        ListNode temp = new ListNode(0);
        ListNode newHead = temp;
        while (head!=null){
            if (group==0){
                group = k;
                while (temp.next!=null){
                    temp = temp.next;
                }
            }
            group--;
            ListNode newNode = head.next;
            head.next = temp.next;
            temp.next = head;
            head = newNode;
        }
        if (group>0){
            Stack<ListNode> stack = new Stack<>();
            ListNode temp2 = temp;
            for (int i = 0; i < k-group; i++) {
                stack.add(temp2.next);
                temp2 = temp2.next;
            }
            temp.next = null;
            for (int i = 0; i < k-group; i++) {
                temp.next = stack.pop();
                temp = temp.next;
            }
        }
        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
