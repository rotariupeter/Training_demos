package com.training.petru;

import java.util.HashSet;
import java.util.Map;

public class FindDuplicateNo {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {

        final HashSet<Integer> noCollection = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if(noCollection.contains(nums[i])) {
                return nums[i];
            }
            noCollection.add(nums[i]);
        }

        return -1;
    }
}
