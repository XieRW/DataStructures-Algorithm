package test.date210914;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main2
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-14 19:41
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, q;
        n = in.nextInt();
        q = in.nextInt();
        int last = Integer.MAX_VALUE;
        int s = 0;
        for (int i = 0; i < q; i++) {
            int e = in.nextInt();
            int temp = e;
            int sum = 0;
            if (e==0){
                sum = s;
                s++;
            }else {
                s = 0;
            }
            for (int j = i+1; j < n; j++) {
                if (e == 0){
                    break;
                }
                if (j<=last){
                    sum++;
                }else {
                    sum += (j-i+1);
                }
                e--;
            }
            last = temp;
            System.out.print(sum + " ");
        }
    }
}
