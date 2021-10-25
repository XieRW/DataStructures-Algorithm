package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: DataStructures
 * @description: 二叉搜索树的第k个结点
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-18 16:58
 **/
public class Jz46 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 方法一：用一个列表保存中序遍历结果，然后返回第k个值
     */
    public class Solution {
        TreeNode KthNode(TreeNode pRoot, int k) {
            if (pRoot == null || k == 0) {
                return null;
            }
            ArrayList<TreeNode> list = new ArrayList<>();
            DFS(pRoot, list);
            if (k > list.size()) {
                return null;
            }
            return list.get(k - 1);
        }

        public void DFS(TreeNode pRoot, ArrayList<TreeNode> list) {
            if (pRoot == null) {
                return;
            }
            DFS(pRoot.left, list);
            list.add(pRoot);
            DFS(pRoot.right, list);
        }

    }

    /**
     * 利用栈实现非递归的中序遍历
     */
    public class Solution2 {
        TreeNode KthNode(TreeNode pRoot, int k) {
            if (pRoot == null || k == 0) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = pRoot;
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    if (--k == 0) {
                        return cur;
                    }
                    cur = cur.right;
                }
            }
            return null;
        }
    }
}
