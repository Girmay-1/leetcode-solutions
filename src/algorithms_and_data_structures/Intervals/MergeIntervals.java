package algorithms_and_data_structures.Intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> sol = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a-> a[0]));
        int[] currentIntervals = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= currentIntervals[1]){
                currentIntervals[1] = Math.max(currentIntervals[1], intervals[i][1]);
            }else{
                sol.add(currentIntervals);
                currentIntervals = intervals[i];
            }
        }
        sol.add(currentIntervals);
        return sol.toArray(new int[sol.size()][currentIntervals.length]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = mergeIntervals.merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
