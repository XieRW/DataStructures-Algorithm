package test.date210826;

/**
 * @program: DataStructures-Algorithm
 * @description: main1
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-26 19:02
 **/
public class Main1 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}};
        int[] marr= matrixChange(arr);
        for (int i = 0; i < marr.length; i++) {
            System.out.println(marr[i]);
        }
    }
    public static int[] matrixChange (int[][] matrix) {
        // write code here
        int [] arr = new int[matrix.length*matrix[0].length];
        int x = matrix[0].length,y=matrix.length-1,tempX=0,tempY=0;
        int xx = matrix[0].length,yy=matrix.length-1;
        int target = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i==0){
                arr[0] = matrix[0][0];
                x--;
                tempX++;
                continue;
            }
            if (target == 0){
                if (x>0){
                    arr[i] = matrix[tempY][tempX];
                    tempX++;
                    x--;
                    continue;
                }else {
                    target = 1;
                    tempX--;
                    tempY++;
                    i--;
                    xx--;
                    x = xx;
                    continue;
                }

            }
            if (target == 1){
                if (y>0){
                    arr[i] = matrix[tempY][tempX];
                    tempY++;
                    y--;
                    continue;
                }else {
                    target = 2;
                    tempY--;
                    tempX--;
                    i--;
                    yy--;
                    y = yy;
                    continue;
                }
            }
            if (target == 2){
                if (x>0){
                    arr[i] = matrix[tempY][tempX];
                    tempX--;
                    x--;
                    continue;
                }else {
                    target = 3;
                    tempX++;
                    tempY--;
                    i--;
                    xx--;
                    x = xx;
                    continue;
                }
            }
            if (target == 3){
                if (y>0){
                    arr[i] = matrix[tempY][tempX];
                    tempY--;
                    y--;
                    continue;
                }else {
                    target = 0;
                    tempY++;
                    tempX++;
                    i--;
                    yy--;
                    y = yy;
                    continue;
                }
            }
        }
        return arr;
    }

}
