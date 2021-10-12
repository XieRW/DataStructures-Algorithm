package com.xrw.swordfingeroffer;

/**
 * @program: DataStructures
 * @description: JZ35 数组中的逆序对
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-10-12 10:15
 **/
public class Jz35 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int count = 0;
        while (count >= 0) {
            count++;
        }
        System.out.println(2147483647 + 1);
    }

    /**
     * 解法一：遍历整个数组，拿一个元素，依次与后面的元素比较，判断是否是逆序对
     */
    public class Solution {

        public int InversePairs(int[] array) {
            if (array.length == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        count++;
                        count %= 1000000007;
                    }
                }
            }
            return count;
        }
    }

    /**
     * 解法二：分治算法+归并排序
     */
    public class Solution2 {

        public int InversePairs(int[] array) {
            if (array.length == 0) {
                return 0;
            }
            return merge(array, 0, array.length - 1);
        }

        public int merge(int[] nums, int start, int end) {
            if (start >= end) {
                return 0;
            }
            int count = 0;
            int mid = (start + end) / 2;
            count += merge(nums, start, mid);
            count += merge(nums, mid + 1, end);
            int i = start;
            int j = mid + 1;
            int[] temp = new int[end - start + 1];
            int p = 0;
            while (i <= mid && j <= end) {
                if (nums[i] < nums[j]) {
                    temp[p] = nums[i];
                    p++;
                    i++;
                } else {
                    count = (count + (mid - i + 1)) % 1000000007;
                    temp[p] = nums[j];
                    j++;
                    p++;
                }
            }
            while (i <= mid) {
                temp[p] = nums[i];
                p++;
                i++;
            }
            while (j <= end) {
                temp[p] = nums[j];
                p++;
                j++;
            }
            for (int k = 0; k < temp.length; k++) {
                nums[start + k] = temp[k];
            }

            return count;
        }
    }

    /**
     * 牛客题解：[A，B]中的逆序对=[A]的逆序对+[B]中的逆序对+将A，B混排在一起的逆序对
     */
    public class Solution3 {
        private int cnt;
        private void MergeSort(int[] array, int start, int end){
            if(start>=end)return;
            int mid = (start+end)/2;
            MergeSort(array, start, mid);
            MergeSort(array, mid+1, end);
            MergeOne(array, start, mid, end);
        }
        private void MergeOne(int[] array, int start, int mid, int end){
            int[] temp = new int[end-start+1];
            int k=0,i=start,j=mid+1;
            while(i<=mid && j<= end){
//如果前面的元素小于后面的不能构成逆序对
                if(array[i] <= array[j])
                    temp[k++] = array[i++];
                else{
//如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                    temp[k++] = array[j++];
                    cnt = (cnt + (mid-i+1))%1000000007;
                }
            }
            while(i<= mid)
                temp[k++] = array[i++];
            while(j<=end)
                temp[k++] = array[j++];
            for(int l=0; l<k; l++){
                array[start+l] = temp[l];
            }
        }
        public int InversePairs(int [] array) {
            MergeSort(array, 0, array.length-1);
            return cnt;
        }
    }
}
