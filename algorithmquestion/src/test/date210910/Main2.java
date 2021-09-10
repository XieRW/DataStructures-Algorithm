package test.date210910;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main2
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-10 17:54
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] chars = s.toCharArray();
        int k = in.nextInt();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            int now = length(chars,k,i);
            if (now>max){
                max = now;
            }
        }
        System.out.println(max);
    }

    static int length(char[] chars,int k,int i){
        int length = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j]=='1'){
                length++;
            }else {
                if (k==0){
                    break;
                }else {
                    k--;
                    length++;
                }
            }
        }
        return length;
    }
}
