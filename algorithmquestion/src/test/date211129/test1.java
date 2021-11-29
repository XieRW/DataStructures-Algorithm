package test.date211129;

/**
 * @program: DataStructures-Algorithm
 * @description: 面试 思谋科技二面 leecode236
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-11-29 20:05
 **/
public class test1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：
     * 1、   p、q应该在root的异侧，否则不为最近公共根节点  或者p为root，q在p的子树中，或者q为root，p在q的子树中；
     * 2、
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        return root;
    }
}
