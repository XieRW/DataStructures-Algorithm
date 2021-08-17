package test.date21810;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 10
 94 R
 74 L
 90 L
 75 R
 37 R
 99 R
 62 R
 4 L
 92 L
 44 R
 */
public class test6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> xList = new ArrayList<>();
        List<String> mList = new ArrayList<>();
        List<Integer> bom = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            String move = in.next();
            xList.add(x);
            mList.add(move);
            bom.add(-1);
        }
        boolean temp = true;
        while (mList.contains("L")&&mList.contains("R")&&temp){
            int minR=0;
            int maxL=0;
            for (int i = 0; i < xList.size(); i++) {
                if (mList.get(i).equals("L")){
                        maxL = xList.get(i);
                        break;
                }
            }
            for (int i = 0; i < xList.size(); i++) {
                if (mList.get(i).equals("L")){
                    maxL = xList.get(i);
                    break;
                }
            }
            for (int i = 0; i < xList.size(); i++) {
                if (mList.get(i).equals("L")){
                    if (xList.get(i)>maxL){
                        maxL = xList.get(i);
                    }
                    xList.set(i,xList.get(i)-1);
                }
                if (mList.get(i).equals("R")){
                    if (xList.get(i)<minR){
                        minR = xList.get(i);
                    }
                    xList.set(i,xList.get(i)+1);
                }

                if (minR > maxL){
                    temp = false;
                    break;
                }
                get(xList,mList,bom,0);
            }
        }
        for (int i = 0; i < bom.size(); i++) {
            System.out.println(bom.get(i));
        }
    }
    static void get(List<Integer> xList,List mList,List<Integer> bom,int i){
        for (int j = 0; j < xList.size(); j++) {
            for (int k = j+1; k < xList.size(); k++) {
                if (xList.get(j).equals(xList.get(k))){
                    bom.set(j,xList.get(j));
                    bom.set(j,xList.get(k));
                    xList.remove(j);
                    xList.remove(k-1);
                    mList.remove(j);
                    mList.remove(k-1);
                    i +=1;
                    get(xList,mList,bom,i);
                    return;
                }
            }
        }
    }
}
