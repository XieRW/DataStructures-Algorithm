package test.date210830;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: SHEIN8.30笔试题，实现一个链表的新增和删除，说实话，有点easy了
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-30 22:11
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int headValue = in.nextInt();
        LinkedList list = new LinkedList(new Node((headValue)));
        Node temp = list.head;
        for (int i = 1; i < n; i++) {
            int value = in.nextInt();
            temp.next = new Node(value);
            temp = temp.next;
        }
        list.remove(m);
        Node node = list.head;
        while (node != null){
            System.out.print(node.value+ " ");
            node = node.next;
        }
    }
}

class LinkedList{
    Node head;

    LinkedList(Node node){
        this.head = node;
    }
    void add(int value){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(value);
    }
    void remove(int index){
        if (index == 1){
            this.head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index-2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}

class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
        this.next = null;
    }
}
