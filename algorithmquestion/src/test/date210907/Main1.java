package test.date210907;

import java.util.Arrays;

/**
 * @program: DataStructures-Algorithm
 * @description: main1
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-07 19:28
 **/
public class Main1 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * max age increasing subsequence
     * @param members int整型一维数组 年龄乱序的团队成员
     * @return int整型
     */
    public int MALS (int[] members) {
        Arrays.sort(members);
        int n = members.length;
        int age;
        int max=0;
        int now=0;
        for (int i = 0; i < n; i++) {
            age = members[i];
            now = 0;
            for (int j = i; j < n; j++) {
                if (age == members[j]){
                    age++;
                    now++;
                }
            }
            if (now >max){
                max = now;
            }
        }
        return max;
    }
}
