package algorithms_and_data_structures.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.
 *
 * Implement the AllOne class:
 *
 * AllOne() Initializes the object of the data structure.
 * inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
 * dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
 * getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
 * getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
 * Note that each function must run in O(1) average time complexity.
 */
public class AllOne {
    public class Bucket{   //linked list to hold keys together with the same count;
        int count;
        Set<String> keys;
        Bucket next;
        Bucket prev;
        Bucket(int count){
         this.count = count;
         keys = new HashSet<>();
        }
    }
    Bucket left;
    Bucket right;
    Map<String, Bucket> keyToBucket;
    public AllOne(){
        left = new Bucket(Integer.MIN_VALUE);
        right = new Bucket(Integer.MAX_VALUE);
        keyToBucket = new HashMap<>();
        left.next = right;
        right.prev = left;

    }
    public void inc(String key) {
        if(!keyToBucket.containsKey(key)){
            Bucket nextBucket = getNextBucket(left,1);
            nextBucket.keys.add(key);
            keyToBucket.put(key, nextBucket);
        }else {
            Bucket currentBucket = keyToBucket.get(key);
            Bucket nextBucket = getNextBucket(currentBucket, currentBucket.count + 1);
            nextBucket.keys.add(key);
            keyToBucket.put(key, nextBucket);
            removeKeyFromBucket(currentBucket, key);
        }

    }



    public void dec(String key) {
        if(!keyToBucket.containsKey(key)){
            return;
        }
        Bucket currentBucket = keyToBucket.get(key);
        if(currentBucket.count == 1){
            keyToBucket.remove(key);
            removeKeyFromBucket(currentBucket, key);
        }else{
            Bucket newBucket = getPreviousBucket(currentBucket, currentBucket.count - 1);
            newBucket.keys.add(key);
            removeKeyFromBucket(currentBucket, key);
        }

    }



    public String getMaxKey() {
        return (right.prev == left)? "": right.prev.keys.iterator().next();

    }
    public String getMinKey() {
        return (left.next == right)? "": left.next.keys.iterator().next();
    }
    private Bucket getNextBucket(Bucket currentBucket, int count) {

        if(currentBucket.next.count == count){
            return currentBucket.next;
        }
        Bucket newBucket = new Bucket(count);
        addBucketAfter(newBucket, currentBucket);
        return newBucket;
    }

    private Bucket getPreviousBucket(Bucket currentBucket, int count) {
        if(currentBucket.prev.count == count){
            return currentBucket.prev;
        }
        Bucket newBucket = new Bucket(count);
        addBucketAfter(newBucket, currentBucket);
        return newBucket;
    }

    private void addBucketAfter(Bucket newBucket, Bucket currentBucket) {
        currentBucket.next.prev = newBucket;
        newBucket.next = currentBucket.next;
        newBucket.prev = currentBucket;
        currentBucket.next = newBucket;
    }
    private void removeKeyFromBucket(Bucket currentBucket, String key) {
        currentBucket.keys.remove(key);
        if(currentBucket.keys.isEmpty()){
            removeBucket(currentBucket);
        }
    }

    private void removeBucket(Bucket currentBucket) {
        currentBucket.prev.next = currentBucket.next;
        currentBucket.next.prev = currentBucket.prev;
    }

    public static void main(String[] args) {
        // Initialize AllOne data structure
        AllOne allOne = new AllOne();

        // Increment some keys
        allOne.inc("apple");
        allOne.inc("banana");
        allOne.inc("apple");
        allOne.inc("orange");
        allOne.inc("banana");
        allOne.inc("banana");

        // Test getMaxKey() and getMinKey()
        System.out.println("Max Key: " + allOne.getMaxKey()); // Expected: "banana"
        System.out.println("Min Key: " + allOne.getMinKey()); // Expected: "orange"

        // Decrement some keys
        allOne.dec("banana");
        allOne.dec("banana");

        // Test getMaxKey() and getMinKey() again
        System.out.println("Max Key: " + allOne.getMaxKey()); // Expected: "apple"
        System.out.println("Min Key: " + allOne.getMinKey()); // Expected: "banana" or "orange"

        // Further decrement to remove "banana"
        allOne.dec("banana");

        // Test getMaxKey() and getMinKey() after removing "banana"
        System.out.println("Max Key: " + allOne.getMaxKey()); // Expected: "apple"
        System.out.println("Min Key: " + allOne.getMinKey()); // Expected: "orange"

        // Test edge cases with empty structure
        allOne.dec("orange");
        allOne.dec("orange");
        allOne.dec("apple");
        allOne.dec("apple");

        System.out.println("Max Key: " + allOne.getMaxKey()); // Expected: ""
        System.out.println("Min Key: " + allOne.getMinKey()); // Expected: ""
    }

}
