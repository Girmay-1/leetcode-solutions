package algorithms_and_data_structures.subsringconcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result; // Early exit if insufficient characters in s
        }

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        int[] expectedFreq = new int[wordCount];
        for (int i = 0; i < wordCount; i++) {
            expectedFreq[i] = wordFreq.get(words[i]);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int remainingLen = s.length() - i;

            while (remainingLen >= totalLen) {
                String word = s.substring(right, right + wordLen);
                remainingLen -= wordLen;

                if (wordFreq.containsKey(word)) {
                    expectedFreq[wordFreq.get(word)]--; // Decrease expected frequency
                    right += wordLen;

                    if (remainingLen < totalLen) {
                        break; // Early exit if insufficient characters for valid concatenation
                    }

                    if (right - left == totalLen) {
                        result.add(left);
                        expectedFreq[wordFreq.get(s.substring(left, left + wordLen))]++; // Restore expected frequency
                        left += wordLen;
                    }
                } else {
                    expectedFreq = new int[wordCount]; // Reset expected frequency
                    right += wordLen;
                    left = right;
                }
            }
        }

        return result;
    }

}
