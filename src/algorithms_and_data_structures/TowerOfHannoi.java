package algorithms_and_data_structures;

public class TowerOfHannoi {
    public void hannoi(int n, char source, char temp, char destination){
        if(n == 0){
            return;
        }

        hannoi(n -1, source, destination, temp);
        System.out.println("moving disk:" + n + " from " + source + " to " + destination);
        hannoi(n -1, temp, source, destination );

    }

    public static void main(String[] args) {
        TowerOfHannoi towerOfHannoi = new TowerOfHannoi();
        towerOfHannoi.hannoi(3, 'S', 'T', 'D');
    }

    // time -> O(n ^ 2)
    //space -> O(n).
}
