package com.xrw.swordfingeroffer;

import com.sun.xml.internal.bind.v2.model.core.MaybeElement;
import org.omg.CORBA.INTERNAL;

/**
 * @program: DataStructures
 * @description: JZ30 连续子数组的最大和
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-08 15:38
 **/
public class Jz30 {

    public class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            if (array.length == 0) {
                return 0;
            }
            int sum = Integer.MIN_VALUE;
            int num = 0;
            for (int i = 0; i < array.length; i++) {
                sum = Math.max(array[i], sum);
                if (array[i] > 0) {
                    num += array[i];
                    sum = Math.max(num, sum);
                } else {
                    if (num + array[i] > 0) {
                        num += array[i];
                    } else {
                        num = 0;
                    }
                }
            }
            return sum;
        }
    }
}
