package test.date210810;

import java.util.Scanner;

public class tset2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            boolean exit = false;
            for (int i = m;i<=n;i++){
                int s = i;
                int sum = (s/100)*(s/100)*(s/100)+(s%100/10)*(s%100/10)*(s%100/10)+(s%10)*(s%10)*(s%10);
                if (sum == s){
                    exit = true;
                    System.out.printf("%d\t",s);
                }
            }
            if (exit){
                System.out.println("");
            }else {
                System.out.println("no");
            }
        }
    }
}
