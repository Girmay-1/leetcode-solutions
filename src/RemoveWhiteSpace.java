public class RemoveWhiteSpace {
    public static String removeWhiteSpace(String  str){
        StringBuilder newStr = new StringBuilder();
        for(char c: str.toCharArray()){
            if(!Character.isWhitespace(c))
                newStr.append(c);
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeWhiteSpace("hey man"));
    }
}
