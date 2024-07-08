package algorithms_and_data_structures.linkedlist;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseInKGroups {
    public class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }}

        public ListNode reverseKGroup(ListNode head, int k){
            ListNode dummy = new ListNode();
            ListNode groupPrev = dummy;
            dummy.next = head;

            while(true){
                //find kth node.
                ListNode kThNode = findKthNode(groupPrev, k);

                if(kThNode == null){
                    break;
                }

                //define some variables;
                ListNode nextGroupStart = kThNode.next;
                ListNode prev = kThNode.next;
                ListNode current = groupPrev.next;

                //reverse the nodes;

                while(current != nextGroupStart){
                    ListNode temp = current.next;
                    current.next = prev;
                    prev = current;
                    current = temp;
                }

                //move to the next group;
                // 1. groupPrev should point to the kth node now. And
                //2. the node that was the first in the current group(groupPrev.next) now becomes groupPrev node of the following group.
                ListNode temp = groupPrev.next;
                groupPrev.next = kThNode;
                groupPrev = temp;
            }


            return dummy.next;
        }

    private ListNode findKthNode(ListNode node, int k) {
        while(node != null && k-- > 0){
            node = node.next;

        }
        return node;
    }


    public static void main(String[] args) {
        ReverseInKGroups obj = new ReverseInKGroups();

        int k1 = 3;
        int k2 = 3;
        int countWhile = 0;
        int countFor = 0;

        while( k1 >= 0){
            countWhile++;
            k1--;
        }

        for(int i = 0; i < k2; i++){
            countFor++;

        }
        System.out.println("countwhile:" + countWhile);
        System.out.println("countfor:" + countFor);

        // Create a sample linked list for testing
        ReverseInKGroups.ListNode head = new ReverseInKGroups().new  ListNode(1);
        head.next = new ReverseInKGroups().new ListNode(2);
        head.next.next = new ReverseInKGroups().new ListNode(3);
        head.next.next.next = new ReverseInKGroups().new ListNode(4);
        head.next.next.next.next = new ReverseInKGroups().new ListNode(5);

        ListNode solution = obj.reverseKGroup(head, 2);
        printLinkedList(solution);

    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
