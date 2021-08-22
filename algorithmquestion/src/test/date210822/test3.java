package test.date210822;

import java.util.Scanner;

/**
4 2
ebfc
 */
public class test3 {
    public static void main(String[] args) {
        int t,n;
        Scanner in =new Scanner(System.in);
        t=in.nextInt();
        n=in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        int count = n;
        char target = ' ';
        int index = 0;

        for (int i = 0; i < n; i++) {
            target = chars[index];
            for (int j = index; j < chars.length-(count-1); j++) {
                index = j+1;
                if (j>=chars.length-1){
                    System.out.print(chars[j]);
                    continue;
                }
                if (target<chars[j+1]){
                    target = chars[j+1];
                    index = j+1+1;
                }
            }
            System.out.print(target);
        }


    }
}
