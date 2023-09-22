package com.training.petru;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SingleNo {
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> num = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = num.get(nums[i]) != null ? num.get(nums[i]): 0 ;
            num.put(nums[i], integer +1);
        }
        for (Map.Entry<Integer,Integer> entry:num.entrySet()){
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }

}
