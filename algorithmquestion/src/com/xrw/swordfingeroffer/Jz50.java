package com.xrw.swordfingeroffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: DataStructures
 * @description: ÐòÁÐ»¯¶þ²æÊ÷
 * @author: Ð»ÈÙÍú 1429382875@qq.com
 * @create: 2021-11-01 10:30
 **/
public class Jz50 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class Solution {
        public int index = -1;

        String Serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            if (root == null) {
                sb.append("#,");
                return sb.toString();
            }
            sb.append(root.val + ",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
            return sb.toString();
        }

        TreeNode Deserialize(String str) {
            index++;
            int len = str.length();
            if (index >= len) {
                return null;
            }
            String[] strr = str.split(",");
            TreeNode node = null;
            if (!strr[index].equals("#")) {
                node = new TreeNode(Integer.valueOf(strr[index]));
                node.left = Deserialize(str);
                node.right = Deserialize(str);
            }

            return node;
        }
    }
}
