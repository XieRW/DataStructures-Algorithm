package test.date210823;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**求岛屿的个数
 详细描述
 用一个二维的数组来表示一块地图的构成，其中 1 表示陆地，0 表示水域。若定义“岛”为被水包围且由所有水平和竖直方向上相邻的陆地连接而成，求岛的个数。假设地图的四周都被水域围绕。

 其他
 时间限制: 1000ms

 内存限制: 256.0MB

 输入输出示例
 示例1
 输入
 复制
 [[0,0,0],[0,0,0],[0,0,0]]
 输出
 复制
 0
 示例2
 输入
 复制
 [[1,1,1,1,0],[1,1,0,1,0],[1,1,0,0,0],[0,0,0,0,0]]
 输出
 复制
 1
 示例3
 输入
 复制
 [[1,1,0,0,0],[1,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]
 输出
 复制
 3
 */
public class Main2 {

    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(numberOfIslands(arr));
    }
    static int numberOfIslands(int[][] grid) {
        // write code here
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                temp.add(grid[i][j]);
            }
            list.add(temp);
        }
        for(int i=0;i<list.size();i++){
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == 1){
                    remove(list,i,j);
                    sum++;
                }
            }
        }
        return sum;
    }
    static void remove(List<List<Integer>> list,int i,int j){
        list.get(i).set(j,0);
        if (i-1>=0 && list.get(i-1).size()>j && list.get(i-1).get(j) == 1){
            remove(list,i-1,j);
        }
        if (i+1<list.size() && list.get(i+1).size()>j && list.get(i+1).get(j) == 1){
            remove(list,i+1,j);
        }
        if (j-1>=0 && list.get(i).get(j-1) == 1){
            remove(list,i,j-1);
        }
        if (j+1<list.get(i).size() && list.get(i).get(j+1) == 1){
            remove(list,i,j+1);
        }
    }
}
