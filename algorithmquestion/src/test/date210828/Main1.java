package test.date210828;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: 给定一个50容量的不重复递减数组和小明的成绩，求小明的成绩评级
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-28 20:00
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[50];
        for (int i = 0; i < 50; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        for (int i = 0; i < 50; i++) {
            if (m == arr[i]){
                if (i<5){
                    System.out.println("A+");
                } else if (i<15) {
                    System.out.println("A0");
                }else if (i<30){
                    System.out.println("B+");
                }else if (i<35){
                    System.out.println("B0");
                }else if (i<45){
                    System.out.println("C+");
                }else if (i<48){
                    System.out.println("C0");
                }else{
                    System.out.println("F");
                }
            }
        }
    }
}
