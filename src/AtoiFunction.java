public class AtoiFunction {
    public static int atoiFunction(String string){
        int result = 0;
        int sign = string.charAt(0) == '-'? -1: 1;
        string = string.replaceAll("[^\\d]","");
        for(char c : string.toCharArray()){
            result = result * 10 + c - '0';
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(atoiFunction("-ertw&24^*3452"));
    }
}
