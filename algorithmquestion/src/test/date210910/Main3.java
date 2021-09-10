package test.date210910;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main3
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-10 18:15
 **/
public class Main3 {
    static String[] result;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][7];
        int c = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            arr[i][0] = str.charAt(0)=='*'?1:0;
            arr[i][1] = str.charAt(1)=='*'?1:0;
            arr[i][2] = str.charAt(2)=='*'?1:0;
            arr[i][3] = 1;
            arr[i][4] = str.charAt(str.length()-3)=='*'?1:0;
            arr[i][5] = str.charAt(str.length()-2)=='*'?1:0;
            arr[i][6] = str.charAt(str.length()-1)=='*'?1:0;
        }
        result = new String[c];
        if (can(arr,n,c,0,0,0)){
            System.out.println("SUCCESS");
            for (int i = 0; i < c; i++) {
                System.out.print(Integer.parseInt(String.valueOf(result[i].charAt(0)))+1);
                System.out.print((char)(Integer.parseInt(String.valueOf(result[i].charAt(1)))+Character.valueOf('A')-1));
                System.out.println();
            }
            return;
        }
        System.out.println("FAILED");
    }

    static boolean can(int[][] arr,int n,int c,int line,int lie,int count){
        for (int j = line; j < n; j++) {
            for (int k = lie; k < 7 ; k++) {
                if (arr[j][k] == 1){
                    continue;
                }
                boolean target = true;
                for (int i = 0; i < count; i++) {
                    if (Math.abs(result[i].charAt(0) - String.valueOf(j).charAt(0))<1
                    && Math.abs(result[i].charAt(1) - String.valueOf(k).charAt(0))<1){
                        target = false;
                        break;
                    }
                }
                if (target){
                    result[count] = String.valueOf(j)+String.valueOf(k);
                    count++;
                    if (count==c){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
