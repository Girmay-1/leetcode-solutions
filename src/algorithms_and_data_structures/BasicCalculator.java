package algorithms_and_data_structures;

import java.util.Stack;

/**
 * we are
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if((Character.isDigit(ch))){
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    val += val * 10 + (s.charAt(i) - '0');
                    i++;
                }

                sum += val * sign;
                sign = 1;
                i--;
            }
            else if(ch == '('){
                stack.push(sum);
                stack.push(sign);
                sign = 1;
                sum = 0;
            }
            else if(ch == ')'){
                sum *= stack.pop();
                sum += stack.pop();
            }
            else if (ch == '-'){
                sign = -1;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        String s  = "(1+(4+5+2)-3)+(6+8)";
        BasicCalculator bc = new BasicCalculator();
        System.out.println("sum:" +bc.calculate(s));
    }

}
