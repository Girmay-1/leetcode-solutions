package algorithms_and_data_structures.bitoperation;

public class ReverseBits {
    public int reverseBits(int n) {
        int solution = 0;

        for(int i = 0; i < 32; i++){
            int bit = (n >> i) & 1;
            solution |= (bit << (31 - i));
        }
        return solution;
    }
    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        int two = 2;

        System.out.println("two:" + ~two);

        // Test case 1
        int n1 = 43261596;
            int expected1 = 964176192;
        int reversed1 = solution.reverseBits(n1);
        System.out.println("Input: " + n1 + " (Binary: " + Integer.toBinaryString(n1) + ")");
        System.out.println("Expected Output: " + expected1 + " (Binary: " + Integer.toBinaryString(expected1) + ")");
        System.out.println("Actual Output: " + reversed1 + " (Binary: " + Integer.toBinaryString(reversed1) + ")");
        System.out.println(reversed1 == expected1 ? "Success" : "Failure");
        System.out.println();

        // Test case 2
        int n2 = 0;
        int expected2 = 0;
        int reversed2 = solution.reverseBits(n2);
        System.out.println("Input: " + n2 + " (Binary: " + Integer.toBinaryString(n2) + ")");
        System.out.println("Expected Output: " + expected2 + " (Binary: " + Integer.toBinaryString(expected2) + ")");
        System.out.println("Actual Output: " + reversed2 + " (Binary: " + Integer.toBinaryString(reversed2) + ")");
        System.out.println(reversed2 == expected2 ? "Success" : "Failure");
        System.out.println();
    }
}
