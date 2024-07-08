package algorithms_and_data_structures;

import java.util.*;

public class IterativeDepthFirstSearch {
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Integer> visited = iterativeDFS(0, graph.getAdjanceyList());
        System.out.println(visited);


    }

    private static List<Integer> iterativeDFS(int i, Map<Integer, List<Integer>> adjanceyMap) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while(!stack.empty()){
          int v = stack.pop();
          if(!visited.contains(v)){
              visited.add(v);
              List<Integer> adjacents = adjanceyMap.getOrDefault(v, new ArrayList<>());
              for(int j : adjacents){
                if(!visited.contains(j)){
                  stack.push(j);
                }
             }
          }
        }

        return visited;
    }

    private static class Graph {
        Map<Integer, List<Integer>> adjanceyList;
        Graph(){
            adjanceyList = new HashMap<>();
        }

        public void addEdge(int from, int to){
            adjanceyList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }
        public Map<Integer,List<Integer>> getAdjanceyList(){
            return adjanceyList;
        }

    }
}
