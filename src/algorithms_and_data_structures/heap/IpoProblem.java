package algorithms_and_data_structures.heap;

import java.util.PriorityQueue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 *
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 *
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 *
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class IpoProblem {
    // we are going to use two heaps for this problem

    //time: O(klogn) [ time for the offer operation logn and since we are iterating n times the first one and k times the second one we have nlongn + klogn ~ nlogn
    //space: O(n)
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> miniHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);  // miniheap based on capital.Here a is the first entry & comprises (capital, profit) and b is the second entry it also comprises (capital, profit)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]); //maxHeap based on profits
        for(int i = 0; i < capital.length; i++){
            miniHeap.offer(new int[]{capital[i], profits[i]});
         }

        for(int i = 0; i < k; i++){
            while(!miniHeap.isEmpty() && w >= miniHeap.peek()[0]){
                maxHeap.offer(miniHeap.poll());

            }
            //no projects
            if(maxHeap.isEmpty()){
                break;
             }

            w += maxHeap.poll()[1];
        }
        return w;

    }
    public static void main(String[] args) {
        IpoProblem problem = new IpoProblem();

        // Example input
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        int result = problem.findMaximizedCapital(k, w, profits, capital);
        System.out.println("Maximum capital after investing in projects: " + result);
    }


}
