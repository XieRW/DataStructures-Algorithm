package com.xrw.swordfingeroffer;

import java.util.*;

/**
 * @program: DataStructures
 * @description: 矩阵中的路径
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-11-02 14:08
 **/
public class Jz54 {

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param matrix char字符型二维数组
         * @param word   string字符串
         * @return bool布尔型
         */
        public boolean hasPath(char[][] matrix, String word) {
            // write code here
            if (matrix.length == 0 || matrix[0].length == 0 || word.length() > matrix.length * matrix[0].length) {
                return false;
            }
            int[][] a = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == word.charAt(0)) {
                        if (hasPathHelp(a, matrix, word, i, j, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean hasPathHelp(int[][] a, char[][] matrix, String word, int i, int j, int k) {
            if (k == word.length() || matrix[i][j] != word.charAt(k) || a[i][j] == 1) {
                return false;
            }
            if (k == word.length() - 1) {
                return true;
            }
            a[i][j] = 1;
            if (i - 1 >= 0) {
                if (hasPathHelp(a, matrix, word, i - 1, j, k + 1)) {
                    return true;
                }
            }
            if (i + 1 < matrix.length) {
                if (hasPathHelp(a, matrix, word, i + 1, j, k + 1)) {
                    return true;
                }
            }
            if (j - 1 >= 0) {
                if (hasPathHelp(a, matrix, word, i, j - 1, k + 1)) {
                    return true;
                }
            }
            if (j + 1 < matrix[0].length) {
                if (hasPathHelp(a, matrix, word, i, j + 1, k + 1)) {
                    return true;
                }
            }
            //回溯，如果f(k+1)为false，则此路不通，将访问记录设为0
            a[i][j] = 0;
            return false;
        }
    }
}
