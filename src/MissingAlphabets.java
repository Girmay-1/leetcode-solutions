import java.util.HashSet;

public class MissingAlphabets {
    public static HashSet<Character> missingAlphabets(String str){
        String alphabets= "abcdefghijklmnopqrstuvwxyz";
        str = str.toLowerCase().replaceAll(" ","");
        char[] chars = str.toCharArray();
        HashSet<Character> charset = new HashSet<>();
        for(char c: chars)
            charset.add(c);
        HashSet<Character> alphabetsSet = new HashSet<>();
        for(char alp: alphabets.toCharArray())
            alphabetsSet.add(alp);
        alphabetsSet.removeAll(charset);
        return alphabetsSet;
    }
}
