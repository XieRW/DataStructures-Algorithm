package test.date210823;

import java.util.*;

/**
 * 阿里笔试第一题，3个人打牌，每个人n张牌，每次每人打一张，选择牌面最小的一张，n次打完，求出最小牌面的总合
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Integer> lists2 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int a = in.nextInt();
                lists2.add(a);
            }
            Collections.sort(lists2);
            lists.add(lists2);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int minIndex = lists.get(0).get(0) < lists.get(1).get(0) ? 0 : 1;
            minIndex = lists.get(minIndex).get(0) < lists.get(2).get(0) ? minIndex : 2;
            sum += lists.get(minIndex).get(0);
            if (minIndex == 0) {
                lists.get(0).remove(0);
                lists.get(1).remove(lists.get(1).size() - 1);
                lists.get(2).remove(lists.get(2).size() - 1);
            } else if (minIndex == 1) {
                lists.get(0).remove(lists.get(0).size() - 1);
                lists.get(1).remove(0);
                lists.get(2).remove(lists.get(2).size() - 1);
            } else {
                lists.get(0).remove(lists.get(0).size() - 1);
                lists.get(1).remove(lists.get(1).size() - 1);
                lists.get(2).remove(0);
            }
        }
        System.out.println(sum);

    }
}
