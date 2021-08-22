package test.date210822;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        int t,n;
        Scanner in =new Scanner(System.in);
        t=in.nextInt();
        int[][] attT = new int[t][];
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            attT[i] = arr;
        }
        for (int i = 0; i < attT.length; i++) {
            int[] arr = attT[i];
            int sum = 0;
            for (int k = 0; k < arr.length; k++) {
                for (int j = 0; j < arr.length-1-k; j++) {
                    if (arr[j]>arr[j+1]){
                        int min = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1]=min;
                    }
                }
                sum += arr[arr.length-k-1];
                for (int j= 0; j < arr.length-k-1; j++) {
                    arr[j] += arr[arr.length-k-1];
                }
            }
            System.out.println(sum);
        }

    }
}
