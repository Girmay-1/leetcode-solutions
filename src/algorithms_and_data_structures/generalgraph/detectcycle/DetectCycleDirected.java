package algorithms_and_data_structures.generalgraph.detectcycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * if we encounter a node that's in visiting state, then there is a cycle. We can use DFS with three states, visited, visiting, unvisited.
 */
public class DetectCycleDirected {
    enum State {
        VISITING,
        VISITED,
        UNVISITED
    };

    public boolean detectCycle(List<List<Integer>> graph, int numberOfVertices){
        State[] states = new State[numberOfVertices];
        Arrays.fill(states, State.UNVISITED);

        for(int i = 0; i < numberOfVertices; i++){
            if(states[i] == State.UNVISITED){
               if(dfs(i, states, graph)){
                   return true;
               }
            }
        }
        return false;
    }

    private boolean dfs(int node, State[] states, List<List<Integer>> graph) {
        states[node] = State.VISITING;

        for(Integer neighbor : graph.get(node)){
            if(states[neighbor] == State.UNVISITED){
                if(dfs(neighbor, states, graph)){
                    return true;
                }
            }else if(states[neighbor] == State.VISITING){
                return true;
            }
        }
        states[node] = State.VISITED;
        return false;
    }

    public static void main(String[] args) {
        DetectCycleDirected detectCycleDirected = new DetectCycleDirected();
        List<List<Integer>> graph = new ArrayList<>();
        int numberOfVertices = 4;
        for(int i = 0; i < numberOfVertices; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);

        boolean cyclePresence = detectCycleDirected.detectCycle(graph, numberOfVertices);
        System.out.println(cyclePresence);

    }

    //time: O(V + TE). Here T is equal to time to put in and out of the bag that we used in DFS ( recursion in this case which is O(1))
}
