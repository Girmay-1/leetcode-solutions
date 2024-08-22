package algorithms_and_data_structures.stack;

import java.util.PriorityQueue;

/**
 * Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
 *
 * Implement the MaxStack class:
 *
 * MaxStack() Initializes the stack object.
 * void push(int x) Pushes element x onto the stack.
 * int pop() Removes the element on top of the stack and returns it.
 * int top() Gets the element on the top of the stack without removing it.
 * int peekMax() Retrieves the maximum element in the stack without removing it.
 * int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
 * You must come up with a solution that supports O(1) for each top call and O(logn) for each other call.
 */
public class MaxStack {
    class ListNode{
        ListNode next;
        ListNode prev;
        int val;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
    }

    ListNode right;
    ListNode left;
    PriorityQueue<ListNode> maxHeap;
    public MaxStack() {
        right = new ListNode();
        left = new ListNode();
        left.next = right;
        right.prev = left;
       maxHeap = new PriorityQueue<>((a,b) -> (a.val == b.val)? -1 : b.val - a.val);

    }
    public void push(int x) {
        ListNode newNode = new ListNode(x);
        pushToList(newNode);
        maxHeap.add(newNode);

    }

    public int pop() {
        ListNode top = left.next;
        maxHeap.remove(top);
        removeFromList(top);
        return top.val;

    }


    public int top() {
        return left.next.val;
    }
    public int peekMax() {
        return maxHeap.peek().val;
    }
    public int popMax() {
        ListNode maxNode = maxHeap.poll();
        removeFromList(maxNode);
        return maxNode.val;
    }
    private void pushToList(ListNode newNode) {
        left.next.prev = newNode;
        newNode.prev = left;
        newNode.next = left.next;
        left.next = newNode;
    }
    private void removeFromList(ListNode node) {
       node.prev.next = node.next;
       node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();

        // Test pushing elements onto the stack
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        System.out.println("Current top: " + maxStack.top()); // Should return 5

        // Test popMax
        System.out.println("Pop max: " + maxStack.popMax()); // Should return 5 (the most recent max)
        System.out.println("Current top after popMax: " + maxStack.top()); // Should return 1

        // Test peekMax
        System.out.println("Peek max: " + maxStack.peekMax()); // Should return 5 (the remaining max)

        // Test pop
        System.out.println("Pop top: " + maxStack.pop()); // Should return 1
        System.out.println("Current top after pop: " + maxStack.top()); // Should return 5

        // Test push again
        maxStack.push(10);
        System.out.println("Current top: " + maxStack.top()); // Should return 10
        System.out.println("Peek max: " + maxStack.peekMax()); // Should return 10
        System.out.println("Pop max: " + maxStack.popMax()); // Should return 10
        System.out.println("Peek max after popMax: " + maxStack.peekMax()); // Should return 5
    }

}
