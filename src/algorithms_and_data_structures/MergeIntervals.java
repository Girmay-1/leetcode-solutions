package algorithms_and_data_structures;

import java.util.ArrayList;
import java.util.List;

/**
 * xample:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> sol = new ArrayList<>();
        if(intervals.length <= 1){
            return  intervals;
        }
        int[] currentInterval = intervals[0];
        int n = intervals.length;

        for(int i = 1; i < n; i++){
            if(intervals[i][0] <= currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            }else{
                sol.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        sol.add(currentInterval);




        return sol.toArray(new int[sol.size()][2]);
    }
}
