public class CharMax {
    public static void charMax(String input){
        int count = 1;
        int max = 0;
        int startingIndex = 0;
        char maxChar = input.charAt(0);
        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i) == input.charAt(i -1)){
                count++;
            }
            else{
                if (count > max){
                    max = count;
                    maxChar = input.charAt(i - 1);
                    startingIndex = i - count;

                }
                count = 1;
            }
            if (count > max){
                max = count;
                maxChar = input.charAt(i - 1);
                startingIndex = i - count;

            }
        }
        System.out.println("count =" + max + ", char =" + maxChar + ", starting index =" + startingIndex);
    }

    public static void main(String[] args) {
        charMax("qweteeeeuuuuussaf");
    }
}
