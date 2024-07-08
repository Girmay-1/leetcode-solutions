public class RemoveConsecutiveChar {
    public static String removeRepeatingChar(String string){
        if(string.length() <= 1)
            return string;
        else if (string.charAt(0) == string.charAt(1)){
            return removeRepeatingChar(string.substring(1));
        }
        else
            return  string.charAt(0) + removeRepeatingChar(string.substring(1));

    }

    public static void main(String[] args) {
        System.out.println(removeRepeatingChar("aaaabbbccceefghhhh"));
    }
}
