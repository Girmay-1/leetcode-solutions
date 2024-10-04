package algorithms_and_data_structures.generalgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
 *
 * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
 *
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Illustration of graph
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
 * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 * Example 2:
 *
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * Explanation:
 * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * 0 <= graph[i][j] <= n - 1
 * graph[i] is sorted in a strictly increasing order.
 * The graph may contain self-loops.
 * The number of edges in the graph will be in the range [1, 4 * 104].
 */
public class EvaluateSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        // Perform DFS for each node
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                result.add(i);
            }
        }

        Collections.sort(result);
        return result;
    }
    private boolean dfs(int node, int[][] graph, int[] state) {
        // If the node has been visited and its state is determined
        if (state[node] != 0) {
            return state[node] == 2;
        }

        // Mark the node as being visited
        state[node] = 1;

        // Check all neighbors
        for (int neighbor : graph[node]) {
            if (state[neighbor] == 1 || !dfs(neighbor, graph, state)) {
                return false;
            }
        }

        // Mark the node as safe
        state[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        EvaluateSafeNodes solution = new EvaluateSafeNodes();

        // Test case 1
        int[][] graph1 = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> result1 = solution.eventualSafeNodes(graph1);
        System.out.println("Test case 1:");
        System.out.println("Input: [[1,2],[2,3],[5],[0],[5],[],[]]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: [2, 4, 5, 6]");
        System.out.println();

        // Test case 2
        int[][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        List<Integer> result2 = solution.eventualSafeNodes(graph2);
        System.out.println("Test case 2:");
        System.out.println("Input: [[1,2,3,4],[1,2],[3,4],[0,4],[]]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: [4]");
        System.out.println();

    }
}
