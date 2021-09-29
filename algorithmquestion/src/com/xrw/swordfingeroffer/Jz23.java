package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ23 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 * （ps：我们约定空树不是二叉搜索树）
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-29 14:28
 **/
public class Jz23 {
    public class Solution {
        //思路；
        public boolean VerifySquenceOfBST(int [] sequence) {
            //树为空，返回false
            if (sequence.length == 0){
                return false;
            }
            //判断树是否为二叉搜索树
            return helpVerify(sequence,0,sequence.length-1);
        }
        //判断一个树是否是二叉搜索树
        public boolean helpVerify(int [] sequence,int start ,int root){
            //树的节点个数小于或等于1，返回true
            if (start>=root){
                return true;
            }
            int i;
            int key = sequence[root];
            //找到左右子树的分界点
            for (i=start; i < root; i++) {
                if (sequence[i]>key){
                    break;
                }
            }
            //如果右子树中有小于根节点的值，则返回false
            for (int j = i; j < root; j++) {
                if (sequence[j]<key){
                    return false;
                }
            }
            //判断左、右子树是否是二叉搜索树
            return helpVerify(sequence,start,i-1) && helpVerify(sequence,i,root-1);
        }
    }
}
