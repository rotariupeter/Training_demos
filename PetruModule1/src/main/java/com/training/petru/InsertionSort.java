package com.training.petru;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {

    private static int[] insertionSort(int[] array) {

        if (array == null || array.length < 2){
            return array;
    }
        int length = array.length;

        for (int i = 1; i< length;i++){
            int j = i-1;
            int key = array[i];
            while((j > -1) && (key < array[j])){
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = key;
        }
    return array;
    }
    public static void main(String[] args) {
        int array[] = {2,8,5,3,9,4};


        Arrays.stream(insertionSort(array)).forEach(System.out::print);
    }
}
