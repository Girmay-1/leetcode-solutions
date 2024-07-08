package algorithms_and_data_structures.minimum_spanning_trees;

import java.util.*;

/**
 * Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 */
public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));


        if(!bankSet.contains(endGene)){
            return  -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        visited.add(startGene);
        queue.offer(startGene);

        int mutations = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String gene = queue.poll();
                if(gene.equals(endGene)){
                    return mutations;
                }
                for(String nextGene: getMutations(gene, bankSet)){
                    if(!visited.contains(nextGene)){
                        visited.add(nextGene);
                        queue.offer(nextGene);
                    }
                }
            }
            mutations++;
        }
        return -1;
    }

    private List<String> getMutations(String gene, Set<String> bankList) {
        List<String> mutations = new ArrayList<>();
        char[] choices = {'A', 'C', 'G', 'T'};

        for(int i = 0; i < gene.length(); i++){
            char[] charArray = gene.toCharArray();
            for(char c : choices){
                if(charArray[i] == c){
                    continue;
                }
                charArray[i] = c;
                String newGene = new String(charArray);
                if(bankList.contains(newGene)){
                    mutations.add(newGene);
                }
            }
        }
        return mutations;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation solution = new MinimumGeneticMutation();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int minMutations = solution.minMutation(start, end, bank);
        System.out.println("Minimum number of mutations: " + minMutations);
    }
}
