import java.util.Arrays;
import java.util.HashSet;

public class LongestWord {
    public static String longestWord(String[] words){
        Arrays.sort(words);
        HashSet<String> builtWords = new HashSet<>();
        String result = "";
        for(String w: words){
            if(w.length() == 1 || builtWords.contains(w.substring(0,w.length() -1))){
                if(w.length() > result.length())
                    result = w;
                builtWords.add(w);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"to","toes", "toe"}));

    }
}
