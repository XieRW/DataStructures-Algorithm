package com.xrw.swordfingeroffer;

import java.util.Stack;

/**
 * @program: DataStructures
 * @description: JZ21 栈的压入、弹出序列
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-29 13:54
 **/
public class Jz21 {
    public class Solution {

        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> stack = new Stack<>();
            int j=0;
            for (int i = 0; i < pushA.length; i++) {
                stack.push(pushA[i]);
                if (stack.peek().equals(popA[j])){
                    stack.pop();
                    j++;
                    while (!stack.isEmpty()){
                        if (stack.peek().equals(popA[j])){
                            stack.pop();
                            j++;
                        }else {
                            break;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
