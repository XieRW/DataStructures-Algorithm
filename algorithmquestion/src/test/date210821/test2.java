package test.date210821;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小红书每周四会给同学们发放零食水果，假设我们的工位是一个N*N的形状，并且有一些工位上是空的。阿姨会从左上角的工位开始发零食，每次向一个相邻（上下左右四个方向）的工位移动。为了零食能尽快发完，阿姨希望只经过有同学在的工位并且每个工位只经过一次，最后一个收到零食的同学也需要是在最后一排，请问阿姨总共有多少种移动的方案？



输入描述
第一行一个整数N (0<N<=7)

接下来是N*N个字符，“.”代表这个工位有人，“#”代表这个工位是空的。

输出描述
一个整数，代表总共的方案数


样例输入
3
..#
..#
...
样例输出
1

提示
从左上角(1,1)位置开始，依次经过(1,2), (2,2), (2,1), (3,1), (3,2), (3,3)
 */
public class test2 {
    static int sum = 0;
    static int[][] visit;
    static String[][] data;
    static List<List<Integer>> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        data = new String[n][n];
        visit = new int[n][n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] s2 = s.split("");
            data[i] = s2;
            for (int j = 0; j < s2.length; j++) {
                if (s2[j].equals("#") ){
                    visit[i][j] = 1;
                }else {
                    visit[i][j] = 0;
                }
            }
        }
        if (can(0,0)){
            System.out.println(sum);
        }else {
            System.out.println(0);
        }
    }

    static boolean can(int i,int j){
        visit[i][j] = 1;
        boolean can = false;
        if (allVisit()){
            sum += 1;
            can = true;
        }
        if (i-1>=0&&i-1<data.length&&j>=0&&j<data.length&&data[i-1][j].equals(".")&&visit[i-1][j]==0){
            can = can||can(i-1,j);
        }
        if (i+1>=0&&i+1<data.length&&j>=0&&j<data.length&&data[i+1][j].equals(".")&&visit[i+1][j]==0){
            can = can||can(i+1,j);
        }
        if (i>=0&&i<data.length&&j-1>=0&&j-1<data.length&&data[i][j-1].equals(".")&&visit[i][j-1]==0){
            can = can||can(i,j-1);
        }
        if (i>=0&&i<data.length&&j+1>=0&&j+1<data.length&&data[i][j+1].equals(".")&&visit[i][j+1]==0){
            can = can||can(i,j+1);
        }
        if (!can){
            visit[i][j] = 0;
        }
        return can;
    }

    static boolean allVisit(){
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                if (visit[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

}
