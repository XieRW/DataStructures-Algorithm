package com.xrw.swordfingeroffer;

import java.util.Stack;

/**
 * @program: DataStructures
 * @description: JZ5 用两个栈实现队列
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-22 22:43
 **/
public class Jz5 {

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        //push时直接放入第一个栈
        public void push(int node) {
            stack1.push(node);
        }

        //pop时从第二个栈pop，如果stack2为空，则将stack1的数据全部pop进stack2
        public int pop() {
            if (stack2.size() <= 0) {
                while (stack1.size() != 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
