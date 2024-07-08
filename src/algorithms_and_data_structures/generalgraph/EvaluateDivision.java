package algorithms_and_data_structures.generalgraph;

import java.util.*;

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them
 */
public class EvaluateDivision {
    public double[] calcEquationDFS(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] solution = new double[queries.size()];

        Map<String, Map<String, Double>> graph = constructGraph(equations, values);

        for(int i = 0; i < queries.size(); i++){
            solution[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());

        }


        return solution;
    }
public double[] calcEquationBFS(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] solution = new double[queries.size()];

        Map<String, Map<String, Double>> graph = constructGraph(equations, values);

        for(int i = 0; i < queries.size(); i++){

            solution[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashMap<>());
        }


        return solution;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> graph, HashSet<Object> visited) {
        if(!graph.containsKey(start) || !graph.containsKey(end)){
            return -1;
        }
        if(start.equals(end)){
            return 1;
        }

        visited.add(start);

            for(Map.Entry<String, Double> entry: graph.get(start).entrySet()){
                String next = entry.getKey();
                Double value = entry.getValue();

                if(!visited.contains(next)){
                    double result = dfs(next, end, graph,visited);
                    if(result != -1){
                        return value * result;
                    }
                }


            }

        //time complexity: O(Q * (E + V))
//space = size of graph = O(E + V);

        return -1;
    }

    private double bfs(String start, String end, Map<String, Map<String, Double>> graph, Map<String, Double> visited){

        if(!graph.containsKey(start) || !graph.containsKey(end)){
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        visited.put(start, 1.0);
        queue.offer(start);


        while (!queue.isEmpty()){
            String current =   queue.poll();
            Double result = visited.get(current);
            if(current.equals(end)){
                return result;
            }
            for(Map.Entry<String, Double> entry: graph.get(current).entrySet()){
                String next = entry.getKey();
                Double value = entry.getValue();
                if (!visited.containsKey(next)) {
                    queue.offer(next);

                    visited.put(next,result * value);

                }
            }
        }

        return -1.0;
    }

    private Map<String, Map<String, Double>> constructGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(dividend, new HashMap<>());
            graph.get(dividend).put(divisor, value);

            graph.putIfAbsent(divisor, new HashMap<>());
            graph.get(divisor).put(dividend, 1/value);

        }
        return graph;
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();



        // Sample equations and values
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("a", "c"));
        double[] values = {2.0, 3.0, 6.0};

        // Sample queries
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("b", "c"));
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("x", "y")); // Testing non-existent query

        // Calculate results
        System.out.println("using DFS");
        double[] results = solution.calcEquationDFS(equations, values, queries);

        double[] results2 = solution.calcEquationBFS(equations, values, queries);

        // Print results
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String queryStr = query.get(0) + "/" + query.get(1);
            double result = results[i];
            System.out.println("Result for query " + queryStr + ": " + result);
        }
        System.out.println("using BFS");
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String queryStr = query.get(0) + "/" + query.get(1);
            double result = results2[i];
            System.out.println("Result for query " + queryStr + ": " + result);
        }
    }
}
