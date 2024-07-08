import java.util.ArrayList;
import java.util.List;

public class CheckListIsOdd {
    public static boolean checkListIsOdd(List<Integer> list){
        // assuming the list is huge, we will use parallel stream

        return list.parallelStream()
                .anyMatch(x ->(x % 2) != 0);

    }

    public static void main(String[] args) {
        List<Integer> mylist = List.of(1,3);
        System.out.println(checkListIsOdd(mylist));
    }
}
