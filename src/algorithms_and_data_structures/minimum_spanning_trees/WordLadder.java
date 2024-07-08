package algorithms_and_data_structures.minimum_spanning_trees;

import java.util.*;

/**
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         //In Java, a set has a constant time complexity (O(1)) for the contains() operation,
        //whereas a list has a linear time complexity (O(n)) for the same operation. check it without converting, and you will see that the time limit exceeds.
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int ladder = 1;

        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return ladder;
                }
                for (String nexWord : getWords(word, wordSet)) {
                    if (!visited.contains(nexWord)) {
                        visited.add(nexWord);
                        queue.offer(nexWord);
                    }
                }
            }
            ladder++;
        }
        return 0;
    }

    private List<String> getWords(String word, Set<String> wordList) {
        List<String> words = new ArrayList<>();
        for(int i = 0 ; i< word.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                char[] charArray = word.toCharArray();
                if (c == charArray[i]){
                        continue;
                }
                charArray[i] = c;
                String newWord = new String(charArray);
                if(wordList.contains(newWord )){
                    words.add(newWord);
                }
            }


        }
        return words;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";

        System.out.println(solution.ladderLength(beginWord,endWord,wordList));
    }

    //time: O( 26 * L * m)
    //space: O(m) [ m is size of wordList, L is length of word.
}
