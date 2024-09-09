package algorithms_and_data_structures.dynamicprogramming;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are k workers who want to move n boxes from the right (old) warehouse to the left (new) warehouse. You are given the two integers n and k, and a 2D integer array time of size k x 4 where time[i] = [righti, picki, lefti, puti].
 *
 * The warehouses are separated by a river and connected by a bridge. Initially, all k workers are waiting on the left side of the bridge. To move the boxes, the ith worker can do the following:
 *
 * Cross the bridge to the right side in righti minutes.
 * Pick a box from the right warehouse in picki minutes.
 * Cross the bridge to the left side in lefti minutes.
 * Put the box into the left warehouse in puti minutes.
 * The ith worker is less efficient than the jth worker if either condition is met:
 *
 * lefti + righti > leftj + rightj
 * lefti + righti == leftj + rightj and i > j
 * The following rules regulate the movement of the workers through the bridge:
 *
 * Only one worker can use the bridge at a time.
 * When the bridge is unused prioritize the least efficient worker on the right side to cross. If there are no workers on the right side, prioritize the least efficient worker on the left side to cross.
 * If enough workers have already been dispatched from the left side to pick up all the remaining boxes, no more workers will be sent from the left side.
 * Return the elapsed minutes at which the last box reaches the left side of the bridge.
 */
public class TimeToCrossBridge {
    public int findCrossingTime(int n, int k, int[][] time) {
        //queue of arrays where elements with index 0 -> 3 are from time for the ith worker and index 4 holds the worker index and index 5 is the current time.
        PriorityQueue<int[]> leftToright = new PriorityQueue<>((a, b) -> b[0] + b[2] == a[0] + a[2]? b[4] - a[4]: (b[0] + b[2]) - (a[0] + a[2]));
        PriorityQueue<int[]> rightToLeft = new PriorityQueue<>((a, b) -> b[0] + b[2] == a[0] + a[2]? b[4] - a[4]: (b[0] + b[2]) - (a[0] + a[2]));
        PriorityQueue<int[]> pickBox = new PriorityQueue<>(Comparator.comparingInt(a -> a[5]));
        PriorityQueue<int[]> dropBox = new PriorityQueue<>(Comparator.comparingInt(a -> a[5]));

        int currentTime = 0;

        //initially everyone was on left.
        for(int i= 0; i < k; i++){
            leftToright.offer(new int[]{time[i][0], time[i][1], time[i][2], time[i][3], i, currentTime});
        }

        while(n > 0 || !pickBox.isEmpty() || !rightToLeft.isEmpty()){
            //move Available workers to their respective queues if "done" with picking or dropping boxes. These showns readiness whether boxes are there or not.

            while(!pickBox.isEmpty() && pickBox.peek()[5] <= currentTime){
                rightToLeft.offer(pickBox.poll());
            }
            while (!dropBox.isEmpty() && dropBox.peek()[5] <= currentTime){
                leftToright.offer(dropBox.poll());
            }
            //check if workers can cross the bridge from right to left;
            if(!rightToLeft.isEmpty()){
                int[] worker = rightToLeft.poll();
                currentTime = Math.max(currentTime, worker[5]) + worker[2];
                dropBox.offer(new int[]{worker[0], worker[1], worker[2], worker[3], worker[4], currentTime + worker[3]});

            }

            //check if workers can cross the bridge from left to right

            else if(!leftToright.isEmpty() && n > 0){
                int[] worker = leftToright.poll();
                currentTime = Math.max(worker[5], currentTime) + worker[0];
                pickBox.offer(new int[]{worker[0], worker[1], worker[2], worker[3], worker[4], currentTime + worker[1]});
                n--;
            }

            else{
                // No worker crosses, time advances
                int nextTime = Integer.MAX_VALUE;
                if(!pickBox.isEmpty()){
                    nextTime = Math.min(nextTime, pickBox.peek()[5]);

                }
                if(!dropBox.isEmpty()){
                    nextTime = Math.min(nextTime, dropBox.peek()[5]);
                }
                if(nextTime != Integer.MAX_VALUE){
                    currentTime = nextTime;
                }
            }
        }

        return currentTime;
    }
    public static void main(String[] args) {
        TimeToCrossBridge solution = new TimeToCrossBridge();

        // Test Case 1
        int n1 = 1;
        int k1 = 3;
        int[][] time1 = {{1,1,2,1}, {1,1,3,1}, {1,1,4,1}};
        int result1 = solution.findCrossingTime(n1, k1, time1);
        System.out.println("Test Case 1 Result: " + result1);
        System.out.println("Expected: 6");

        // Test Case 2
        int n2 = 3;
        int k2 = 2;
        int[][] time2 = {{1,9,1,8}, {10,10,10,10}};
        int result2 = solution.findCrossingTime(n2, k2, time2);
        System.out.println("Test Case 2 Result: " + result2);
        System.out.println("Expected: 50");

        // Additional test case (optional)
        int n3 = 10;
        int k3 = 4;
        int[][] time3 = {{2,3,2,3}, {1,2,1,2}, {3,4,3,4}, {2,2,2,2}};
        int result3 = solution.findCrossingTime(n3, k3, time3);
        System.out.println("Test Case 3 Result: " + result3);
        System.out.println("Expected: (You need to calculate this manually or verify)");
    }

}
