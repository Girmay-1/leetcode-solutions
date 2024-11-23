package algorithms_and_data_structures.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 *
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of digits only.
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> solution = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12){
            return solution;
        }
        backTrack(0, 0, new StringBuilder(), s, solution);
        return solution;
    }

    private void backTrack(int index, int count, StringBuilder current, String s, List<String> solution) {
        if(count == 4 && index == s.length()){
            solution.add(current.toString());
        }
        if(count == 4 || index == s.length()){
            return;
        }
        for(int i = 1; i <= 3 && index + i <= s.length(); i++){ //length of the substring 1 ->3
            String part = s.substring(index, index + i);
            if(isValid(part)){
                int len = current.length();
                if(len > 0){
                    current.append(".");
                }
                current.append(part);
                backTrack(index + i, count + 1, current, s, solution);
                current.setLength(len);
            }
        }
    }
    private boolean isValid(String part){
        if(part.length() > 1 && part.charAt(0) == '0'){
            return false;
        }

        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }

    //time: 3 ^ N space: O(N)
    public static void main(String[] args) {
        RestoreIPAddress solution = new RestoreIPAddress();

        // Test cases
        String[] tests = {
                "25525511135",  // ["255.255.11.135", "255.255.111.35"]
                "0000",         // ["0.0.0.0"]
                "101023",       // ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
                "1111",         // ["1.1.1.1"]
                "010010",       // ["0.10.0.10","0.100.1.0"]
                "",            // []
                "1921680",     // ["1.92.168.0","19.2.168.0","19.21.68.0","19.216.8.0","192.1.68.0","192.16.8.0","192.168.0.0"]
        };

        // Run tests
        for (String test : tests) {
            System.out.println("\nInput: \"" + test + "\"");
            List<String> result = solution.restoreIpAddresses(test);
            System.out.println("Output: " + result);
            System.out.println("Number of valid IPs: " + result.size());
        }

        // Test specific cases
        testSpecificCase(solution, "25525511135",
                Arrays.asList("255.255.11.135", "255.255.111.35"));
    }

    private static void testSpecificCase(RestoreIPAddress solution,
                                         String input, List<String> expected) {
        System.out.println("\nTesting specific case:");
        System.out.println("Input: " + input);
        List<String> result = solution.restoreIpAddresses(input);
        System.out.println("Expected: " + expected);
        System.out.println("Got: " + result);
        System.out.println("Matches expected? " + result.containsAll(expected));
    }
}
