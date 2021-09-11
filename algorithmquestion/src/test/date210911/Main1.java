package test.date210911;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main1
键盘输入
时间限制： 3000MS
内存限制： 589824KB
题目描述：
你在使用一个特殊的键盘输入一个字符串。键盘是一个矩形网格的形状，有各种不同的排列，每个按键上的字符互不相同，最多有 94 个按键（除空格外共有 94 个可见 ASCII 字符，ASCII 码为 33~126）。你需要操作一个机械手来点击这个键盘，机械手可以上下左右移动，每移动一格耗时 x，移动过程中（不包括一开始或者点击前后）转向耗时 y，每次点击键盘耗时 z。一开始，机械手位于左上角。请计算打完这个字符串最少需要多少时间。



输入描述
第一行五个空格隔开的整数 n, m, x, y, z，0 < n * m <= 94，1 <= x, y, z <= 100000

后面 n 行，每行一个由 m 个字符组成的字符串，表示键盘的配列，保证 m 个字符都是 ASCII 可见字符，不是空格且互不相同。

最后一行一个由上述配列中存在的字符组成的字符串，长度不超过 100000。

输出描述
一个整数，表示最少需要的时间


样例输入
2 2 1 1 1
.E
:F
EE:F.:
样例输出
15

提示
步骤拆解

E→2   EE→3   EE: →7（移动中涉及了转向）   EE:F→9   EE:F.→13（移动中涉及了转向）   EE:F.:→15
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-11 19:50
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,m,x,y,z;
        n = in.nextInt();
        m=in.nextInt();
        x=in.nextInt();
        y= in.nextInt();
        z=in.nextInt();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            chars[i] = s.toCharArray();
        }
        String target = in.next();
        int sum = 0;
        int lastJ=0,lastK=0;
        for (int i = 0; i < target.length(); i++) {
            char temp = target.charAt(i);
            boolean l = false;
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < chars[0].length; k++) {
                    if (temp == chars[j][k]){
                        sum += Math.abs(lastJ-j)*x;
                        sum += Math.abs(lastK-k)*x;
                        if (Math.abs(lastJ-j)!=0 && Math.abs(lastK-k)!=0){
                            sum += y;
                        }
                        sum += z;
                        l=true;
                        lastJ = j;
                        lastK = k;
                        break;
                    }
                }
                if (l){
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
