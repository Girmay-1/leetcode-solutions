package algorithms_and_data_structures.slidingwindow;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 */
public class LongestCharacterRepeatingReplacement {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxFreq = 0; //this will be updated only if we find maxFreq more than the current one. This is important.
        int[] count = new int[26];
        int left = 0;
        int right = 0;

        while(right < s.length()){
            maxFreq = Math.max(maxFreq, ++count[s.charAt(right) - 'A']);
            //shrink the window if chars that need replacement are more than k.
            if(right - left + 1 - maxFreq > k){
                count[s.charAt(left)]--; //important. Do not shrink before decrementing the leftTH character.
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
    /**
     * time: O(n) since we are just iterating through the chars it the string once.
     * space: O(1). We have O(26) for the count array which is a constant space complexity.
     */
    public static void main(String[] args) {
        LongestCharacterRepeatingReplacement solution = new LongestCharacterRepeatingReplacement();
        String s = "ABAB";
        int k = 2;
        System.out.println(solution.characterReplacement(s, k)); // Output: 4
    }
}
