package algorithms_and_data_structures;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public class Solution{
        //iterative way
        public ListNode reverseList(ListNode head) {
            ListNode current = head;
            ListNode prev = null;

            while(current != null){
                ListNode temp = current.next;
                current.next = prev;
                current = temp;
                prev = current;
            }
            return prev;
        }

        //recusive way

        public ListNode reveseListRec(ListNode head){
            if(head == null || head.next == null){ //if head is null or has only one node, we return that node.
                return head;
            }
            ListNode newHead = reveseListRec(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }


}
