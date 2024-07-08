import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
    static void main2(List<String> myList){
        Iterator<String> iterator = myList.listIterator();
        while (iterator.hasNext()){
            String alph = iterator.next();
            if(alph.equals("c"))
                iterator.remove();
        }
    }
    public static void main3(List<String> myList){
        myList.removeIf(l ->l.equals("a"));
    }

    public static void main(String[] args){
        List<String> alphabet = new ArrayList<String>();
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        main2(alphabet);
        main3(alphabet);
        for(String alp: alphabet){
            if(alp.equals("c"));
            alphabet.remove(alp);
        }
    }
}
