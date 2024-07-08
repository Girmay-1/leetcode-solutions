package algorithms_and_data_structures;

/**
 * we are using merge- sort to sort linked lists in
 */
public class SortingLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }
    public ListNode mergeSort(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }else if(start + 1 == end){
           return  merge(lists[start], lists[end]);
        } else{
            int mid = (start + end) / 2;
            ListNode left = mergeSort(lists, start, mid);
            ListNode right = mergeSort(lists, mid + 1, end);
            return merge(left, right);
        }
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = (left != null) ? left: right;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        // Create an array of ListNode arrays
        ListNode[] lists = new ListNode[]{list1, list2, list3};

        // Create an instance of the Solution class
        SortingLinkedLists sortingLinkedLists = new SortingLinkedLists();

        // Call the mergeKLists method and store the result
        ListNode mergedList = sortingLinkedLists.mergeKLists(lists);

        // Print the merged list
        printList(mergedList); // Expected output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
