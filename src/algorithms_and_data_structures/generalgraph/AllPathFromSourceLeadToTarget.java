package algorithms_and_data_structures.generalgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class AllPathFromSourceLeadToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph.length - 1, path, solution, graph);
        return solution;
    }
    private void dfs(int current, int target, List<Integer> path, List<List<Integer>> sol, int[][] graph){
        if(current == target){
            sol.add(new ArrayList<>(path));

        }
        for(int next: graph[current]){
            path.add(next);
            dfs(next, target, path, sol, graph);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        // Define a graph using an adjacency list representation
        // Example: graph[i] contains all nodes i has edges towards
        int[][] graph = {
                {1, 2},  // Node 0 connects to Node 1 and 2
                {3},     // Node 1 connects to Node 3
                {3},     // Node 2 connects to Node 3
                {}       // Node 3 is the target, no further connections
        };

        // Create an instance of the class
        AllPathFromSourceLeadToTarget pathsFinder = new AllPathFromSourceLeadToTarget();

        // Find all paths from source (Node 0) to target (Node 3)
        List<List<Integer>> result = pathsFinder.allPathsSourceTarget(graph);

        // Print the result
        System.out.println("All paths from source to target:");
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
