package com.xrw.array;

import java.util.Random;
import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 三子棋游戏
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-03-23 22:23
 **/
public class threeChess {
    //是否玩家一
    static boolean first = true;
    //玩家代号
    static String player = first?"一":"二";
    //玩家一的棋子
    static final String chessPiecesOne = " O ";
    //玩家二的棋子
    static final String chessPiecesTwo = " X ";
    //棋子
    static String chessPieces = first?chessPiecesOne:chessPiecesTwo;
    //键盘输入对象
    static Scanner in = new Scanner(System.in);
    //玩家落子的行号
    static int x = 0;
    //玩家落子的列号
    static int y = 0;
    //是否结束
    static boolean over = false;
    //落子次数
    static int number = 0;
    //棋盘
    static String[][] list = {{"__|", "__|", "__"}, {"__|", "__|", "__"}, {"  |", "  |", "  "}};

    /**
     * @Description: 主函数
     * @param args:
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/13
     */
    public static void main(String[] args) {
//        System.out.println("__|__|__");
//        System.out.println("__|__|__");
//        System.out.println("  |  |  ");
        System.out.println("初始化棋盘完成，游戏开始！");
        print();
        while (!over){
            number++;
            play();
            System.out.println("玩家"+player+"落子结束！棋盘当前状态为：");
            print();
            if (win()){
                System.out.println("玩家"+player+"获胜！");
                over = !over;
            }else if (number == 9){
                System.out.println("棋盘已满，双方打平！");
                over = !over;
            }else {
                System.out.println("棋局尚未结束！");
            }
            first = !first;
        }
    }

    /**
     * @Description: 玩家落子
     * @param :
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/13
     */
    static void play() {
        player = first?"一":"二";
        chessPieces = chessPieces = first?chessPiecesOne:chessPiecesTwo;
        System.out.println("玩家"+player+"开始落子，请输入落子的行号：");
        x = in.nextInt();
        System.out.println("玩家"+player+"开始落子，请输入落子的列号：");
        y = in.nextInt();
        if (x < 1 || x > 3 || y < 1 || y > 3 || list[x - 1][y - 1].equals(chessPiecesOne) || list[x - 1][y - 1].equals(chessPiecesTwo)) {
            System.out.println("落子犯规，请重新落子！不可超出边界，也不可重复落子！");
            play();
        }else {
            list[x - 1][y - 1] = chessPieces;
        }
    }

    /**
     * @Description: 打印棋盘
     * @param :
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2021/3/13
     */
    static void print(){
        for (String[] ints : list) {
            for (String i : ints) {
                Random random = new Random();
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    /**
     * @Description: 判断是否获胜
     * @param :
     * @return: boolean
     * @Author: 谢荣旺
     * @Date: 2021/3/13
     */
    static boolean win(){
        //首先判断同一行棋子是否相同；
        if (list[x-1][0].equals(list[x-1][1]) && list[x-1][0].equals(list[x-1][2])){
            return true;
        }
        //然后判断同一列棋子是否相同；
        if (list[0][y-1].equals(list[1][y-1]) && list[0][y-1].equals(list[2][y-1])){
            return true;
        }
        int position = (x-1)*3+y;
        //然后判断第3、5、7个棋子是否相同；
        if (position == 3  || position == 5 || position == 7){
            if (list[0][2].equals(list[1][1]) && list[0][2].equals(list[2][0])){
                return true;
            }
        }
        //然后判断第1、5、9个棋子是否相同；
        if (position == 1  || position == 5 || position == 9){
            if (list[0][0].equals(list[1][1]) && list[0][0].equals(list[2][2])){
                return true;
            }
        }
        return false;
    }
}
