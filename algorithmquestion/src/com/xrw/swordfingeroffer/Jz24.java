package com.xrw.swordfingeroffer;

import java.util.ArrayList;

/**
 * @program: DataStructures
 * @description: JZ24 二叉树中和为某一值的路径
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-29 15:23
 **/
public class Jz24 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 解法一：回溯法，每次找到叶子节点且路径和满足要求时，添加一个路径list到结果集中，然后通过回溯，把此路径经过的节点添加进去
     */
    public class Solution {
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            helpFindPath(root, target, 0, lists);
            return lists;
        }

        public void helpFindPath(TreeNode root, int target, int now, ArrayList<ArrayList<Integer>> lists) {
            now += root.val;
            ArrayList<Integer> list = new ArrayList<>();
            if (now > target) {
                return;
            }
            if (root.left == null && root.right == null) {
                if (now == target) {
                    list.add(root.val);
                    lists.add(list);
                }
                return;
            }
            if (root.left != null) {
                helpFindPath(root.left, target, now, lists);

            }
            if (root.right != null) {
                helpFindPath(root.right, target, now, lists);
            }
            if (!lists.isEmpty()) {
                for (int i = 0; i < lists.size(); i++) {
                    lists.get(i).add(0, root.val);
                }
            }
        }
    }

    /**
     * 解法二：递归求路径，求到了之后添加到结果集中
     */
    public class Solution2 {
        private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        private ArrayList<Integer> list = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root == null) return result;
            list.add(root.val);
            target -= root.val;
            if (target == 0 && root.left == null && root.right == null) {
                result.add(new ArrayList<Integer>(list));
            }
            ArrayList<ArrayList<Integer>> result1 = FindPath(root.left, target);
            ArrayList<ArrayList<Integer>> result2 = FindPath(root.right, target);
            list.remove(list.size() - 1);
            return result;
        }
    }
}
