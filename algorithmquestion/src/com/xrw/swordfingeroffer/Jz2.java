package com.xrw.swordfingeroffer;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 牛客网剑指offer第二题
 * 描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 示例1
 * 输入：
 * "We Are Happy"
 * 返回值：
 * "We%20Are%20Happy"
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-12 16:28
 **/
public class Jz2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(replaceSpace(s));
    }

    static String replaceSpace(String s) {
        // write code here
        //第一种解法
        return s.replaceAll(" ","%20");
        //第二种解法
//        StringBuilder sb = new StringBuilder();
//        if(s == null || "".equals(s)){
//            return s;
//        }
//        String[] strs = s.split("");
//        for(String str:strs){
//            if(" ".equals(str)){
//                sb.append("%20");
//            }else{
//                sb.append(str);
//            }
//        }
//        return sb.toString();
        //第三种解法
//        if (s == null) {
//            return null;
//        }
//        StringBuffer str = new StringBuffer(s);
//        int length = str.length();
//        int spaceNum = 0;
//        for (int i = 0; i < length; i++) {
//            if (str.charAt(i) == ' ') {
//                spaceNum++;
//            }
//        }
//
//        int oldStr = length - 1;
//        length += 2 * spaceNum;
//        int newStr = length - 1;
//        str.setLength(length);
//        while (spaceNum > 0 && newStr >= 0) {
//            char ch = str.charAt(oldStr--);
//            if (ch == ' ') {
//                str.setCharAt(newStr--, '0');
//                str.setCharAt(newStr--, '2');
//                str.setCharAt(newStr--, '%');
//                spaceNum--;
//            } else {
//                str.setCharAt(newStr--, ch);
//            }
//        }
//
//        return str.toString();
    }
}
