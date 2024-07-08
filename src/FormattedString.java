public class FormattedString {
    public static String formattingString(String a) {
        String outputString = "";
        int count = 1;
        for (int i = 0; i < a.length(); i++) {
            count = 1;
            while (i < a.length() - 1 && a.charAt(i) == a.charAt(i + 1)) {
                count++;
                i++;
            }
            outputString = outputString + a.charAt(i) + count;
        }
        return outputString;
    }
}
