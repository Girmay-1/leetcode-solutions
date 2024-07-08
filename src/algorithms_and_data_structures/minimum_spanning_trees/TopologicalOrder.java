package algorithms_and_data_structures.minimum_spanning_trees;

import java.util.*;

/**
 * course schedule II
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class TopologicalOrder {
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] sol = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses]; // to keep track of incoming paths to a node (prerequisites).

        //construct a graph;
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int course = 0; course < numCourses; course++){
            if(indegree[course] == 0){
                queue.offer(course);
            }
        }
        int count = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            sol[count++] = course;

            for(int nextCourse : graph.get(course)){
                indegree[nextCourse]--; //because prerequisite is already taken.
                if(indegree[nextCourse]== 0){
                    queue.offer(nextCourse);
                }
            }
        }

        return (count == numCourses)? sol: new int[0];
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites){
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(prerequisite).add(course);

        }

        for(int course = 0; course < numCourses; course++){
            if(!dfs(course, graph, visited, stack)){
                return new int[0];
            }
        }
        int[] sol = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()){
            sol[i++] = stack.pop();
        }
        return sol;
    }

    private boolean dfs(int course, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        if (visited[course]) {
            return true; // Already visited, no cycle
        }

        visited[course] = true; // Mark current course as visited

        for (int nextCourse : graph.get(course)) {
            if (!dfs(nextCourse, graph, visited, stack)) {
                return false; // Cycle detected in the child
            }
        }

        stack.push(course); // Add course to the stack after exploring all prerequisites
        return true;
    }

    public static void main(String[] args) {
        TopologicalOrder solution = new TopologicalOrder();
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1,0},{2,0},{3,1},{3,2}};
        int[] result1 = solution.findOrder1(numCourses1, prerequisites1);
        System.out.println("Result for Test Case 1:");
        printArray(result1);

        // Test case 2
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1,0},{2,1},{3,2},{1,3}};
        int[] result2 = solution.findOrder1(numCourses2, prerequisites2);
        System.out.println("Result for Test Case 2:");
        printArray(result2);

        System.out.printf("dfs");

        int[] result3 = solution.findOrder2(numCourses1, prerequisites1);
        System.out.println("Result for Test Case 1:");
        printArray(result3);

        // Test case 2


        int[] result4 = solution.findOrder1(numCourses2, prerequisites2);
        System.out.println("Result for Test Case 2:");
        printArray(result4);
    }
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
