package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: ¶Ô³ÆµÄ¶þ²æÊ÷
 * @author: Ð»ÈÙÍú 1429382875@qq.com
 * @create: 2021-10-22 14:59
 **/
public class Jz48 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public class Solution {
        boolean isSymmetrical(TreeNode pRoot) {
            return isSame(pRoot.left,pRoot.right);
        }

        boolean isSame(TreeNode left,TreeNode right){
            if (left==null&&right==null){
                return true;
            }
            if (left==null||right==null){
                return false;
            }
            return left.val == right.val && isSame(left.left,right.right) && isSame(right.left,left.right);
        }
    }

}
