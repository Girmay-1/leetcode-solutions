import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static List<Integer> primeFactors(int n){

        List<Integer> primeList = new ArrayList<>();
        if(n < 0){
            primeList.add(n);
        return primeList;
        }
        while (n % 2 == 0){
            primeList.add(2);
            n/=2;
        }
        for(int i = 3; i <= Math.sqrt(n); i+= 2){
            while(n % i == 0){
                primeList.add(i);
                n/=i;
            }
        }
        if(n > 2)
            primeList.add(n);
        return primeList;

    }

    public static void main(String[] args) {
        System.out.println(primeFactors(100).toString());
    }
}
