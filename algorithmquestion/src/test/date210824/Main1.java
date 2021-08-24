package test.date210824;

import java.util.Scanner;

/**
 * 摆摊n行m列，1表示能摆，0表示不能摆，求摊位上下左右不相邻的摆摊方案数目，0个摊位也是一种方案
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println("0");
    }
}
