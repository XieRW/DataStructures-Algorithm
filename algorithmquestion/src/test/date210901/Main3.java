package test.date210901;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 仅用数组的写法
 * <p>
 * 整数列表求三的倍数
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个从1到n的整数列表，从第一个数字开始计数，遇到3的倍数时，将该数从列表中删除，直至列表末尾。
 * <p>
 * 在剩下的数字中，从第一个数字开始，继续之前的计数值，同样遇到3的倍数时，删除该数。
 * <p>
 * 循环上面的步骤，直到列表中只剩下一个数字。
 * <p>
 * 根据指定的数字n，来判断最后剩下的数字是哪个。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入:n = 5
 * 过程：第一步： 1, 2, (3), 4, 5
 * 第二步： (1), 2, 4, (5)
 * 第三步：(2), 4
 * 输出描述
 * 输出:4
 * <p>
 * 样例输入
 * 5
 * 样例输出
 * 4
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-02 20:04
 * 思路：
 * 1、初始化数组
 * 2、递归求出剩下的元素
 * a、退出条件
 * b、删除条件
 * c、递归
 **/
public class Main3 {
    static int[] arr;
    static int n;
    //剩余元素的个数
    static int target;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        target = n;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.println(get(1));
    }

    static int get(int num) {
        if (target==1){
            for (int i = 0; i < n; i++) {
                if (arr[i]!=0){
                    return arr[i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0){
                continue;
            }
            if (num%3==0){
                arr[i] = 0;
                target -= 1;
            }
            num++;
        }
        return get(num);
    }
}
