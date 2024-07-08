package algorithms_and_data_structures.slidingwindow;
/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSubstring {
            public String minWindow(String s, String t) {
                //edge cases
                int m = s.length();
                int n = t.length();

                if( m < n || m < 1 || n > 100000){
                    return "";
                }
                //initialize map & count, left, right
                Map<Character, Integer> countMap = new HashMap<>();
                for(char c : t.toCharArray()){
                    countMap.put(c,countMap.getOrDefault(c,0) + 1);
                }
                //increment count if in map and value > 0
                int count = 0;
                int minLength = Integer.MAX_VALUE;
                int left = 0;
                int[] ans = new int[2];

                for(int right = 0; right < m; right++){
                    if(countMap.containsKey(s.charAt(right))){
                        if(countMap.get(s.charAt(right)) > 0){
                            count++;
                        }
                        countMap.put(s.charAt(right), countMap.get(s.charAt(right)) - 1);

                    }
                    //move left to right to get minimum window len and dec
                    // incremnet map if char present and decrement count
                    // move left to right if char not present

                    if(count == n){
                        while( left < right && (!countMap.containsKey(s.charAt(left)) || countMap.get(s.charAt(left)) < 0)){
                            if(countMap.containsKey(s.charAt(left))){
                                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) + 1);
                            }
                            left++;
                        }

                        if(minLength > right - left + 1){
                            ans[0] = left;
                            ans[1] = right;
                            minLength = right - left + 1;
                        }

                        if(countMap.containsKey(s.charAt(left))){
                            countMap.put(s.charAt(left), countMap.get(s.charAt(left)) + 1);
                        }

                        count--;
                        left++;

                    }

                }


                System.out.println(Arrays.toString(ans));

                return minLength == Integer.MAX_VALUE? "" : s.substring(ans[0], ans[0] + minLength);

            }


    private static String readLongStringFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args){


        MinimumSubstring minimumSubstring = new MinimumSubstring();
        String sFilePath = "/Users/girmay/Documents/PracticeJava/interview/src/algorithms/slidingwindow/s.txt";
        String tFilePath = "/Users/girmay/Documents/PracticeJava/interview/src/algorithms/slidingwindow/t.txt";
        String s= "ADOBECODEBANC";
        String t = "ABC";
        String sol = minimumSubstring.minWindow(s,t);
        System.out.println(sol);
    }
}
