package com.xrw.queue;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 用数组实现队列
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-03-30 22:23
 **/
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("p(pop): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//获取用户输入的第一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'p':
                    try {
                        int i = arrayQueue.popQueue();
                        System.out.printf("取出的数据是%d\n",i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = arrayQueue.getHead();
                        System.out.printf("队列的头数据为%d\n",i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    System.out.println("输入非法，请重新输入");
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }

    public boolean isNull(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，无法插入");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int popQueue(){
        if (isNull()){
            throw new RuntimeException("队列为空，没有数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isNull()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front;i<rear;i++){
            System.out.printf("%d\t",arr[i+1]);
        }
    }

    public int getHead(){
        if (isNull()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front+1];
    }
}
