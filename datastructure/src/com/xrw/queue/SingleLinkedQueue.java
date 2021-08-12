package com.xrw.queue;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 简单的链式结构队列
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-04-18 20:13
 **/
public class SingleLinkedQueue {

    public static void main(String[] args) {
        //新建一个队列
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //接收用户输入
        int key = 0;
        //输入流
        Scanner scanner = new Scanner(System.in);
        //控制程序结束的标记
        boolean loop = true;
        //程序运行，提供一个循环操作给用户
        while (loop){
            System.out.println("输入奇数: 将该数插入队列尾部");
            System.out.println("输入偶数: 从队列头部取出一个数据");
            System.out.println("输入0: 退出程序");
            key = scanner.nextInt();//获取用户输入的第一个字符
            if (key == 0){
                loop = false;
            } else if (key%2 == 1){
                Course course = new Course(key,"default","default");
                singleLinkedList.add(course);
                System.out.printf("打印当前队列：\t");
                singleLinkedList.list();
                System.out.println();
            } else if (key%2 == 0){
                try {
                    Course course = singleLinkedList.pop();
                    System.out.printf("取出数据为："+course.toString()+"\n");
                    System.out.printf("打印当前队列：\t");
                    singleLinkedList.list();
                    System.out.println();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("程序退出~~");
    }
}

/**
 * @Description: 单链表
 * @Author: 谢荣旺
 * @Date: 2021/4/1
 */
class SingleLinkedList {
    //创建一个头结点，不存放数据
    Course headNode = new Course(0, "", "");

    /**
     * @Description: 获取头结点
     * @return: Course
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public Course getHeadNode() {
        return headNode;
    }

    /**
     * @param course: 要加入的节点
     * @Description: 默认在链表最后加入一个节点
     * 实现思路：
     * 1、用一个辅助节点temp去遍历链表，temp的初始值temp=headNode
     * 2、循环移动temp:temp = temp.next,如果temp.next为空则将要加入的节点插入：temp.next = course
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void add(Course course) {
        Course temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = course;
    }

    /**
     * @param course: 要加入的节点
     * @Description: 按照序号加入一个节点
     * 实现思路：
     * 1、用一个辅助节点temp去遍历链表，temp的初始值temp=headNode
     * 2、循环移动temp:temp = temp.next
     * 3.1、如果temp.next == null，那么将course加入temp.next,退出循环
     * 3.2、如果temp.next.no == course.no，那么返回错误提示,退出循环
     * 3.3，如果temp.next.no > course.no，那么将course插入入到temp和temp.next之间,course.next = temp.next,temp.next = course,退出循环
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void addByOrder(Course course) {
        Course temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == course.no) {
                System.out.printf("编号%d的课程已存在，不能重复插入~\n", course.no);
                break;
            }
            if (temp.next.no > course.no) {
                course.next = temp.next;
                temp.next = course;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * @param course: 要更新的节点
     * @Description: 通过节点的编号更新节点
     * 实现思路：
     * 1、用一个辅助节点temp去遍历链表，temp的初始值temp=headNode.next
     * 2、如果temp == null，则链表为空,返回错误提示
     * 3、循环移动temp:temp = temp.next
     * 4.1如果temp == null，那么返回错误提示，退出循环
     * 4.2如果temp.no == course.no,那么temp.name = course.name，temp.hard = course.hard
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void update(Course course) {
        Course temp = headNode.next;
        if (temp == null) {
            System.out.printf("链表为空");
        }
        while (true) {
            if (temp == null) {
                System.out.printf("编号为%d的数据不存在", course.no);
                break;
            }
            if (temp.no == course.no) {
                temp.name = course.name;
                temp.hard = course.hard;
            }
            temp = temp.next;
        }
    }

    /**
     * @param no: 要删除节点的编号
     * @Description: 通过编号删除一个节点
     * 实现思路：
     * 1、用一个辅助节点temp去遍历链表，temp的初始值temp=headNode
     * 2.1如果temp.next == null，那么返回错误提示，退出循环
     * 2.2如果temp.next.no == no,那么temp.next = temp.next.next
     * 3、循环移动temp:temp = temp.next
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void delete(int no) {
        Course temp = headNode;
        while (true) {
            if (temp.next == null) {
                System.out.printf("要删除的编号为%d的节点不存在", no);
                break;
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * @Description: 遍历显示每个节点的数据
     * 实现思路：用一个辅助节点temp去遍历
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void list() {
        Course temp = headNode.next;
        if (temp == null) {
            System.out.print("链表为空~~~");
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.printf(temp.toString()+"\t");
            temp = temp.next;
        }
    }

    /**
     * @param name: 课程名称
     * @Description: 通过课程名称查找节点
     * @return: 查找到的节点
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public Course searchByName(String name) {
        Course temp = headNode.next;
        if (temp == null) {
            throw new RuntimeException("课程不存在！");
        }
        while (true) {
            if (temp == null) {
                throw new RuntimeException("课程不存在！");
            }
            if (temp.name.contains(name)) {
                return temp;
            }
            temp = temp.next;
        }
    }

    /**
     * @Description: 整理单链表：依次访问单链表的每个元素，如果是奇数，将其删除， 如果是偶数，就在其前面插入-1
     * @Author: 谢荣旺
     * @Date: 2021/4/8
     */
    public void clear() {
        Course temp = headNode;

        while (true) {
            if (temp.next == null) {
                return;
            }
            if (temp.next.no % 2 == 1) {
                temp.next = temp.next.next;
            } else if (temp.next.no % 2 == 0) {
                Course course = new Course(-1, "默认", "default");
                course.next = temp.next;
                temp.next = course;
                temp = temp.next.next;
            }
        }
    }

    /**
     * @Description: 合并有序单链表
     * @Author: 谢荣旺
     * @Date: 2021/4/8
     */
    public void merge(SingleLinkedList list) {
        Course temp = headNode;
        Course temp2 = list.getHeadNode();
        Course merge;
        while (true) {
            if (temp2.next == null) {
                return;
            }
            if (temp.next == null) {
                temp.next = temp2.next;
                return;
            }
            if (temp.next.no <= temp2.next.no) {
                temp = temp.next;
            } else {
                merge = temp2.next;
                temp2.next = temp2.next.next;
                merge.next = temp.next;
                temp.next = merge;
            }
        }
    }

    /**
     * @Description: 取出队列第一个元素
     * @Author: 谢荣旺
     * @Date: 2021/4/8
     */
    public Course pop() {
        if (headNode.next == null){
            throw new RuntimeException("队列为空！");
        }
        Course temp = headNode.next;
        headNode.next = headNode.next.next;
        temp.next = null;
        return temp;
    }
}

/**
 * @Description: 单链表的节点类
 * @Author: 谢荣旺
 * @Date: 2021/4/1
 */
class Course {
    //课程编号
    int no;
    //课程名称
    String name;
    //课程难度
    String hard;
    //指向下一个节点
    Course next;

    /**
     * @Description: 构造函数
     */
    public Course(int no, String name, String hard) {
        this.no = no;
        this.name = name;
        this.hard = hard;
    }

    /**
     * @Description: 重写String方法，用来打印节点内容
     */
    @Override
    public String toString() {
        return String.valueOf(no);
    }
}


