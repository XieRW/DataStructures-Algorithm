package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 对称的二叉树
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=23452&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author: 谢荣旺 1429382875@qq.com
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

    /**
     * 设置一个递归函数isSame(r1, r2),表示如果对称，返回true，否则返回false
     * 递归终止条件：r1==nullptr && r2==nulllptr, 直接返回true，否则，如果只有一个为nullptr，返回false
     * 下一步递归：如果r1->val == r2->val, 则isSame(root1->left, root2->right) && isSame(root1->right, root2->left);
     */
    public class Solution {

        boolean isSymmetrical(TreeNode pRoot) {
            return isSame(pRoot.left, pRoot.right);
        }

        boolean isSame(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && isSame(left.left, right.right) && isSame(right.left, left.right);
        }
    }
}
