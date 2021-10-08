package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ28 数组中出现次数超过一半的数字
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-08 10:29
 **/
public class Jz28 {
    /**
     * 用preValue记录上一次访问的值，count表明当前值出现的次数，
     * 如果下一个值和当前值相同那么count++；如果不同count--，
     * 减到0的时候就要更换新的preValue值了，
     * 因为如果存在超过数组长度一半的值，那么最后preValue一定会是该值
     */
    public class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            if (array.length == 0){
                return 0;
            }
            int count = 1;
            int preValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] == preValue){
                    count++;
                }else {
                    count--;
                    if (count == 0){
                        preValue = array[i];
                        count = 1;
                    }
                }
            }

            //判断最后存活的数是否超过一半
            int num = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == preValue){
                    num++;
                }
            }
            return (num>array.length/2)?preValue:0;
        }
    }
}
