package algorithms_and_data_structures.design;

import java.util.Map;
import java.util.TreeMap;

/**
 * given an empty set of intervals, implement a data structure that can:
 *
 * Add an interval to the set of intervals.
 * Count the number of integers that are present in at least one interval.
 * Implement the CountIntervals class:
 *
 * CountIntervals() Initializes the object with an empty set of intervals.
 * void add(int left, int right) Adds the interval [left, right] to the set of intervals.
 * int count() Returns the number of integers that are present in at least one interval.
 * Note that an interval [left, right] denotes all the integers x where left <= x <= right.
 */
public class CountIntervals {
    TreeMap<Integer, Integer> intervals;
    int count;
    public CountIntervals() {
        intervals = new TreeMap<>();
        count = 0;
    }
    public void add(int left, int right) {
        //find the interval that starts at left or just less than left.
        Map.Entry<Integer, Integer> entry = intervals.floorEntry(left);
        if(entry != null && entry.getValue() >= left){
            left = entry.getKey();
            right = Math.max(right, entry.getValue());
            count -= entry.getValue() - entry.getKey() + 1;
            intervals.remove(entry);
        }
        //merge with intervals that follow this if there is an intersection.
        entry = intervals.ceilingEntry(left); // will give us an interval starts a left or just greater than left.
        while(entry != null && entry.getKey() <= right){
            right = Math.max(entry.getValue(), right);
            count -= entry.getValue() - entry.getKey() + 1;
            intervals.remove(entry);
            entry = intervals.ceilingEntry(left);
        }
        intervals.put(left, right);
        count += right - left + 1;
    }


    public int count() {
        return count;
    }
    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals();
        countIntervals.add(2, 3);  // Add interval [2, 3]
        countIntervals.add(7, 10); // Add interval [7, 10]
        System.out.println(countIntervals.count());  // Should print 6
        countIntervals.add(5, 8);  // Add interval [5, 8]
        System.out.println(countIntervals.count());  // Should print 8
    }
}
