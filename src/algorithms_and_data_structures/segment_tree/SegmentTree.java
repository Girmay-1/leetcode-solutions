package algorithms_and_data_structures.segment_tree;

import java.util.*;

/**
 * There exists an infinite number line, with its origin at 0 and extending towards the positive x-axis.
 *
 * You are given a 2D array queries, which contains two types of queries:
 *
 * For a query of type 1, queries[i] = [1, x]. Build an obstacle at distance x from the origin. It is guaranteed that there is no obstacle at distance x when the query is asked.
 * For a query of type 2, queries[i] = [2, x, sz]. Check if it is possible to place a block of size sz anywhere in the range [0, x] on the line, such that the block entirely lies in the range [0, x]. A block cannot be placed if it intersects with any obstacle, but it may touch it. Note that you do not actually place the block. Queries are separate.
 * Return a boolean array results, where results[i] is true if you can place the block specified in the ith query of type 2, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: queries = [[1,2],[2,3,3],[2,3,1],[2,2,2]]
 *
 * Output: [false,true,true]
 */
public class SegmentTree {
    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> results = new ArrayList<>();
        TreeSet<Integer> obstacles = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>(); // map to store the size of the block for each query

        for(int [] query: queries){
            int x = query[1];
            if(x == 1){ //type 1 query
                Integer lastBlock = obstacles.lower(x);
                if(lastBlock == null){
                    map.put(x, x);
                }else{
                    map.put(x, Math.max(map.get(lastBlock), x - lastBlock));
                    // Update max block sizes for all obstacles after x that might be affected by the new obstacle
                    int lastIndex = x;
                    for(int index: obstacles.tailSet(x)){
                        int preSize = map.get(index);
                        int newSize = Math.max(index - lastIndex, map.get(lastIndex));

                        if(preSize == newSize){
                            break;
                        }
                        map.put(index, newSize);
                    }
                }

                obstacles.add(x);
            }else{ //type 2 query
                int sz = query[2];
                if(x < sz) {
                    results.add(false);
                    continue;
                }

                Integer lastBlock = obstacles.floor(x);
                if(lastBlock == null) {
                    results.add(true);

                }else{
                    if(map.get(lastBlock) >= sz || x - lastBlock >= sz)
                        results.add(true);
                    else
                        results.add(false);
                }
            }

        }

        return results;
    }
}
