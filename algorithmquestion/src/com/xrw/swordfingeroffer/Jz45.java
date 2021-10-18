package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: DataStructures
 * @description: °´Ö®×ÖÐÎË³Ðò´òÓ¡¶þ²æÊ÷
 * @author: Ð»ÈÙÍú 1429382875@qq.com
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
     * Ë«Õ»·¨
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
}
