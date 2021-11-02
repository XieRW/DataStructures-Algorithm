package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: 正则表达式匹配
 * https://www.nowcoder.com/practice/28970c15befb4ff3a264189087b99ad4?tpId=13&tqId=1375406&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-11-02 13:43
 **/
public class Jz53 {
    /**
     * 假设主串为 str，模式串为 pattern 从最后一步出发，需要关注最后进来的字符。假设 str 的长度为 n ，pattern的长度为 m ，关注正则表达式 pattern的最后一个字符是谁，它有三种可能，正常字符、'*' 和 '.'（点），那针对这三种情况讨论即可，如下：
     * 1、如果 pattern的最后一个字符是正常字符，那就是看str[n?1] 是否等于 pattern[m?1]，相等则看str [0..n?2]与 pattern [0..m?2]，不等则是不能匹配，这就是子问题。
     * 2、如果 pattern 的最后一个字符是 ‘.’，它能匹配任意字符，直接看 str [0..n?2]与 pattern [0..m?2]
     * 3、如果 pattern 的最后一个字符是‘*’，它代表 pattern[m-2]=c 可以重复0次或多次，它们是一个整体 c*
     * 情况一：str[n-1] 是 0 个 c，pattern最后两个字符废了，能否匹配取决于 str [0..n?1]和 pattern [0..m?3]是否匹配
     * 情况二：str[n-1] 是多个 c 中的最后一个（这种情况必须 str[n-1]=c 或者 c='.'），所以str 匹配完往前挪一个，pattern  继续匹配，因为可以匹配多个，继续看str[0..n?2]和 pattern[0..m?1]是否匹配。
     * <p>
     * 转移方程
     * f[i][j] 代表 str 的前 i 个和 pattern 的前 j 个能否匹配
     * 对于前面两个情况，可以合并成一种情况 f[i][j]=f[i?1][j?1]
     * 对于第三种情况，对于 c* 分为看和不看两种情况
     * 不看：直接砍掉正则串pattern 的后面两个， f[i][j]=f[i][j?2]
     * 看：正则串pattern 不动，主串str前移一个，f[i][j]=f[i?1][j]
     * <p>
     * 初始条件
     * 特判：需要考虑空串空正则
     * 空串和空正则是匹配的，f[0][0]=true
     * 空串和非空正则，不能直接定义 true 和 false，必须要计算出来。（比如str= '' '' ,pattern=a*b*c*）
     * 非空串和空正则必不匹配，f[1][0]=...=f[n][0]=false
     * 非空串和非空正则，那肯定是需要计算的了。
     * 大体上可以分为空正则和非空正则两种，空正则也是比较好处理的，对非空正则我们肯定需要计算，非空正则的三种情况，前面两种可以合并到一起讨论，第三种情况是单独一种，那么也就是分为当前位置是 '*' 和不是 '*' 两种情况了。
     * 结果
     * 我们开数组要开 n+1 ，这样对于空串的处理十分方便。结果就是 f[n][m]
     */
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param str     string字符串
         * @param pattern string字符串
         * @return bool布尔型
         */
        public boolean match(String str, String pattern) {
            // write code here
            int n = str.length();
            int m = pattern.length();
            boolean[][] f = new boolean[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    //分成空正则和非空正则两种
                    if (j == 0) {
                        f[i][j] = i == 0;
                    } else {
                        //非空正则分为两种情况 * 和 非*
                        if (pattern.charAt(j - 1) != '*') {
                            if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                                f[i][j] = f[i - 1][j - 1];
                            }
                        } else {
                            //碰到 * 了，分为看和不看两种情况
                            //不看
                            if (j >= 2) {
                                f[i][j] |= f[i][j - 2];
                            }
                            //看
                            if (i >= 1 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')) {
                                f[i][j] |= f[i - 1][j];
                            }
                        }
                    }
                }
            }
            return f[n][m];
        }
    }
}
