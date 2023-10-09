package com.training.petru;

import java.util.Random;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();
        int n = num1Len > num2Len ? num1Len : num2Len;
        if(num1Len > num2Len){
            num2 = new StringBuilder().insert(0,"0".repeat(num1Len-num2Len)).toString() + num2;
        }
        else if(num1Len < num2Len){
            num1 = new StringBuilder().insert(0,"0".repeat(num2Len-num1Len)).toString() + num1;
        }


        StringBuilder sum = new StringBuilder();
        sum.insert(0,"");
        int noToAdd = 0;
        for(int i = n-1; i >= 0; i--) {

            boolean addOne = false;
            int brutSum = Integer.valueOf(String.valueOf(num1.charAt(i)))+Integer.valueOf(String.valueOf(num2.charAt(i))) + noToAdd;
            if(i==0){
                sum.insert(0,""+ brutSum);
            } else {


                if(brutSum < 10) {
                    sum.insert(0, "" + brutSum);
                } else {
                    sum.insert(0,""+((Integer.valueOf(String.valueOf(num1.charAt(i)))+Integer.valueOf(String.valueOf(num2.charAt(i))) + noToAdd)%10));
                    addOne = true;
                }
                noToAdd = addOne ? 1:0;

            }
        }

       return sum.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("9678","3456"));
    }
}
