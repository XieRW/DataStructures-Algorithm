package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ39 平衡二叉树
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-13 10:46
 **/
public class Jz39 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class Solution {
        /**
         * 思路：求根节点的左右子树是否深度差小于等于1，再求其左右子树的左右子树的深度差小于等于1，递归求解
         * @param root
         * @return
         */
        public boolean IsBalanced_Solution(TreeNode root) {
            if (root == null){
                return true;
            }
            return Math.abs(deep(root.left)-deep(root.right))<=1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }

        /**
         * 求节点深度
         * @param root
         * @return
         */
        public int deep(TreeNode root){
            if (root == null){
                return 0;
            }
            return Math.max(deep(root.left),deep(root.right))+1;
        }
    }
}
