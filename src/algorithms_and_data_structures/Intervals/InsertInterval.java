package algorithms_and_data_structures.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> sol = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(newInterval[1] < intervals[i][0]){
                sol.add(newInterval);
                int[][] subArray = Arrays.copyOfRange(intervals, i, n);
                sol.addAll(Arrays.asList(subArray));
                return sol.toArray(new int[sol.size()][2]);
            }else if(intervals[i][1] < newInterval[0]){
                sol.add(intervals[i]);
            }else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        sol.add(newInterval);
        return sol.toArray(new int[sol.size()][2]);

    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = insertInterval.insert(intervals,newInterval);

        System.out.println("Result:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }

    }
}
