package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 剑指offer第十七题 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 输入：{8,8,#,9,#,2,#,5},{8,9,#,2}
 * 输出：true
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-28 10:13
 **/
public class Jz17 {
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    /**
     * 思路：先写一个判断两个树结构是否一样的方法A，然后在方法B中遍历root1的每个节点，调用A方法，看看有没有一个节点的树结构和root2一样
     */
    public class Solution {
        public boolean HasSubtree(TreeNode root1,TreeNode root2) {
            if (root1 == null || root2 == null){
                return false;
            }

            return doesTree1HasTree2(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }

        public boolean doesTree1HasTree2(TreeNode root1,TreeNode root2){
            if (root2 == null){
                return true;
            }
            if (root1 == null){
                return false;
            }
            if (root1.val != root2.val){
                return false;
            }
            return doesTree1HasTree2(root1.left,root2.left) && doesTree1HasTree2(root1.right,root2.right);
        }
    }
}
