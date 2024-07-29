package algorithms_and_data_structures.stringsandarrays;

import java.util.*;

/**
 * Given a string s, find two disjoint palindromic subsequences of s such that the product of their lengths is maximized.
 * The two subsequences are disjoint if they do not both pick a character at the same index.
 *
 * Return the maximum possible product of the lengths of the two palindromic subsequences.
 *
 * A subsequence is a string that can be derived from another string by deleting some or no
 * characters without changing the order of the remaining characters. A string is palindromic if it reads the same forward and backward.
 */
public class MaxProduct {
    public int maxProduct(String s) {
//        1. Generate all the subsequences in the string s
        int n = s.length();
        Map<Integer, Integer> maskStringLenMap = new HashMap<>();

        for(int i = 1; i < (1 << n); i++){ //we start from one because we want to ignore empty string
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    sb.append(s.charAt(j));
                }
            }
            String subsequence = sb.toString();
            if(checkPalindrome(subsequence)){
                maskStringLenMap.put(i,subsequence.length());
            }

        }

        //2. Compare all pairs of palindromic subsequences and calculate the maxProduct of their lengths
        int product = 0;
        List<Integer> maskList = new ArrayList<>(maskStringLenMap.keySet());
        int size = maskList.size();
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if((maskList.get(i) & maskList.get(j)) == 0){
                    product = Math.max(product, maskStringLenMap.get(maskList.get(i)) * maskStringLenMap.get(maskList.get(j)));
                }
            }
        }
        return product;
    }





    private boolean checkPalindrome(String subsequence) {
        int left = 0;
        int right = subsequence.length() - 1;
        while(left < right){
            if(subsequence.charAt(left) != subsequence.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();


        String s1 = "abac";
        int result1 = maxProduct.maxProduct(s1);
        System.out.println("Test case 1: " + result1); // Expected output: 3

        // Test case 2
        String s2 = "leetcodecom";
        int result2 = maxProduct.maxProduct(s2);
        System.out.println("Test case 2: " + result2); // Expected output: 9

        // Test case 3
        String s3 = "bb";
        int result3 = maxProduct.maxProduct(s3);
        System.out.println("Test case 3: " + result3); // Expected output: 1

        // Test case 4
        String s4 = "accbcaxxcxx";
        int result4 = maxProduct.maxProduct(s4);
        System.out.println("Test case 4: " + result4); // Expected output: 25
    }
}
