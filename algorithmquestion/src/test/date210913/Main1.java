package test.date210913;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main1
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-13 19:30
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String list1 = in.nextLine();
        String[] lists1 = list1.split(",");
        int n = lists1.length;
        lists1[0] = lists1[0].substring(2);
        lists1[n-1] = lists1[n-1].substring(0,1);
//        String[][] str = new String[n][n];
        List<String[]> str = new ArrayList<>();
        str.add(lists1);
        while (in.hasNextLine()){
            String s = in.nextLine();
            if ("".equals(s)){
                break;
            }
            String[] ss = s.split(",");
            ss[0] = ss[0].substring(2);
            ss[n-1] = ss[n-1].substring(0,1);
            str.add(ss);
        }


        int max = 0;
        int now = 0;
        for (int i = 0; i < str.size(); i++) {
            for (int j = 0; j < n; j++) {
                if ("1".equals(str.get(i)[j])){
                    now = 0;
                    now = getMax(str,i,j,now);
                    max = max>now?max:now;
                }
            }
        }
        System.out.println(max);
    }
    static int getMax(List<String[]> str,int i,int j,int now){
        if (i<0||i>=str.size()||j<0||j>=str.get(0).length||"0".equals(str.get(i)[j])){
            return now;
        }
        String[] temp = str.get(i);
        temp[j] = "0";
//        str.remove(i);
        str.set(i,temp);
        now++;
        now = getMax(str,i+1,j,now);
        now = getMax(str,i-1,j,now);
        now = getMax(str,i,j+1,now);
        now = getMax(str,i,j-1,now);
        return now;
    }
}
