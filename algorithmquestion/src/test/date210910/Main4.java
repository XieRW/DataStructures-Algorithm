package test.date210910;

import java.util.Arrays;

/**
 * @program: DataStructures-Algorithm
 * @description: main4
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-10 18:16
 **/
public class Main4 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 从两个升序数组中，找到第k小的数
     * @param arr1 int整型一维数组 整数数组，长度为[1, 10^9]
     * @param arr2 int整型一维数组 第二个数组，长度为[1, 10^9]
     * @param k int整型 要输出的数所在的位置，取值范围为 [1, 两个数组的长度之和]
     * @return int整型
     */
    public int find_kth (int[] arr1, int[] arr2, int k) {
        // write code here
        int[] arr = new int[arr1.length+arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        for (int i = arr1.length; i < arr1.length+arr2.length; i++) {
            arr[i] = arr2[i-arr1.length];
        }
        Arrays.sort(arr);
        return arr[k];
    }
}
