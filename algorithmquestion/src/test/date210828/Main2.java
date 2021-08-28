package test.date210828;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: 数组中连续相同数字的长度，可以允许交换一次数组的相邻元素
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-28 20:12
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int max = 1;
        for (int i = 0; i < n-1; i++) {
            int max3 = 1;
            if (arr[i] != arr[i+1]){
                if (i+2 < n && arr[i] == arr [i+2]){
                    max3++;
                }
                if (max3>max){
                    max = max3;
                }
            }
            if (arr[i] == arr[i+1]){
                int max2 = 1;
                for (int j = i; j < n-1-i; j++) {
                    if (arr[j] != arr[j+1]){
                        if (j+2 < n && arr[j] == arr [j+2]){
                            max2++;
                        }
                        if (max2>max){
                            max = max2;
                        }
                        break;
                    }
                    max2++;
                    if (max2>max){
                        max = max2;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
