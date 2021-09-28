package com.xrw.swordfingeroffer;

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

/**
 * @program: DataStructures
 * @description: JZ20 包含min函数的栈
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-28 15:20
 **/
public class Jz20 {
    /**&
     *     解法一：在看到这道题目的时候第一反应是要用一个最小值来保留当前栈中最小值，
     *     但是也能够很快地意识到比较麻烦的地方在于pop的时候怎么更新min值，
     *     看了别人的题解之后都是使用了另外一个栈来保持在入栈过程中曾经做过最小值的值，
     *     pop的时候判断两个栈顶元素是否一致，一致的话都要pop，在这种情况下取最小值需要从保存最小值的栈顶元素取值
     *
     *     我自己的想法是不希望用另外一个栈，那么为了实现这一目的，在栈中需要保留冗余的曾经的最小值，这样能够比较方便到找到当前的此小值，具体见下面的代码
     */
    public class Solution {
        Stack<Integer> stack = new Stack<>();
        Integer minElement = Integer.MAX_VALUE;

        public void push(int node) {
            if (stack.empty()) {
                minElement = node;
                stack.push(node);
            } else {
                if (node <= minElement) {
                    stack.push(minElement);
                    minElement = node;
                }
                stack.push(node);
            }
        }

        public void pop() {
            if (stack.empty()) {
                return;
            }
            if (stack.peek().equals(minElement)) {
                if (stack.size() > 1) {
                    stack.pop();
                    minElement = stack.peek();
                } else {
                    minElement = Integer.MAX_VALUE;
                }
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minElement;
        }
    }

    /**
     *     解法二：优化上一个解法
     */
    public class Solution2 {
        Stack<Integer> stack = new Stack<>();
        Integer minElement = Integer.MAX_VALUE;

        public void push(int node) {
            if (node <= minElement) {
                stack.push(minElement);
                minElement = node;
            }
            stack.push(node);
        }

        public void pop() {
            if (stack.empty()) {
                return;
            }
            if (stack.peek().equals(minElement)) {
                    stack.pop();
                    minElement = stack.peek();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minElement;
        }
    }
}
