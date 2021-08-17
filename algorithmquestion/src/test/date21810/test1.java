package test.date21810;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            double n = in.nextInt();
            double m = in.nextInt();
            double sum=0;
            for (int i = 0; i < m; i++) {
                sum += n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f\n",sum);
        }
    }
}
