package algorithms_and_data_structures.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 *
 * A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 */
public class SubStringWithConcatentation {
        public List<Integer> findSubstring(String s, String[] words) {
            int wordLen = words[0].length();
            int len = words.length;
            int window = wordLen * len;
            List<Integer> sol = new ArrayList<>();
            Map<String, Integer> expectedMap = new HashMap<>();

            for (String word : words) {
                expectedMap.put(word, expectedMap.getOrDefault(word, 0) + 1);
            }

            for (int left = 0; left <= s.length() - window; left++) {
                int right = 0;
                Map<String, Integer> seenMap = new HashMap<>();
                while (right < len) {
                    int startIndex = left + right * wordLen;
                    int endIndex = startIndex + wordLen;
                    String word = s.substring(startIndex, endIndex);

                    if (!expectedMap.containsKey(word) || seenMap.getOrDefault(word, 0) >= expectedMap.get(word)) {
                        break;
                    } else {
                        seenMap.put(word, seenMap.getOrDefault(word, 0) + 1);
                    }

                    right++;
                }
                if (right == len) {
                    sol.add(left);
                }

            }

            return sol;
        }
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        SubStringWithConcatentation subStringWithConcatentation = new SubStringWithConcatentation();
        List<Integer> solution = subStringWithConcatentation.findSubstring(s,words);
        System.out.print("[");
        for(Integer index: solution){
            System.out.print(" " + index);
        }
        System.out.print("]");
    }


}