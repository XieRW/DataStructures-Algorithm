package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DataStructures
 * @description: JZ19 顺时针打印矩阵
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-28 14:30
 **/
public class Jz19 {

    public class Solution {
        /**
         * 简单来说，就是不断地收缩矩阵的边界
         * 定义四个变量代表范围，up、down、left、right
         *
         * 向右走存入整行的值，当存入后，该行再也不会被遍历，代表上边界的 up 加一，同时判断是否和代表下边界的 down 交错
         * 向下走存入整列的值，当存入后，该列再也不会被遍历，代表右边界的 right 减一，同时判断是否和代表左边界的 left 交错
         * 向左走存入整行的值，当存入后，该行再也不会被遍历，代表下边界的 down 减一，同时判断是否和代表上边界的 up 交错
         * 向上走存入整列的值，当存入后，该列再也不会被遍历，代表左边界的 left 加一，同时判断是否和代表右边界的 right 交错
         * @param matrix 数组
         * @return
         */
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length== 0){
                return list;
            }
            int up = 0;
            int right = matrix[0].length-1;
            int down = matrix.length-1;
            int left = 0;
            while (true){
                for (int i = left; i <= right; i++) {
                    list.add(matrix[up][i]);
                }
                up++;
                if (up > down){
                    break;
                }
                for (int i = up; i <=down ; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                if (right < left){
                    break;
                }
                for (int i = right; i >=left ; i--) {
                    list.add(matrix[down][i]);
                }
                down--;
                if (down<up){
                    break;
                }
                for (int i = down; i >=up ; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
                if (left>right){
                    break;
                }
            }
            return list;
        }
    }
}
