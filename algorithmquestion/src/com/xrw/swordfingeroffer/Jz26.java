package com.xrw.swordfingeroffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DataStructures
 * @description: JZ26 ¶þ²æËÑË÷Ê÷ÓëË«ÏòÁ´±í
 * @author: Ð»ÈÙÍú 1429382875@qq.com
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
    public class Solution {
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null){
                return null;
            }
            List<TreeNode> list = new ArrayList<>();
            Convert(list,pRootOfTree);
            return Convert(list);
        }

        public void Convert(List<TreeNode> list,TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return;
            }
            Convert(list,pRootOfTree.left);
            list.add(pRootOfTree);
            Convert(list,pRootOfTree.right);
        }

        public TreeNode Convert(List<TreeNode> list) {
            for (int i = 0; i < list.size()-1; i++) {
                list.get(i).right = list.get(i+1);
                list.get(i+1).left = list.get(i);
            }
            return list.get(0);
        }
    }
}
