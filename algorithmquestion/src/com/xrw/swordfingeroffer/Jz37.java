package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ37 数字在升序数组中出现的次数
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-13 09:50
 **/
public class Jz37 {
    /**
     * 解法1：遍历数组，时间复杂度O(n)
     */
    public class Solution {
        public int GetNumberOfK(int [] array , int k) {
            int count = 0;
            for(int e:array){
                if(k==e) {
                    count++;
                }
            }
            return count;
        }
    }

    public class Solution2 {
        public int GetNumberOfK(int [] array , int k) {
            if (array.length == 0){
                return 0;
            }
            return countHelp(array,0,array.length-1,k);
        }

        public int countHelp(int[] array,int start,int end,int k){
            if (start == end){
                if (k==array[start]){
                    return 1;
                }else {
                    return 0;
                }
            }
            int count=0;
            int mid = (start+end)/2;
            if (k==array[mid]){
                count+=countHelp(array,start,mid,k);
                count+=countHelp(array,mid+1,end,k);
            }else if (k>array[mid]){
                count+=countHelp(array,mid+1,end,k);
            }else {
                count+=countHelp(array,start,mid,k);
            }
            return count;
        }
    }
}
