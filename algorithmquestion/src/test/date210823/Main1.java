package test.date210823;

import java.util.Scanner;

/**
 给出一个有重复排序数组，输入一个数字，返回该数字在数字的最小和最大数组Index
 详细描述
 给出一个有重复?️排序数组，输入一个数字，返回该数字在数字的最小和最大数组Index

 例如：

 给定数组：[1,2,3,3,3,3,4]

 输入1: 返回：0，0

 输入3:返回：2，5

 输入9：返回：-1，-1

 时间复杂度要求：O(logN)

 空间复杂度要求：O(1)

 其他
 时间限制: 1000ms

 内存限制: 256.0MB

 输入输出示例
 示例1
 输入
 复制
 2
 输出
 复制
 1，1
 示例2
 输入
 复制
 3
 输出
 复制
 2,5
 示例3
 输入
 复制
 9
 输出
 复制
 -1,-1
 */
public class Main1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4};
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int target = in.nextInt();
            int index = index(arr,0,arr.length-1,target);
            int min = index;
            int max = index;
            while(min>0&&arr[min-1] == arr[index]){
                min--;
            }
            while(max<arr.length-1&&arr[max+1] == arr[index]){
                max++;
            }
            System.out.printf("%d,%d",min,max);
            System.out.println();
        }
    }
    static int index(int[] arr,int left,int right,int target){
        int mid = (left+right)/2;

        if (arr[mid] == target){
            return mid;
        } else if (arr[mid] < target) {
            if (Math.abs(right-left)==0){
                return -1;
            }else if (Math.abs(right-left)==1){
                return index(arr,right,right,target);
            }else {
                return index(arr,mid,right,target);
            }
        }else {
            if (Math.abs(right-left)<=0){
                return -1;
            }else {
                return index(arr,left,mid,target);
            }

        }
    }
}
