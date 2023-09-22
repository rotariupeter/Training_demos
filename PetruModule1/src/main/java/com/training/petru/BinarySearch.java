package com.training.petru;

import java.util.Collections;

public class BinarySearch {

    private static int[] list = {2,4,11,3,44,55,75,1,10,21,54};

    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }

    public static int binarySearch(int array[],int value){

        int s = 0;
        int e = array.length-1;

        while(s < e){

            int mid = (s + e)/2;

            if(array[mid] == value){
                return mid;
            } else if(array[mid] > value){
                e = mid;
            } else if(array[mid] < value){
                s = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        insertionSort(list);
        System.out.println(binarySearch(list,0));


    }
}
