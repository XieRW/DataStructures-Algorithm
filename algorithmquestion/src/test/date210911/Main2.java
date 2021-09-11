package test.date210911;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: DataStructures-Algorithm
 * @description: main2
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-11 20:10
 **/
public class Main2 {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] openList;
    static List<Integer> close = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        openList = new int[n];
        int q = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            String s = in.nextLine();
            String[] ss = s.split(" ");
            for (int j = 1; j < ss.length; j++) {
                l.add(Integer.parseInt(ss[j]) - 1);
            }
            list.add(l);
        }
        int sum = 0;
        for (int i = 0; i < q; i++) {
            int operator = in.nextInt();
            int service = in.nextInt() - 1;
            if (operator == 1) {
                if (openList[service] == 0){
                    sum += open(service);
                    openList[service] = 1;
                }
            } else {
                if (openList[service] == 1){
                    close.add(service);
                    openList[service] = 0;
                    sum -= close(service);
                    sum --;
                }
                close.clear();
            }
            System.out.println(sum);
        }


    }

    static int open( int service) {
        if (openList[service] == 1){
            return 0;
        }else {
            int now = 0;
            List<Integer> temp = list.get(service);
            for (int i = 0; i < temp.size(); i++) {
                if (openList[temp.get(i)] == 1){
                    continue;
                }
                now += open(temp.get(i));
            }
            openList[service] = 1;
            now++;
            return now;
        }
    }

    static int close( int service) {
        int now = 0;
        for (int i = 0; i < list.size(); i++) {
            if (openList[service] == 1 && list.get(i).contains(service)){
                openList[service] = 0;
                now++;
                now += close(i);
            }
        }
        return now;
    }

}
