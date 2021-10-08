package com.xrw.swordfingeroffer;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: JZ2 替换空格
 * https://www.nowcoder.com/practice/0e26e5551f2b489b9f58bc83aa4b6c68?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
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
        return s.replaceAll(" ", "%20");
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
