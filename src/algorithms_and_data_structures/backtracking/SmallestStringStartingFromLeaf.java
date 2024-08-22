package algorithms_and_data_structures.backtracking;

/**
 * You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
 *
 * Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 *
 * As a reminder, any shorter prefix of a string is lexicographically smaller.
 *
 * For example, "ab" is lexicographically smaller than "aba".
 * A leaf of a node is a node that has no children.
 *
 *
 */



public class SmallestStringStartingFromLeaf {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    String smallest = "~";
    public String smallestFromLeaf(TreeNode root) {
        if(root == null){
            return null;
        }

        dfs(root, new StringBuilder());
        return smallest;
    }
    private void dfs(TreeNode node, StringBuilder sb){
        if(node == null){
            return;
        }

        sb.insert(0, (char)('a' + node.val));
        if(node.left == null && node.right == null){
            String currentString = sb.toString();
            if(currentString.compareTo(smallest) < 0){
                smallest = currentString;
            }
        }else{
            dfs(node.left, sb);
            dfs(node.right, sb);

        }

        sb.deleteCharAt(0);
    }

    //time : O(n) and space: O(n)

    public static void main(String[] args) {
        SmallestStringStartingFromLeaf solution = new SmallestStringStartingFromLeaf();

        // Create the tree: [0, 1, 2, 3, 4, 3, 4]
        // Tree representation:
        //       0
        //      / \
        //     1   2
        //    / \ / \
        //   3  4 3  4
        TreeNode root = solution.new TreeNode(0);
        root.left = solution.new TreeNode(1);
        root.right = solution.new TreeNode(2);
        root.left.left = solution.new TreeNode(3);
        root.left.right = solution.new TreeNode(4);
        root.right.left = solution.new TreeNode(3);
        root.right.right = solution.new TreeNode(4);

        // Call the method and print the result
        String result = solution.smallestFromLeaf(root);
        System.out.println("The lexicographically smallest string from leaf to root is: " + result);

        // Expected output: "dba"
    }

}
