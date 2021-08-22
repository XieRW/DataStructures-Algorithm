package test.date210822;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        int m  = 10;
        ListNode listNode = new ListNode(0);
        for (int i = 1; i < m; i++) {
            ListNode temp = listNode;
            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next = new ListNode(2);
        }
        solve(m,listNode);
    }

    public static ListNode[] solve (int m, ListNode a) {
        // write code here
        ListNode now = a;
        ListNode[] list = new ListNode[m];
        while(now != null){
            ListNode newNode = new ListNode(now.val);
            ListNode temp = list[now.val%m];
            if (temp == null){
                list[now.val%m] = newNode;
                now=now.next;
                continue;
            }

            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next = newNode;
            now=now.next;
        }
        return list;
    }

}
