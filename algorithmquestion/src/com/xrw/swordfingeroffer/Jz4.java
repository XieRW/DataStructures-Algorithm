package com.xrw.swordfingeroffer;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 剑指offer第四题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-13 10:25
 **/
public class Jz4 {

    public static void main(String[] args) {

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
            if (pre.length==0 || vin.length==0){
                return null;
            }
            TreeNode root = new TreeNode(pre[0]);
            //在中序数组中找根
            for (int i = 0; i < vin.length; i++) {
                if (vin[i] == pre[0]){
                    root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(vin,0,i));
                    root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(vin,i+1,vin.length));
                    break;
                }
            }
            return root;
        }
    }
}
