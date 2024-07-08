package algorithms_and_data_structures.stringsandarrays;

import java.util.ArrayList;
import java.util.List;

/**
 * time and space both : O(n)
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> solution = new ArrayList<>();
        int start = 0;
        int n = words.length;

        while(start < n){
            //find the end index of the line;
            int end = findEnd(start, words, maxWidth);
            //justify left if words in a line are less than max or we are in the last line.
            if(end == start || end == n - 1){
                solution.add(justifyLeft(start, end, words, maxWidth));
            }else{
                //allocate spaces in a greedy way
                solution.add(justifyCenter(start, end, words, maxWidth));
            }
            //go to the next line
            start = end + 1;
        }



        return solution;
    }

    private String justifyCenter(int start, int end, String[] words, int maxWidth) {
        int width = 0;
        for(int i = start; i <= end; i++){
            width += words[i].length();
        }
        int numberOfSpaces = end - start;
        int totalSpace = maxWidth - width;
        int mininumSpace = totalSpace / numberOfSpaces;
        int remainingSpace = totalSpace % numberOfSpaces;
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);

        for(int i = start + 1; i <= end; i++ ){
            int space = mininumSpace + (remainingSpace-- > 0? 1: 0);
            while(space-- > 0){
                sb.append(" ");
            }
            sb.append(words[i]);
        }
       return sb.toString();
    }

    private String justifyLeft(int start, int end, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        for(int i = start + 1; i <= end; i++){
            sb.append(" ").append(words[i]);
        }
        int remainingSpace = maxWidth - sb.length();

        while(remainingSpace-- >0){
            sb.append(" ");
        }
        return sb.toString();
    }

    private int findEnd(int start, String[] words, int maxWidth) {
        int end = start + 1;
        int width = words[start].length();
        while(end < words.length && width + words[end].length() + (end - start) <= maxWidth){
            width += words[end].length();
            end++;
        }
        return end - 1;
    }

    public static void main(String[] args) {
        TextJustification solution = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> justifiedText = solution.fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println(line);
        }
    }
}
