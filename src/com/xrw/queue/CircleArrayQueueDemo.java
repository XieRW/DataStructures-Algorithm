package com.xrw.queue;

/**
 * @program: DataStructures
 * @description: 用数组实现环形队列：队列的特点：先进先出，后进后出；
 * 实现思路：1、定义属性，队列的大小maxSize，队列的头部front指向队列的第一个元素，队列的尾部rear指向队列的最后一个元素的后一个节点,默认队列空出来一个节点
 * 2、front = 0 ，rear = 0；
 * 3、插入一个值：front不变，插入数据，rear<maxsize-1则rear++,否则rear=0；直到队列满：(rear+1-front)%maxsize == 0，就不允许插入
 * 4、取出一个值：front<maxsize-1则front++否则front=0，取出数据；直到队列为空：rear == front，就不允许取出
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-03-30 22:23
 **/
public class CircleArrayQueueDemo {
}
