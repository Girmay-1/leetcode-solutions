public class Test {
    public static void main(String[] args) {
//        int a = 5;
//        int b = 10;
//        System.out.println(a = b);

        String s1 = "abc";
        String s2 = new String("abc");
        s2.intern();
        System.out.println(s1 ==s2);

    }
}
