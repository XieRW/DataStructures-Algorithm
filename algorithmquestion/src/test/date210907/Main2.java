package test.date210907;

import java.util.Arrays;

/**
 * @program: DataStructures-Algorithm
 * @description: main2
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-07 19:37
 **/
public class Main2 {
    public static void main(String[] args) {
        int[] arr = findNums(new int[]{2,2,3,4,5});
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型一维数组
     */
    public static int[] findNums (int[] nums) {
        // write code here
        Arrays.sort(nums);
        int n = nums.length;
        int[] arr = new int[2];
        boolean target = true;
        for (int i = 0; i < n-1; i++) {
            if (target && nums[i] != i+1){
                arr[1] = i+1;
                target = false;
            }
            if (nums[i] == nums[i+1]){
                arr[0] = nums[i];
                if (!target){
                    break;
                }
                if (i+2 == n || nums[i+2] == nums[i]+2){
                    arr[1] = nums[i]+1;
                    break;
                }else {
                    for (int j = i+2; j < n; j++) {
                        if (nums[j] % n != j){
                            arr[1] = j;
                            break;
                        }
                        if (j == n-1){
                            arr[1] = j+1;
                            break;
                        }
                    }

                }
                break;
            }
        }
        Arrays.sort(arr);
        return arr;
    }
}
