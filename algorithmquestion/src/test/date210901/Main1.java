package test.date210901;

import java.util.Scanner;

/**
 * 小米笔试
 两个有序数组合并
 时间限制： 3000MS
 内存限制： 589824KB
 题目描述：
 给定两个有序整数数组 A 和 B，将B合并到A中，使得 A 成为一个有序数组。

 说明:

 1. 初始化 A 和 B 的元素数量分别为 m 和 n。

 2. A有足够的空间（空间大小大于或等于 m + n）来保存 B 中的元素。

 3. 默认升序。



 输入描述
 数组A，以及数组A元素数量

 数组B，以及数组B元素数量

 A = [1,6,7,0,0,0], m = 3

 B = [2,4,6], n = 3

 输出描述
 合并后的数组A

 A = [1,2,4,6,6,7];


 样例输入
 m=2,n=2
 1,3
 2,4
 样例输出
 1 2 3 4

 提示
 注意，输入中带'm='和'n='这些字符，也带逗号，需要自行处理。
 * @Author: 谢荣旺
 * @Date: 2021/9/1
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m,n;
        String s = in.next();
        String[] ss = s.split(",");
        String s1 = ss[0].substring(2);
        m = Integer.valueOf(s1);
        String s2 = ss[1].substring(2);
        n = Integer.valueOf(s2);
        int[] arrM = new int[m+n];
        int[] arrN = new int[n];
        String mS = in.next();
        String[] ssM = mS.split(",");
        for (int i = 0; i < ssM.length; i++) {
            arrM[i] = Integer.valueOf(ssM[i]);
        }
        String nS = in.next();
        String[] ssN = nS.split(",");
        for (int i = 0; i < ssN.length; i++) {
            arrN[i] = Integer.valueOf(ssN[i]);
        }
        for (int i = 0; i < arrN.length; i++) {
            boolean target = true;
            for (int j = 0; j < arrM.length; j++) {
                if (arrN[i]<arrM[j]){
                    for (int k = arrM.length-1; k >j ; k--) {
                        arrM[k] = arrM[k-1];
                    }
                    arrM[j] = arrN[i];
                    target = false;
                    break;
                }
            }
            if (target){
                arrM[m]=arrN[i];
            }
            m++;
        }
        for (int i = 0; i < arrM.length; i++) {
            System.out.print(arrM[i]+ " ");
        }
    }
}
