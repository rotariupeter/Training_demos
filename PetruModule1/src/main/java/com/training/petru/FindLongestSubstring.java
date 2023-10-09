package com.training.petru;

import java.util.HashSet;
import java.util.Set;

public class FindLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        StringBuilder longestString = new StringBuilder();
        String oldLongString = "";
        for (int i = 0; i < s.length(); i++) {

            if(longestString.indexOf(String.valueOf(s.charAt(i))) == -1){
                longestString.append(s.charAt(i));
            } else {
                if(oldLongString.length() < longestString.length()) {
                    oldLongString = longestString.toString();
                }
                i = s.substring(0,i).lastIndexOf(s.charAt(i))+1;
                longestString.setLength(0);
                longestString.append(s.charAt(i));
            }

        }

        return oldLongString.length() < longestString.length() ? longestString.length(): oldLongString.length();
    }

    public static int lengthOfLongestSubstring1(String s) {
            Set<Character>set=new HashSet<>();
            int maxLength=0;
            int left=0;
            for(int right=0;right<s.length();right++){

                if(!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    maxLength=Math.max(maxLength,right-left+1);

                }else{
                    while(s.charAt(left)!=s.charAt(right)){
                        set.remove(s.charAt(left));
                        left++;
                    }
                    set.remove(s.charAt(left));left++;
                    set.add(s.charAt(right));
                }

            }
            return maxLength;
        }

    public static void main(String[] args) {
        HashSet<String> s = new HashSet<>();

        s.add("aa");
        s.add("aaa");
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        s.add("e");
        s.add("f");
        s.add("g");
        s.add("h");
        s.add("i");
        s.add("o");
        s.add("p");
        s.add("r");


//        for (String ele : s) {
//            if(s.contains("a")) System.out.print("a");
//
//        }

        System.out.println(lengthOfLongestSubstring("sfrefabcdeaflmb"));



    }
}
