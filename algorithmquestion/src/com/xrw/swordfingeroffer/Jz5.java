package com.xrw.swordfingeroffer;

import java.util.Stack;

/**
 * @program: DataStructures
 * @description: 剑指offer第五题
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-22 22:43
 **/
public class Jz5 {

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.size()<=0){
                while (stack1.size() != 0){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
