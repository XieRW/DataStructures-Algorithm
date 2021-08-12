package com.xrw.sequenceList;

import java.util.Arrays;

/**
 * @program: courseExperiment
 * @description: 顺序表的操作
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-03-23 18:29
 **/
public class sequenceListDemo {

    public static void main(String[] args) {
        sequenceList sequenceList = new sequenceList();
        sequenceList.show();
        sequenceList.insert(2);
        sequenceList.show();
        sequenceList.insert(3);
        sequenceList.show();
        sequenceList.insert(3);
        sequenceList.show();
        sequenceList.insert(4);
        sequenceList.show();
        sequenceList.insert(3);
        sequenceList.show();
        sequenceList.insert(7,4);
        sequenceList.show();
        sequenceList.insert(5,5);
        sequenceList.show();
        sequenceList.deleteDuplication();
        sequenceList.show();
    }
}

/**
 * @Description: 顺序表
 * @Author: 谢荣旺
 * @Date: 2021/3/23
 */
class sequenceList{
    //数组实际已使用长度
    int realSize;
    //数组
    int[] elem;

    /**
     * @Description: 构造方法，默认顺序表容量为5
     * @param :
     * @return:
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public sequenceList(){
        this(5);
    }

    /**
     * @Description: 构造方法
     * @param size:
     * @return:
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public sequenceList(int size){
        elem = new int[size];
        this.realSize = 0;
    }

    /**
     * 判断数组是否已满
     * @return
     */
    public boolean isFull(){
        if (realSize == elem.length){
            return true;
        }
        return false;
    }

    /**
     * @Description: 对数组进行扩容
     * @return: int[]
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public void dilatation(){
        elem = Arrays.copyOf(elem,elem.length*2);
    }

    /**
     * @Description: 从指定位置数组下标开始数组前移
     * @param i: 开始前移的位置
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public void moveForward(int i){
        for (int j = i; j < realSize; j++) {
            elem[j] = elem[j+1];
        }
    }

    /**
     * @Description: 从指定位置数组下标开始数组后移
     * @param i: 开始后移的位置
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public void moveBack(int i){
        for (int j = realSize; j > i; j--) {
            elem[j] = elem[j-1];
        }
    }


    /**
     * @Description: 顺序表末尾插入数据
     * @param n:插入的数据
     * @return: boolean
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public boolean insert(int n){
        if (isFull()){
            dilatation();
        }
        elem[realSize] = n;
        realSize++;
        return true;
    }

    /**
     * @Description: 重载，顺序表指定位置插入数据
     * @param i: 插入数据的位置，位置从0开始
     * @param n: 插入的数据
     * @return: boolean
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public boolean insert(int i,int n){
        if (isFull()){
            dilatation();
        }
        if (i > realSize){
            elem[realSize] = n;
        }else {
            moveBack(i);
            elem[i] = n;
        }
        realSize++;
        return true;
    }

    /**
     * @Description: 顺序表去重
     * @param :
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public void deleteDuplication(){
        int[] temp = new int[realSize];
        int tempPosition = 0;
        for (int i = 0; i < realSize; i++) {
            temp[tempPosition] = elem[i];
            tempPosition++;
            for (int j = 0; j < tempPosition-1; j++){
                if (elem[i] == temp[j]){
                    temp[tempPosition-1] = 0;
                    tempPosition--;
                    break;
                }
            }
        }
        elem = temp;
        realSize = tempPosition;
    }

    /**
     * @Description: 输出顺序表
     * @param :
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public void show(){
        System.out.printf("顺序表当前容量为%d\t 顺序表已用容量为%d\t 顺序表已存入数据为：",elem.length,realSize);
        for (int i = 0; i < realSize; i++) {
            System.out.print(elem[i]+"\t");
        }
        System.out.println();
    }

    /**
     * @Description: 删除数据
     * @param i: 要删除的数据的下标
     * @return: boolean
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public boolean delete(int i){
        //todo 删除指定下标的元素，并将后续元素一一前移即可，略
        return true;
    }

    /**
     * @Description: 查找关键字key，返回下标
     * @param key:
     * @return: int
     * @Author: 谢荣旺
     * @Date: 2021/3/23
     */
    public int search(int key){
        //todo 暴力匹配，略
        return -1;
    }
}
