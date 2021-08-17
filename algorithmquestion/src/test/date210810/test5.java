package test.date210810;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            boolean can = false;
            String input = in.nextLine();
            char[] inPunt = new char[input.length()];
            for (int i = 0; i < input.length(); i++) {
                inPunt[i] = input.charAt(i);
            }
            if (can(inPunt)){
                System.out.println(0);
            }else {
                for (int i = 1; i <= inPunt.length; i++) {
                    char[] newInPut = new char[inPunt.length+i];
                    for (int j = 0; j < inPunt.length; j++) {
                        newInPut[j] = inPunt[j];
                    }
                    for (int j = 0; j < i; j++) {
                        newInPut[inPunt.length+j] = inPunt[i-j-1];
                    }
                    can = can(newInPut);
                    if (can){
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
    static boolean can(char[] inString){
        for (int i = 0; i < inString.length; i++) {
            if (inString[i] != inString[inString.length-i-1]){
                return false;
            }
        }
        return true;
    }
}
