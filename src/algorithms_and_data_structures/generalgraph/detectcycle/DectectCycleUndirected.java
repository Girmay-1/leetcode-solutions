package algorithms_and_data_structures.generalgraph.detectcycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * whenever we encounter a visited neighbor and that neighbor is not where we came for(parent), cycle exists.
 */
public class DectectCycleUndirected {
    public boolean detectCycle(List<List<Integer>> graph, int numberOfVertices){
        boolean[] visited = new boolean[numberOfVertices];
        Arrays.fill(visited,false);
        for(int i = 0; i < numberOfVertices; i++){
            if(visited[i] == false){
                if(dfs(i, -1, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private  boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true;

        for(Integer neighbor : graph.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, node , graph, visited)){
                    return true;
                }
            }else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DectectCycleUndirected dectectCycleUndirected = new DectectCycleUndirected();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(0);
        adjList.get(0).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        boolean hasCycle = dectectCycleUndirected.detectCycle(adjList, 4);
        System.out.println(hasCycle);
    }
}
