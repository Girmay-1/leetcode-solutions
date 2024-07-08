import java.util.HashSet;

public class PangramCheck {
    public static boolean isPangram(String str){
        str = str.toLowerCase().replaceAll(" ","");
        char[] chars = str.toCharArray();
        HashSet<Character> charset = new HashSet<>();
        for(char c: chars)
            charset.add(c);
        return charset.size() == 26;
    }
}
