package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 机器人的运动范围
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-11-02 15:04
 **/
public class Jz55 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(10, 1, 100));
    }

    public static class Solution {
        int[][] arrs;

        public int movingCount(int threshold, int rows, int cols) {
            if (threshold == 0) {
                return 1;
            }
            if (rows == 0 || cols == 0) {
                return 0;
            }
            arrs = new int[rows][cols];
            return movingCountHelp(threshold, 0, 0);
        }

        public int movingCountHelp(int threshold, int row, int col) {
            int num = 0;
            if (row < 0 || row == arrs.length || col < 0 || col == arrs[0].length || arrs[row][col] == 1) {
                return num;
            }
            if (caculate(threshold, row, col)) {
                num++;
                arrs[row][col] = 1;
                num += movingCountHelp(threshold, row - 1, col)
                        + movingCountHelp(threshold, row + 1, col)
                        + movingCountHelp(threshold, row, col - 1)
                        + movingCountHelp(threshold, row, col + 1);
            }
            arrs[row][col] = 1;
            return num;
        }

        public boolean caculate(int threshold, int row, int col) {
            int sum = 0;
            while (row != 0) {
                sum += row % 10;
                row /= 10;
            }
            while (col != 0) {
                sum += col % 10;
                col /= 10;
            }
            if (sum <= threshold) {
                return true;
            }
            return false;
        }
    }
}
