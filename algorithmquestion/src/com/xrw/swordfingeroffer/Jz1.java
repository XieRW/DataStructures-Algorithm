package com.xrw.swordfingeroffer;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 牛客网剑指offer第一题 时间复杂度O(log2(mn))
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * <p>
 * 给定 target = 3，返回 false。
 * <p>
 * 0 <= array.length <= 500
 * 0 <= array[0].length <= 500
 * <p>
 * 示例1
 * 输入：
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 复制
 * 返回值：
 * true
 * 复制
 * 说明：
 * 存在7，返回true
 * 示例2
 * 输入：
 * 3,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 复制
 * 返回值：
 * false
 * 复制
 * 说明：
 * 不存在3，返回false
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-12 16:28
 **/
public class Jz1 {
    static int n;
    static int len = 4;
    static int wid = 4;
    static int[][] arr = new int[len][wid];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(Find(n,arr));
    }

    static boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 ||array[0] == null || array[0].length == 0){
            return false;
        }
        return find2(array,0,array[0].length-1,0,array.length-1,target);
    }

    static boolean find2(int[][] arr, int left, int right, int top, int low, int n) {
        boolean result = false;
        int midL = (left + right) / 2;
        int midW = (top + low) / 2;
        if (n == arr[midW][midL]) {
            result = true;
//            System.out.printf("第%d行:\t,第%d列\n", midL+1, midW+1);
        }
        if (n > arr[midW][midL]) {
            if (right - midL > 0) {
                //往右找
                result = result || find2(arr, midL + 1, right, top, low, n);
            }
            if ((low - midW) > 0) {
                //往下找
                result = result || find2(arr, left, right, midW + 1, low, n);
            }

        }
        if (n < arr[midW][midL]) {
            if ((midL - left) > 0) {
                //往左找
                result = result || find2(arr, left, midL - 1, top, low, n);
            }
            if ((midW - top) > 0) {
                //往上找
                result = result || find2(arr, left, right, top, midW - 1, n);
            }
        }
        return result;
    }
}


