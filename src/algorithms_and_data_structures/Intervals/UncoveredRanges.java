package algorithms_and_data_structures.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You are given an integer n which is the length of a 0-indexed array nums, and a 0-indexed 2D-array ranges, which is a list of sub-ranges of nums (sub-ranges may overlap).
 *
 * Each row ranges[i] has exactly 2 cells:
 *
 * ranges[i][0], which shows the start of the ith range (inclusive)
 * ranges[i][1], which shows the end of the ith range (inclusive)
 * These ranges cover some cells of nums and leave some cells uncovered. Your task is to find all of the uncovered ranges with maximal length.
 *
 * Return a 2D-array answer of the uncovered ranges, sorted by the starting point in ascending order.
 *
 * By all of the uncovered ranges with maximal length, we mean satisfying two conditions:
 *
 * Each uncovered cell should belong to exactly one sub-range
 * There should not exist two ranges (l1, r1) and (l2, r2) such that r1 + 1 = l2;
 */
public class UncoveredRanges {
    public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        if (ranges.length == 0) {
            return n == 0 ? new int[0][2] : new int[][]{{0, n-1}};
        }

        // Sort by start time
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);

        // Merge overlapping intervals first
        List<int[]> merged = new ArrayList<>();
        int start = ranges[0][0], end = ranges[0][1];

        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] <= end + 1) {
                end = Math.max(end, ranges[i][1]);
            } else {
                merged.add(new int[]{start, end});
                start = ranges[i][0];
                end = ranges[i][1];
            }
        }
        merged.add(new int[]{start, end});

        // Find uncovered ranges
        List<int[]> result = new ArrayList<>();
        // Check before first range
        if (merged.get(0)[0] > 0) {
            result.add(new int[]{0, merged.get(0)[0] - 1});
        }

        // Check between ranges
        for (int i = 1; i < merged.size(); i++) {
            int prev = merged.get(i-1)[1];
            int curr = merged.get(i)[0];
            if (curr - prev > 1) {
                result.add(new int[]{prev + 1, curr - 1});
            }
        }

        // Check after last range
        if (merged.get(merged.size()-1)[1] < n-1) {
            result.add(new int[]{merged.get(merged.size()-1)[1] + 1, n-1});
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        UncoveredRanges uncoveredRanges = new UncoveredRanges();
        int[][] ranges = new int[][]{{0,1},{4,4}, {2,4}, {2,2}, {1,2}};
        int n = 10;
        int[][] result = uncoveredRanges.findMaximalUncoveredRanges(n,ranges);
        printRanges(result);

    }
    private static void printRanges(int[][] ranges) {
        System.out.print("[");
        for (int i = 0; i < ranges.length; i++) {
            System.out.print("[" + ranges[i][0] + "," + ranges[i][1] + "]");
            if (i < ranges.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
