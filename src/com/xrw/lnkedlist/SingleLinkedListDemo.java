package com.xrw.lnkedlist;

import sun.plugin.dom.core.CoreConstants;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 单链表
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-04-01 23:20
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            System.out.printf("请输入第%d个节点的课程编号\t",i+1);
            int no = in.nextInt();
            System.out.printf("请输入第%d个节点的课程名称\t",i+1);
            String name = in.next();
            System.out.printf("请输入第%d个节点的课程难度\t",i+1);
            String hard = in.next();

            Course course = new Course(no, name, hard);

            singleLinkedList.add(course);
            System.out.println("链表每个节点的元素为：");
            singleLinkedList.list();
        }
        System.out.println("整理单链表：依次访问单链表的每个元素，如果是奇数，将其删除， 如果是偶数，就在其前面插入-1");

        singleLinkedList.clear();
        System.out.println("整理后的链表为：");
        singleLinkedList.list();
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
     * @return: com.xrw.lnkedlist.Course
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
                System.out.printf("要删除的编号为%d的节点不存在",no);
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
        if (temp == null){
            System.out.println("链表为空~~~");;
        }
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
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
        if (temp == null){
            throw new RuntimeException("课程不存在！");
        }
        while (true){
            if (temp == null){
                throw new RuntimeException("课程不存在！");
            }
            if (temp.name.contains(name)){
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
    public void clear(){
        Course temp = headNode;

        while (true){
            if (temp.next == null){
                return;
            }
            if (temp.next.no%2 == 1){
                temp.next = temp.next.next;
            }else if (temp.next.no%2 == 0){
                Course course = new Course(-1,"默认","default");
                course.next = temp.next;
                temp.next = course;
                temp = temp.next;
            }
            temp = temp.next;
        }
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
        return "Course{" +
                "no=" + no +
                ", name=" + name +
                ", hard=" + hard +
                '}';
    }
}
