package algorithms_and_data_structures.generalgraph;

import java.util.*;

/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 */
public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // Initialize distances array
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        // BFS Queue: {node, cost, stops}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], cost = current[1], stops = current[2];

            if (stops > k) continue;

            List<int[]> neighbors = graph.getOrDefault(node, Collections.emptyList());
            for (int[] neighbor : neighbors) {
                int nextNode = neighbor[0], price = neighbor[1];
                int newCost = cost + price;

                if (newCost < distances[nextNode]) {
                    distances[nextNode] = newCost;
                    queue.offer(new int[]{nextNode, newCost, stops + 1});
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
    public static void main(String[] args) {
        // Define number of nodes (cities)
        int n = 4;

        // Define flights: {source, destination, price}
        int[][] flights = {
                {0, 1, 100},  // Flight from city 0 to city 1 costs 100
                {1, 2, 100},  // Flight from city 1 to city 2 costs 100
                {2, 3, 100},  // Flight from city 2 to city 3 costs 100
                {0, 2, 500}   // Flight from city 0 to city 2 costs 500
        };

        // Source city
        int src = 0;

        // Destination city
        int dst = 3;

        // Maximum stops allowed (k)
        int k = 1;

        // Create an instance of the solution class
        FindCheapestPrice solution = new FindCheapestPrice();

        // Find the cheapest price within k stops
        int result = solution.findCheapestPrice(n, flights, src, dst, k);

        // Output the result
        System.out.println("The cheapest price is: " + result);
    }
}
