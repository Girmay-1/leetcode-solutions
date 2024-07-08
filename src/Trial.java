import java.util.ArrayList;
import java.util.List;

public class Trial {
    private List<String> myList;

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public static void main(String[] args) {
        Trial trial = new Trial();
        if(trial.getMyList()==null)
            trial.setMyList(new ArrayList<>());
        trial.getMyList().add("english");
        System.out.println(trial.getMyList());
    }
}
