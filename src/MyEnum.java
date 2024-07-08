import java.net.http.HttpClient;
import java.util.HashMap;

public enum MyEnum {
    SUCCESS("Success", new HashMap<String, Object>() {{
        put("status", Math.max(9,20));
        put("message", "Successfully transferred");
    }}),
    KEY2("value2", new HashMap<String, Object>() {{
        put("key3", "value3");
        put("key4", "value4");
    }});

    private String key;
    private HashMap<String, Object> value;

    MyEnum(String key, HashMap<String, Object> value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public HashMap<String, Object> getValue() {
        return value;
    }

    public static void main(String[] args) {
        String anotherVariable = "SUCCESS";
        MyEnum key1 = MyEnum.SUCCESS;
        String key = key1.getKey(); // "value1"
        System.out.println(key);
        HashMap<String, Object> value = key1.getValue(); // {"key1": "value1", "key2": "value2"}
        System.out.println(value);

    }
}
