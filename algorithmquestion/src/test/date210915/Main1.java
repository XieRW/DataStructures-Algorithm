package test.date210915;

import java.util.*;

/**
 * @program: DataStructures-Algorithm
 * @description: 求不包含相同字符的两个单词中的共包含不同字符的总数
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-15 14:57
 **/
public class Main1 {
    public static void main(String[] args) {
        System.out.println(maxSum(new String[]{"abcw","baz","foo","bar","fxyz","abcdef"}));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param words string字符串一维数组 字符串数组
     * @return int整型
     */
    public static int maxSum (String[] words) {
        // write code here
        List<Set<Character>> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
            list.add(set);
        }
        int max=0,now=0;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                Set<Character> set = new HashSet<>();
                set.addAll(list.get(i));
                set.addAll(list.get(j));
                now = set.size();
                if (now == list.get(i).size()+list.get(j).size()){
                    max = max>now?max:now;
                }
            }
        }
        return max;
    }
}
