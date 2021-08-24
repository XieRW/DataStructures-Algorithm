package test.date210824;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (k > 1) {
            System.out.println("G win");
            return;
        }
        if (n % 2 == 0) {
            System.out.println("T win");
            return;
        }
        System.out.println("G win");
    }
}
