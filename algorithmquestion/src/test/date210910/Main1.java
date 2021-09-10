package test.date210910;

/**
 * @program: DataStructures-Algorithm
 * @description: main1
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-10 17:03
 **/
public class Main1 {
    public static void main(String[] args) {
        System.out.println(canBePalindromicString("abca"));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str1 string字符串 输入字符串str1
     * @return int整型
     */
    public static int canBePalindromicString (String str1) {
        // write code here
        int can = 0;
        int n = str1.length();
        StringBuilder sb = new StringBuilder();
//        char[] c1 = str1.toCharArray();
//        char[] c2 = new char[n+2];
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder(str1);
            sb.replace(i,i,String.valueOf(sb.charAt(n-i-1)));
            sb.replace(i+1,i+1,String.valueOf(sb.charAt(n+1-i-2)));
            if (can(sb.toString())){
                return 1;
            }
        }
        sb = new StringBuilder(str1);
        sb.append(str1.charAt(1));
        sb.append(str1.charAt(0));
        if (can(sb.toString())){
            return 1;
        }
        return 0;
    }
    
    static boolean can(String str){
        int n = str.length();
        for (int i = 0; i <= n/2; i++) {
            if (str.charAt(i) != str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
