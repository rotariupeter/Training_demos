package com.training.petru;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();
        if(Integer.valueOf(num2) == 0 || Integer.valueOf(num1) == 0)
            return "0";

        int[][] sum = new int[num1Len + num2Len][(num1Len > num2Len)? num1Len : num2Len];
        System.out.println(sum.toString());
        for(int i = num1Len-1; i>=0;i--) {
            for (int j = num2Len - 2; j >= 0; j--) {

            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
