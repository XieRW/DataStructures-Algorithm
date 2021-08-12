package com.xrw.queue;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 用数组实现环形队列：队列的特点：先进先出，后进后出；
 * 实现思路：1、定义属性，队列的大小maxSize，队列的头部front指向队列的第一个元素，队列的尾部rear指向队列的最后一个元素的后一个节点,默认队列空出来一个节点
 * 2、front = 0 ，rear = 0；
 * 3、插入一个值：front不变，插入数据，rear = (rear+1)%maxSize；直到队列满：(rear+1-front)%maxsize == 0，就不允许插入
 * 4、取出一个值：front = (front+1)%maxSize，取出数据；直到队列为空：rear == front，就不允许取出
 * 5、队列的有效值的个数为 (rear+maxsize-front)%maxsize
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-04-01 22:23
 **/
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //新建一个队列
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        //接收用户输入
        char key = ' ';
        //输入流
        Scanner scanner = new Scanner(System.in);
        //控制程序结束的标记
        boolean loop = true;
        //程序运行，提供一个循环操作给用户
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
                    System.out.println("输入一个数");
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

/**
 * @Description: 环形队列
 * @Author: 谢荣旺
 * @Date: 2021/4/1
 */
class CircleArrayQueue{
    //队列最大容量
    private int maxSize;
    //队列第一个元素的位置
    private int front;
    //队列最后一个元素的后一个位置
    private int rear;
    //实际存储数据的数组
    private int[] arr;

    /**
     * @Description: 构造函数
     * @param maxSize: 最大容量
     * @return:
     * @Author: 谢荣旺
     * @Date: 2021/3/31
     */
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    /**
     * @Description: 判断队列是否已满
     * @param :
     * @return: boolean
     * @Author: 谢荣旺
     * @Date: 2021/3/31
     */
    public boolean isFull(){
        return (rear+1-front)%maxSize == 0;
    }

    /**
     * @Description: 判断队列是否为空
     * @param :
     * @return: boolean
     * @Author: 谢荣旺
     * @Date: 2021/3/31
     */
    public boolean isNull(){
        return rear == front;
    }

    /**
     * @Description: 往队列里面添加数组
     * @param n: 要插入的数据
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/31
     */
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，无法插入");
            return;
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    /**
     * @Description: 从队列中取出一个数据
     * @param :
     * @return: int
     * @Author: 谢荣旺
     * @Date: 2021/3/31
     */
    public int popQueue(){
        if (isNull()){
            //队列为空就抛出异常
            throw new RuntimeException("队列为空，没有数据");
        }
        int pop = arr[front];
        front = (front+1)%maxSize;
        return pop;
    }

    /**
     * @Description: 显示队列
     * @param :
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/31
     */
    public void showQueue(){
        if (isNull()){
            System.out.println("队列为空，没有数据");
            return;
        }
        //先赋值是因为java的for循环对于函数条件，每次都会重新计算值，提前赋值可以提高运算效率
        int size = size();
        for (int i = front;i<front+size;i++){
            System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    /**
     * @Description: 获取队列的第一个数据，但是不删除该数据
     * @param :
     * @return: int
     * @Author: 谢荣旺
     * @Date: 2021/3/31
     */
    public int getHead(){
        if (isNull()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

    /**
     * @Description: 判断队列有效数据的个数
     * @param : 
     * @return: int
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}