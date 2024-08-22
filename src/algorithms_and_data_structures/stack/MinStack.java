package algorithms_and_data_structures.stack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> miniStack;
    public MinStack() {
        stack = new Stack<>();
        miniStack = new Stack<>();

    }
    public void push(int val) {
        stack.push(val);
        if(miniStack.isEmpty() || miniStack.peek() >= val){
            miniStack.push(val);
        }
    }
    public void pop() {
        int val = stack.pop();
        if(!miniStack.isEmpty() && miniStack.peek() == val){
            miniStack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return miniStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Test pushing elements onto the stack
        minStack.push(3);
        minStack.push(5);
        System.out.println("Current top: " + minStack.top()); // Should return 5
        System.out.println("Current min: " + minStack.getMin()); // Should return 3

        minStack.push(2);
        minStack.push(1);
        System.out.println("Current top: " + minStack.top()); // Should return 1
        System.out.println("Current min: " + minStack.getMin()); // Should return 1

        // Test popping elements from the stack
        minStack.pop();
        System.out.println("Current top after pop: " + minStack.top()); // Should return 2
        System.out.println("Current min after pop: " + minStack.getMin()); // Should return 2

        minStack.pop();
        System.out.println("Current top after pop: " + minStack.top()); // Should return 5
        System.out.println("Current min after pop: " + minStack.getMin()); // Should return 3

        // Continue testing with more operations
        minStack.push(0);
        System.out.println("Current top: " + minStack.top()); // Should return 0
        System.out.println("Current min: " + minStack.getMin()); // Should return 0

        minStack.pop();
        System.out.println("Current top after pop: " + minStack.top()); // Should return 5
        System.out.println("Current min after pop: " + minStack.getMin()); // Should return 3
    }


}
