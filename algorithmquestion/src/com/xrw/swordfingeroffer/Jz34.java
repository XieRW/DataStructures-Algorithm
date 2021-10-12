package com.xrw.swordfingeroffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program: DataStructures
 * @description: JZ34 第一个只出现一次的字符
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-12 09:47
 **/
public class Jz34 {
    public class Solution {
        public int FirstNotRepeatingChar(String str) {
            if (str == null || str.length() == 0){
                return -1;
            }
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (!map.keySet().contains(str.charAt(i))){
                    map.put(str.charAt(i),1);
                }else {
                     map.put(str.charAt(i),map.get(str.charAt(i))+1);
                }
            }
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str.charAt(i)) == 1){
                    return i;
                }
            }
            return -1;
        }
    }
}
