package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: DataStructures
 * @description: 按之字形顺序打印二叉树
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-18 16:01
 **/
public class Jz45 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 双栈法
     */
    public class Solution {
        public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (pRoot == null) {
                return result;
            }
            Stack<TreeNode> tmp = new Stack<>();
            Stack<TreeNode> tmp1 = new Stack<>();
            tmp.add(pRoot);
            while (tmp.size() > 0 || tmp1.size() > 0) {
                ArrayList<Integer> flood = new ArrayList<>();
                if (tmp.size() > 0) {
                    int size = tmp.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode pop = tmp.pop();
                        flood.add(pop.val);
                        if (pop.left != null) {
                            tmp1.add(pop.left);
                        }
                        if (pop.right != null) {
                            tmp1.add(pop.right);
                        }

                    }
                    result.add(flood);
                    continue;
                }
                int size = tmp1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = tmp1.pop();
                    flood.add(pop.val);
                    if (pop.right != null) {
                        tmp.add(pop.right);
                    }
                    if (pop.left != null) {
                        tmp.add(pop.left);
                    }
                }
                result.add(flood);
            }
            return result;
        }

    }

    /**
     * 队列
     */
    public class Solution2 {
        public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            LinkedList<TreeNode> q = new LinkedList<>();
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            boolean rev = true;
            q.add(pRoot);
            while(!q.isEmpty()){
                int size = q.size();
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=0; i<size; i++){
                    TreeNode node = q.poll();
                    if(node == null){continue;}
                    if(rev){
                        list.add(node.val);
                    }else{
                        list.add(0, node.val);
                    }
                    q.offer(node.left);
                    q.offer(node.right);
                }
                if(list.size()!=0){res.add(list);}
                rev=!rev;
            }
            return res;
        }
    }
}
