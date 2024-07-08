//referrenced from github.
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class  Anagram {
    public static Set<Set<String>> groupAnagrams(List<String> words){
        Set<Set<String>> anagrams = new HashSet<>();
        if(words == null)
            return anagrams;
        //sorting words
        List<String> list = words.stream()
                .map(s -> Stream.of(s.split("")).sorted()
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
        System.out.println("list is" + list.toString());

        // a map where the key is each sorted word and value is a list of indices
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            map.putIfAbsent(list.get(i),new ArrayList<>());
            map.get(list.get(i)).add(i);
        }
        System.out.println("map is " + map);
        for(var entry: map.entrySet()){
            Set<String> collection = entry.getValue().stream()
                    .map(i -> words.get(i))
                    .collect(Collectors.toSet());
            if(collection.size() >1){
                anagrams.add(collection);
            }
        }
        return anagrams;
    }

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("dog");
        myList.add("act");
        myList.add("cat");
        myList.add("god");
        myList.add("own");
        myList.add("won");
        System.out.println(groupAnagrams(myList).toString());
    }
}
