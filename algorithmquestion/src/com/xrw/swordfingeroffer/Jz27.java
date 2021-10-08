package com.xrw.swordfingeroffer;

import java.util.ArrayList;
/**
 * @program: DataStructures
 * @description: JZ27 字符串的排列
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-06 18:47
 **/
public class Jz27 {
    /**
     * 总体的解决思路是：
     * 假设输入为a、b、c
     * 那么其实排序的总数：
     * fun（a，b，c）=a（fun（b，c））+ a和b交换（fun（a，c））+a和c交换（fun（b，a））
     * fun（b，c） = b+fun（c）+b和c交换（fun（b））
     * fun（c）=1
     * 所以用递归的方法就可以了，并且在这个递归的过程中，并没有做出一些浪费运行时间的事情，每一个递归都会产生新的结果，因此用递归来解决被称为动态规划的此题，是合理的。
     * 另外题目中说明可能存在重复的字符，因此在进行交换的时候需要判断进行交换的字符是否相等，如果相等就没有必要交换了。
     */
    public static class Solution {

        public ArrayList<String> permutationHelp(StringBuilder str){
            ArrayList<String> result = new  ArrayList<String>();
            if(str.length() == 1) {
                result.add(str.toString());
            } else{
                for(int i = 0; i < str.length(); i++){
                    if(i== 0  || str.charAt(i) != str.charAt(0)){
                        char temp = str.charAt(i);
                        str.setCharAt(i, str.charAt(0));
                        str.setCharAt(0, temp);
                        ArrayList<String> newResult = permutationHelp(new StringBuilder(str.substring(1)));
                        for (String s : newResult) {
                            result.add(str.substring(0, 1) + s);
                        }
                        //用完还是要放回去的
                        temp = str.charAt(0);
                        str.setCharAt(0, str.charAt(i));
                        str.setCharAt(i, temp);
                    }
                }
                //需要在做一个排序操作

            }
            return result;
        }

        public ArrayList<String> Permutation(String str) {
            StringBuilder strBuilder = new StringBuilder(str);
            return permutationHelp(strBuilder);
        }
    }
}
