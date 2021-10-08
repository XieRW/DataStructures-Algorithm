package com.xrw.swordfingeroffer;

import java.util.Stack;

/**
 * @program: DataStructures
 * @description: JZ21 栈的压入、弹出序列
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-29 13:54
 **/
public class Jz21 {
    public class Solution {
        //思路：新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true
        public boolean IsPopOrder(int[] pushA, int[] popA) {
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            for (int i = 0; i < pushA.length; i++) {
                stack.push(pushA[i]);
                if (stack.peek().equals(popA[j])) {
                    stack.pop();
                    j++;
                    while (!stack.isEmpty()) {
                        if (stack.peek().equals(popA[j])) {
                            stack.pop();
                            j++;
                        } else {
                            break;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
