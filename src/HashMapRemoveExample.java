import java.util.HashMap;
import java.util.List;

public class HashMapRemoveExample {
    public static void main(String[] args) {
        HashMap<Integer, String> languages = new HashMap<>();
        languages.put(1, "python");
        languages.put(2,"java");
        languages.put(3, "C++");
        languages.put(4, "javaScript");
        System.out.println(languages);
        languages.remove(1);
        languages.remove("python");
        System.out.println("updated map: " + languages);


    }
}
