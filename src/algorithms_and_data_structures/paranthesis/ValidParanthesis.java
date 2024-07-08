package algorithms_and_data_structures.paranthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 */
public class ValidParanthesis {

    /**
     * this is going to be solved using a stack. Here is the logic.
     *
     * If character is closing and stack is not empty, we check the top of stack if it is the opening of the corresponding closing.
     * we return false if not.
     *
     * if the top of the stack has the opening, we pop.
     *
     * If character is any other than closing or if stack is empty, we push to the stack.
     *
     * we return true if the stack is empty or false if not.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(char c : s.toCharArray()){
            if(map.containsKey(c) && !stack.isEmpty()){
                if(stack.peek() != map.get(c)){
                    return false;
                }else {
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParanthesis solution = new ValidParanthesis();
        // Test cases
        String[] testCases = {
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}"
        };

        for (String testCase : testCases) {
            System.out.println("Is \"" + testCase + "\" valid? " + solution.isValid(testCase));
        }
    }
}
