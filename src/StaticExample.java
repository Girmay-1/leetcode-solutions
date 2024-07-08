public class StaticExample {
    public static void staticExampleMethod(){
        System.out.println("Invoking using instance variable");

    }

    public static void main(String[] args) {
        StaticExample myobject = new StaticExample();
        myobject.staticExampleMethod();
    }
}
