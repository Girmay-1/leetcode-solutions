package algorithms_and_data_structures;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class ListNode{
        ListNode prev;
        ListNode next;
        int val;
        int key;
        ListNode(){}
        ListNode(ListNode prev, ListNode next, int val){
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
        ListNode(int key, int val){
            this.val = val;
            this.key = key;
        }

    }
    Map<Integer, ListNode> cache = new HashMap<>();
    int c;

    ListNode left;
    ListNode right;


    public LRUCache(int capacity) {
        c = capacity;

        left = new ListNode(0,0);
        right = new ListNode(0,0);
        left.next = right;
        right.prev = left;


    }

    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        ListNode newNode = new ListNode(key,value);
        cache.put(key, newNode);
        System.out.println(newNode.key);
        insert(cache.get(key));
        System.out.println("key:" + key + "," + "value:" + cache.get(key).val);

        if(cache.size() > c){
            ListNode lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    //insert node at right
    public void insert(ListNode node){
        right.prev.next = node;
        node.prev = right.prev;
        node.next = right;
        right.prev = node;

    }
    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        // Create an LRUCache object with capacity 1
        LRUCache lruCache = new LRUCache(1);

        // Perform put operation: Insert key-value pair (2, 1) into the cache
        lruCache.put(2, 1);

        // Perform get operation: Get the value associated with key 2 from the cache
        int value = lruCache.get(2);

        // Print the output
        System.out.println("Output: " + value); // Expected output: 1
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
