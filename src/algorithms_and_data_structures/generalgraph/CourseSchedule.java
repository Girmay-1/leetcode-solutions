package algorithms_and_data_structures.generalgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int topologicalOrderCount = 0;
        Queue<Integer> queue = new LinkedList<>();

        //construct the graph (adjacency list)
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preRequisite = prerequisites[i][1];
            inDegree[course]++;
            graph.get(preRequisite).add(course);  //graph directed from preRequisite to course.
        }

        for(int course = 0; course < numCourses; course++){ //remember the indices of inDegree correspond to the courses. Values are the number of prerequisites they have.
            if(inDegree[course] == 0){
                queue.offer(course);
            }
        }

        while (!queue.isEmpty()){
            int course = queue.poll();
            topologicalOrderCount++;

            for(int nextCourse : graph.get(course)){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0){
                    queue.offer(nextCourse);
                }
            }
        }

        return topologicalOrderCount == numCourses;

    }
}
