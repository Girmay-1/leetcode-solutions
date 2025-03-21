package algorithms_and_data_structures.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * ou have k servers numbered from 0 to k-1 that are being used to handle multiple requests simultaneously. Each server has infinite computational capacity but cannot handle more than one request at a time. The requests are assigned to servers according to a specific algorithm:
 *
 * The ith (0-indexed) request arrives.
 * If all servers are busy, the request is dropped (not handled at all).
 * If the (i % k)th server is available, assign the request to that server.
 * Otherwise, assign the request to the next available server (wrapping around the list of servers and starting from 0 if necessary). For example, if the ith server is busy, try to assign the request to the (i+1)th server, then the (i+2)th server, and so on.
 * You are given a strictly increasing array arrival of positive integers, where arrival[i] represents the arrival time of the ith request, and another array load, where load[i] represents the load of the ith request (the time it takes to complete). Your goal is to find the busiest server(s). A server is considered busiest if it handled the most number of requests successfully among all the servers.
 *
 * Return a list containing the IDs (0-indexed) of the busiest server(s). You may return the IDs in any order.
 */
public class ServerAssignment {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] requesttCount = new int[k];  // to count the number of requests handled by each server
        TreeSet<Integer> availableServers = new TreeSet<>(); // to keep track of available servers

        for(int i = 0; i < arrival.length; i++){
            int arrivalTime = arrival[i];
            int loadTime = load[i];

            //free up servers that are done processing
            while(!busyServers.isEmpty() && busyServers.peek()[0] <= arrivalTime){
                int serverId = busyServers.poll()[1];
                availableServers.add(serverId);
            }
            //drop request if all servers are busy
            if(availableServers.isEmpty()){
                continue;
            }

            //find the server to assign the request to
            int serverId = i % k;
            Integer assignedServer = availableServers.ceiling(serverId);
            if(assignedServer == null){
                assignedServer = availableServers.first();
            }
            availableServers.remove(assignedServer);
            requesttCount[assignedServer]++;
            busyServers.offer(new int[]{arrivalTime + loadTime, assignedServer});

            //find the server that handled the most requests
            int maxRequests = 0;
            for(int j = 0; j < k; j++){
                maxRequests = Math.max(maxRequests, requesttCount[j]);
            }
            //add the server(s) that handled the most requests to the result list
            for(int j = 0; j < k; j++){
                if(requesttCount[j] == maxRequests){
                    result.add(j);
                }
            }
        }
        return result;
    }
}
