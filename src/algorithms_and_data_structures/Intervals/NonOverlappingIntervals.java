package algorithms_and_data_structures.Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1])); ///sort by their ending times.
        // Sorting by start times does not take into account how long an interval extends, which can cause more overlaps later on, leading to suboptimal solutions. This failure can be summarized as follows:

        //     1.Premature Inclusion of Long Intervals: Including an interval with an early start time but a long duration can block many subsequent intervals, leading to more removals.
        //     2.Local Optimality vs. Global Optimality: Sorting by start times and choosing intervals greedily might lead to locally optimal choices that do not result in a globally optimal solution.

        int lastIntervalEnd = intervals[0][1];
        int nonOverlappingCount = 1;

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= lastIntervalEnd){
                nonOverlappingCount++;
                lastIntervalEnd = intervals[i][1];
            }
        }

        return intervals.length - nonOverlappingCount;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int sol = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        System.out.println("for: " + intervals + ", " + "we can remove minimum of " + sol + " intervals");
    }
}
