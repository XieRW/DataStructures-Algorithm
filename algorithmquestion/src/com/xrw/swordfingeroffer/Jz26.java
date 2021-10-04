package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DataStructures
 * @description: JZ26 二叉搜索树与双向链表
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-04 21:19
 **/
public class Jz26 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 思路：用一个数组来存储中序遍历的节点，然后再从头到尾，建立节点前后的连接关系
     */
    public class Solution {
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return null;
            }
            List<TreeNode> list = new ArrayList<>();
            Convert(list, pRootOfTree);
            return Convert(list);
        }

        public void Convert(List<TreeNode> list, TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return;
            }
            Convert(list, pRootOfTree.left);
            list.add(pRootOfTree);
            Convert(list, pRootOfTree.right);
        }

        public TreeNode Convert(List<TreeNode> list) {
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).right = list.get(i + 1);
                list.get(i + 1).left = list.get(i);
            }
            return list.get(0);
        }
    }

    /**
     * 前序遍历法
     */
    public class Solution2 {
        TreeNode pre=null;
        TreeNode root=null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree==null)
                return null;
            Convert(pRootOfTree.left);
            if (root==null){
                root=pRootOfTree;
            }
            if (pre!= null){
                pRootOfTree.left=pre;
                pre.right=pRootOfTree;
            }
            pre=pRootOfTree;
            Convert(pRootOfTree.right);
            return root;
        }
    }

    /**
     * 解法三 后续遍历法
     */
    public class Solution3 {
        TreeNode pre=null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree==null)
                return null;
            Convert(pRootOfTree.right);
            if (pre!= null){
                pRootOfTree.right=pre;
                pre.left=pRootOfTree;
            }
            pre=pRootOfTree;
            Convert(pRootOfTree.left);
            return pre;
        }
    }
}
