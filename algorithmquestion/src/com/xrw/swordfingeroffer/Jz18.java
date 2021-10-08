package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ18 二叉树的镜像
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-28 11:19
 **/
public class Jz18 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param pRoot TreeNode类
         * @return TreeNode类
         */
        public TreeNode Mirror(TreeNode pRoot) {
            // write code here
            if (pRoot == null) {
                return pRoot;
            }
            TreeNode temp = pRoot.left;
            pRoot.left = Mirror(pRoot.right);
            pRoot.right = Mirror(temp);
            return pRoot;

        }
    }
}
