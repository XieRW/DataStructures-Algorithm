package test.date210901;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: 小米笔试题2
整数列表求三的倍数
时间限制： 3000MS
内存限制： 589824KB
题目描述：
给定一个从1到n的整数列表，从第一个数字开始计数，遇到3的倍数时，将该数从列表中删除，直至列表末尾。

在剩下的数字中，从第一个数字开始，继续之前的计数值，同样遇到3的倍数时，删除该数。

循环上面的步骤，直到列表中只剩下一个数字。

根据指定的数字n，来判断最后剩下的数字是哪个。



输入描述
输入:n = 5
过程：第一步： 1, 2, (3), 4, 5
第二步： (1), 2, 4, (5)
第三步：(2), 4
输出描述
输出:4

样例输入
5
样例输出
4
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-01 19:58
 **/
public class Main2 {
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        System.out.println(get(1));
    }

    static int get(int num){
        if (list.size() == 1){
            return list.get(0);
        }
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (num%3 == 0){
                list.remove(list.get(i));
                i--;
            }
            num++;
        }
        return get(num);
    }
}
