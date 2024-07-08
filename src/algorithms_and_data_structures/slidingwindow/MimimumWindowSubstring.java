package algorithms_and_data_structures.slidingwindow;

import java.util.*;

/**
 *Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */
public class MimimumWindowSubstring {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int m = s.length();
        int n = t.length();
        int startIndex = 0;
        int windowLen = 0;
        Map<Character, Integer> targetMap = new HashMap<>();
        for(Character c: t.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c,0) + 1);
        }
        int targetLength = targetMap.size();

        int left = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        for(int right = 0; right < m; right++){
            Character rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar,0) + 1);

            if(targetMap.containsKey(rightChar) && targetMap.get(rightChar).equals(windowMap.get(rightChar))){
                windowLen++;
            }
            //move left pointer and also calculate the minLen and starting point.
            while (left <= right && windowLen == targetLength){
                minLen = Math.min(minLen, right - left + 1);

                startIndex = left;

                Character leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if(targetMap.containsKey(leftChar) && targetMap.get(leftChar) > windowMap.get(leftChar)){
                    windowLen--;
                }
                left++;
            }


        }
         return minLen == Integer.MAX_VALUE? "": s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        MimimumWindowSubstring solution = new MimimumWindowSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        String so = solution.minWindow(s,t);
        System.out.println(so);
    }

}
