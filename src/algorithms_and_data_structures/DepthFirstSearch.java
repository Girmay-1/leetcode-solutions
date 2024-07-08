package algorithms_and_data_structures;
// this code implements DFS recusrively.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {
    public  static void main(String[] args) {
        List<Integer> marked = new ArrayList<>();
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        recursiveDFS(0, graph.getAdjList(), marked);
        System.out.println(marked);

    }

        public static void recursiveDFS(int v, Map<Integer, List<Integer>> adjList, List<Integer> marked) {
            if (!marked.contains(v)) {
                marked.add(v);
                List<Integer> neighbors = adjList.getOrDefault(v, new ArrayList<>());

                for (int w : neighbors) {
                    System.out.println(v);
                    recursiveDFS(w, adjList, marked);
                }
            }
        }

    private static class Graph {
        private Map<Integer, List<Integer>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        public void addEdge(int from, int to) {
            adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        public Map<Integer, List<Integer>> getAdjList() {
            return adjList;
        }
    }
}

