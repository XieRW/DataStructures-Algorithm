package test.date210826;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main2
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-26 19:57
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next().toLowerCase();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int j = str.length()-i-1;
            switch (str.charAt(i)){
                case 'a':
                    sum += (Math.pow(16,j)*10);
                    break;
                case 'b':
                    sum += (Math.pow(16,j)*11);
                    break;
                case 'c':
                    sum += (Math.pow(16,j)*12);
                    break;
                case 'd':
                    sum += (Math.pow(16,j)*13);
                    break;
                case 'e':
                    sum += (Math.pow(16,j)*14);
                    break;
                case 'f':
                    sum += (Math.pow(16,j)*15);
                    break;
                default:
                    sum += (Math.pow(16,j)*Integer.valueOf(String.valueOf(str.charAt(i))));
                    break;
            }
        }
        System.out.println(sum);

    }
}
