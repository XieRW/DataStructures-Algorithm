package com.xrw.swordfingeroffer;

import java.util.*;

/**
 * @program: DataStructures
 * @description: 把二叉树打印成多行
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-26 23:19
 **/
public class Jz49 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 维护一个队列，每次只保存当前层的结点
     * 通过两个左右指针，对每一层的遍历从左指针遍历到右指针，同时收集结果
     * 对每个结点，如果有子节点，则按顺序加入左右子节点到队列，为下一层遍历做准备
     */
    public class Solution {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            if (pRoot == null) {
                return res;
            }
            // 队列每次只保存当前层的结点
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(pRoot);
            while (!queue.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                // lo为每一层的左边结点指针，hi为右边结点指针
                int lo = 0, hi = queue.size();
                // 从左到右按顺序遍历当前层的每一个节点
                while (lo++ < hi) {
                    TreeNode node = queue.poll();
                    // 收集当前层每一个结点的值
                    if (node != null) {
                        list.add(node.val);
                    }
                    // 按顺序加入左右子节点，为下一层遍历做准备
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                // 收集当前层的结果集
                res.add(list);
            }
            return res;
        }
    }
}
