import java.util.HashMap;
import java.util.Map;

public class SimpleHashMap {
    public Map<Character, Integer> simpleHashMap(){
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 4);
        map.put('c', 2);
        map.put('d', 5);
        map.put('e', 6);

        return map;
    }

    public static void main(String[] args) {
        SimpleHashMap simpleHashMap = new SimpleHashMap();
        Map<Character, Integer> map = simpleHashMap.simpleHashMap();
        for(Map.Entry entry: map.entrySet()){
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
            entry.getValue();
        }
        for(Character c : map.keySet()){
            System.out.println(c);
        }
        for(Integer val: map.values()){
            System.out.println(val);
        }

    }
}
