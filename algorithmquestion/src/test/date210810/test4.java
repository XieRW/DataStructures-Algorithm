package test.date210810;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
                boolean can = true;
                int n = in.nextInt();
                in.reset();
                String line = "";
                in.nextLine();
                line = in.nextLine();
                String[] num = line.split(" ");
                if (n == 0) {
                    can = false;
                    break;
                }
                int[] compare = new int[num.length];
                for (int j = 0; j < num.length; j++) {
                    if (Integer.parseInt(num[j]) <= 0 ||Integer.parseInt(num[j]) > num.length) {
                        can = false;
                        break;
                    }
                    compare[Integer.parseInt(num[j]) - 1] = Integer.parseInt(num[j]);
                }
                for (int j = 0; j < compare.length; j++) {
                    if (compare[j] == 0) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }

        }
    }
}
