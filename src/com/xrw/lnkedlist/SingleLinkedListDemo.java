package com.xrw.lnkedlist;

/**
 * @program: DataStructures
 * @description: 单链表
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-04-01 23:20
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {

    }
}

/**
 * @Description: 单链表
 * @Author: 谢荣旺
 * @Date: 2021/4/1
 */
class SingleLinkedList{
    //创建一个头结点，不存放数据
    Course headNode = new Course(0,"","");

    /**
     * @Description: 获取头结点
     * @return: com.xrw.lnkedlist.Course
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public Course getHeadNode(){
        return headNode;
    }

    /**
     * @Description: 默认在链表最后加入一个节点
     * 实现思路：
     * 1、用一个辅助节点temp去遍历链表，temp的初始值temp=headNode
     * 2、循环移动temp:temp = temp.next,如果temp.next为空则将要加入的节点插入：temp.next = course
     * @param course: 要加入的节点
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void add(Course course){
        Course temp = headNode;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = course;
    }

    /**
     * @Description: 按照序号加入一个节点
     * 实现思路：
     * 1、用一个辅助节点temp去遍历链表，temp的初始值temp=headNode
     * 2、循环移动temp:temp = temp.next
     * 3.1、如果temp.next == null，那么将course加入temp.next,退出循环
     * 3.2、如果temp.next.no == course.no，那么返回错误提示,退出循环
     * 3.3，如果temp.next.no > course.no，那么将course插入入到temp和temp.next之间,course.next = temp.next,temp.next = course,退出循环
     * @param course: 要加入的节点
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void addByOrder(Course course){
        Course temp = headNode;

        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == course.no){
                System.out.printf("编号%d的课程已存在，不能重复插入~\n",course.no);
                break;
            }
            if (temp.next.no > course.no){
                course.next = temp.next;
                temp.next = course;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * @Description: 通过节点的编号更新节点
     * @param course: 要更新的节点
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void update(Course course){

    }

    /**
     * @Description: 通过编号删除一个节点
     * @param no: 要删除节点的编号
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void delete(int no){

    }

    /**
     * @Description: 遍历显示每个节点的数据
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public void list(){

    }

    /**
     * @Description: 通过课程名称查找节点
     * @param name: 课程名称
     * @return: 查找到的节点
     * @Author: 谢荣旺
     * @Date: 2021/4/1
     */
    public Course searchByName(String name){
        return new Course(0,"","");
    }
}

/**
 * @Description: 单链表的节点类
 * @Author: 谢荣旺
 * @Date: 2021/4/1
 */
class Course{
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
    public Course(int no,String name,String hard){
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
