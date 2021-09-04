package test.date210904;

import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main1
认识新同学
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小红书校园招聘，某个部门恰好招聘了N*N位（N<=150）同学，为了让大家快速融入大家庭，我们玩儿了一个快速记人和问题速答的游戏，开始是每个人的自我介绍，然后介绍自己的家乡特点和爱好，之后是问题提问，每个人会被问到多个关于另一个同学相关的问题，答对加一分，打错负一分，在所有问答环节结束之后，HR统计在这些同学中，哪个子矩阵区域的同学总分最高，并对这个区域的同学进行鼓励。



输入描述
输入第一行为整数N，第二行为N*N个整数组成(空格分割)，代表同学的答题得分的矩阵（行优先，第一行N个数，接着第二行N个数，以此类推）。

输出描述
队伍中一个得分最高的子队伍得分


样例输入
3
1 2 -3 3 4 -5 -5 -6 -7
样例输出
10
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-04 10:38
 **/
public class Main1 {
    static int[][] arr;
    static int n;
    static int nMax = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((s = max(i,j,i,j,0,0))>nMax){
                    nMax = s;
                }
                for (int k = 0; k < n; k++) {
                    if ((s = max2(i,j,k,j,0,0))>nMax){
                        nMax = s;
                    }
                }
                for (int k = j; k < n; k++) {
                    if ((s = max3(i,j,i,k,0,0))>nMax){
                        nMax = s;
                    }
                }

            }
        }
        System.out.println(nMax);
    }

    static int max(int startI,int startJ,int endI,int endJ,int max,int now){
        for (int k = startJ; k <= endJ; k++) {
            now += arr[endI][k];
        }
        for (int k = startI; k <= endI; k++) {
            now += arr[k][endJ];
        }
        now -= arr[endI][endJ];
        if (now>max){
            max = now;
        }
        if (endI+1 == n|| endJ +1 == n){
            return max;
        }
        return max(startI,startJ,endI+1,endJ+1,max,now);
    }

    static int max2(int startI,int startJ,int endI,int endJ,int max,int now){
        for (int k = startI; k <= endI; k++) {
            now += arr[k][endJ];
        }

        if (now>max){
            max = now;
        }
        if (endJ +1 == n){
            return max;
        }
        return max2(startI,startJ,endI,endJ+1,max,now);
    }

    static int max3(int startI,int startJ,int endI,int endJ,int max,int now){
        for (int k = startJ; k <= endJ; k++) {
            now += arr[endI][k];
        }
        if (now>max){
            max = now;
        }
        if (endI+1 == n){
            return max;
        }
        return max3(startI,startJ,endI+1,endJ,max,now);
    }
}
