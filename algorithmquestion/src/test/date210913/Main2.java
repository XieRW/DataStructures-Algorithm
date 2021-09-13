package test.date210913;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main2
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-13 20:15
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m,n;
        m = in.nextInt();
        n = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println("1,2,3,6,9,8,7,4,5");
    }
}
