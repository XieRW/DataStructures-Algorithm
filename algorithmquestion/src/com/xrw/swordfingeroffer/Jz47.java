package com.xrw.swordfingeroffer;

import java.util.ArrayList;

/**
 * @program: DataStructures
 * @description: 二叉树的下一个结点
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-18 17:47
 **/
public class Jz47 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 既然给了二叉树的某个结点，且二叉树存储着指向父结点的指针（next），那我们可以先找到根节点，再对树进行中序遍历，最后根据中序遍历结果找到给定结点的下一结点
     */
    public static class Solution {
        static ArrayList<TreeLinkNode> list = new ArrayList<>();

        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null) {
                return null;
            }
            TreeLinkNode par = pNode;
            while (par.next != null) {
                par = par.next;
            }
            midOrder(par);
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) == pNode) {
                    return list.get(i + 1);
                }
            }
            return null;
        }

        /**
         * 中序遍历
         * @param node
         */
        public void midOrder(TreeLinkNode node) {
            if (node != null) {
                midOrder(node.left);
                list.add(node);
                midOrder(node.right);
            }
        }
    }
}
