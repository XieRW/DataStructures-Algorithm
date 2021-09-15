package test.date210915;

/**
 * @program: DataStructures-Algorithm
 * @description: 求股票的最大收益
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-15 15:24
 **/
public class Main2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 4, 2}));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算最大收益
     *
     * @param prices int整型一维数组 股票价格数组
     * @return int整型
     */
    public static int maxProfit(int[] prices) {
        // write code here
        int max=0,start = prices[0], stop = prices[0],x=0,y=0;
        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < start) {
                start = prices[i];
                stop = prices[i];
                x=i;
                y=i;
            }
            if (prices[i]>stop){
                stop = prices[i];
                y=i;
            }
            max = stop-start>max?stop-start:max;
        }
        return max;
    }
}
