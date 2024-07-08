package algorithms_and_data_structures.linkedlist;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = dummy.next;
        ListNode currentPrev = dummy;

        //run two pointers until the age of the window.
        for (int i = 0; i < left - 1; i++) {
            current = current.next;
            currentPrev = currentPrev.next;
        }

        //do the reversal for the window.
        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++){ ;
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        //now at this point current points to the first element outside the window and prev points to the last element in the window
        currentPrev.next.next = current;
        currentPrev.next = prev;

        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII sol = new ReverseLinkedListII();
        ReverseLinkedListII.ListNode head = new ReverseLinkedListII().new  ListNode(1);
        head.next = new ReverseLinkedListII().new ListNode(2);
        head.next.next = new ReverseLinkedListII().new ListNode(3);
        head.next.next.next = new ReverseLinkedListII().new ListNode(4);
        head.next.next.next.next = new ReverseLinkedListII().new ListNode(5);

        ReverseLinkedListII.ListNode solution = sol.reverseBetween(head, 2, 4);
        printLinkedList(solution);

    }
    public static void printLinkedList(ReverseLinkedListII.ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
