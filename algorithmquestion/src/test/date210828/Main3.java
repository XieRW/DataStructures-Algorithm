package test.date210828;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: 醉汉游走,没想到解题思路
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-28 20:13
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            int st = in.nextInt();
            if (x-st >= 0 && x+st <= 60){
                System.out.println(0);
            }
            double may = 0;
            double sum = Math.pow(2,st);
            if (x-st < 0){
                may+=Math.pow(2,st-x);
            }
            if (x+st > 60){
                may+=Math.pow(2,x+st-60);
            }
            System.out.println(1-may/sum);
        }
    }
}
