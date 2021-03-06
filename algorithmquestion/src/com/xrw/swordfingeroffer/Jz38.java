package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ38 二叉树的深度
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-13 10:09
 **/
public class Jz38 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 深度遍历
     */
    public class Solution {
        public int TreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
        }
    }
}
