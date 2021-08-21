package test.date210821;
/*
魔法师过河
时间限制： 3000MS
内存限制： 589824KB
题目描述：
魔法世界里有一位魔法师, 他要踏着河中间的几块石头走到对岸.有的石头上放了一块白水晶, 有的石头上放了一块黑水晶, 还有的石头上什么也没有放.魔法师需要将空的石头上放上一块黑水晶或者白水晶,使得黑水晶和白水晶的个数是一样, 这样才能过河.

但空的石头上放上黑水晶或者白水晶需要消耗魔法师的能量, 并且不同的石头上面放白水晶和黑水晶所需要的能量是不一样的.

输入会给出所有石头上的水晶颜色,如果是空的话,会分别给出魔法师放黑水晶和白水晶所需要的能量.

你的程序需要输出魔法师过河所需要的最少能量, 如果无法过河, 则输出-1.



输入描述
第一行表示石头的个数. (0 < N < 5000000)

从第二行开始有N行, 每一行的第一个数字代表水晶颜色, 1=白, 2=黑, 0=空, 如果是空的话, 这一行的第2和第3个数字分别表示放置白水晶和黑水晶所需要的能量

输出描述
输出需要的最小能量值. 如果不能过河, 则输出-1.


样例输入
10
1
1
0 1 2
2
2
2
1
0 2 4
0 2 8
1
样例输出
8
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {
    static int resultboolean = 0;
    static int result = 0;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            in.nextLine();
            String s = in.nextLine();
            String[] data = s.split(" ");
            List<Integer> list2 = new ArrayList<>();
            for (int j = 0; j < data.length; j++) {
                list2.add(Integer.parseInt(data[j]));
            }
            list.add(list2);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(0).equals(0)){

            }else if (list.get(0).equals(1)){
                resultboolean = resultboolean+1;
            }else {
                resultboolean = resultboolean-1;
            }
        }
        if (resultboolean == 0){
            System.out.println(0);
            return;
        }else {

        }
    }
    static int[] get() {
        int resultboolean1 = 0;
        int result1 = 0;
        int count=0;
        List<List<Integer>> listResult = new ArrayList<>();
        List<List<Integer>> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0) == 0) {
                newList.add(list.get(i));
            }
        }
        for (int i = 0; i < newList.size(); i++) {
            count = 2*count;
        }
        for (int i = 0; i < count; i++) {
            boolean temp = false;
            for (int j = 0; j < newList.size(); j++) {
                if (newList.get(j).get(0) == 0){
                    if (!temp){
                        newList.get(j).set(0,1);
                        temp = true;
                    }
                    result1 = newList.get(j).get(1)+ result1;
                    resultboolean1 = resultboolean1 +1;
                }else if(newList.get(j).get(0) == 1){
                    newList.get(j).set(0,2);
                    result1 = newList.get(j).get(1)+ result1;
                    resultboolean1 = resultboolean1 -1;
                }else {
                    newList.get(j).set(0,2);
                    result1 = newList.get(j).get(1)+ result1;
                    resultboolean1 = resultboolean1 -1;
                }
                result1 = newList.get(j).get(1)+ result1;
            }
        }
        return new int[]{resultboolean1,result1};
    }
}
