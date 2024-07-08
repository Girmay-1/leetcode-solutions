import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AverageFrom2D {
    public static HashMap<String, Integer> average(String[][] stringArray){
        HashMap<String, Integer> result = new HashMap<>();
        HashMap<String, ArrayList<Integer>> myMap = new HashMap<>();
        for(int i = 0; i < stringArray.length; i++){
            if(myMap.containsKey(stringArray[i][0]))
                myMap.get(stringArray[i][0]).add(Integer.parseInt(stringArray[i][1]));
            else{
                ArrayList<Integer> myList = new ArrayList<>();
                myList.add(Integer.parseInt(stringArray[i][1]));
                myMap.put(stringArray[i][0],myList);
            }


        }
        for(Map.Entry<String, ArrayList<Integer>> entry: myMap.entrySet()){
            int sum = 0;
            for(Integer val: entry.getValue()){
                sum += val;
            }
            result.put(entry.getKey(),sum/entry.getValue().size());
        }

        return result;
    }

    public static void main(String[] args) {
        String[][] ss={{"Bobby", "87" },
                { "Charles", "100" },
                { "Eric", "64" },
                { "Charles", "22" } };
        System.out.println(average(ss));
    }
}
