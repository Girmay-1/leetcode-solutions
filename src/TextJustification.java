import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineStart = index;
            int lineEnd = lineStart;
            int lineLength = 0;

            // Build a line with as many words as possible
            while (lineEnd < words.length && lineLength + words[lineEnd].length() <= maxWidth) {
                lineLength += words[lineEnd].length() + 1;
                lineEnd++;
            }

            int extraSpaces = maxWidth - lineLength + 1;
            int wordsInLine = lineEnd - lineStart;

            StringBuilder line = new StringBuilder(words[lineStart]);

            if (lineEnd == words.length || wordsInLine == 1) {
                // Left justify for the last line or if only one word in the line
                for (int i = lineStart + 1; i < lineEnd; i++) {
                    line.append(" ").append(words[i]);
                }
                appendSpaces(line, maxWidth - line.length());
            } else {
                // Distribute spaces evenly for other lines
                int spacesBetweenWords = extraSpaces / (wordsInLine - 1);
                int extraSpacesRemaining = extraSpaces % (wordsInLine - 1);

                for (int i = lineStart + 1; i < lineEnd; i++) {
                    int spacesToAdd = spacesBetweenWords + (extraSpacesRemaining-- > 0 ? 1 : 0);
                    appendSpaces(line, spacesToAdd);
                    line.append(words[i]);
                }
            }

            result.add(line.toString());
            index = lineEnd;
        }

        return result;
    }

    private void appendSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> justifiedText = textJustification.fullJustify(words, maxWidth);

        for (String line : justifiedText) {
            System.out.println(line);
        }
    }
}
