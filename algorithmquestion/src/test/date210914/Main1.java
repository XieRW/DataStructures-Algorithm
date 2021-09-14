package test.date210914;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main1
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-14 19:26
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,k;
        n = in.nextInt();
        k = in.nextInt();
        int[] arr = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = n*(i+1);
            StringBuilder s = new StringBuilder();
            s.append(arr[i]);
            s.reverse();
            arr[i] = Integer.parseInt(s.toString());
            max = arr[i]>max?arr[i]:max;
        }
        System.out.println(max);
    }
}
