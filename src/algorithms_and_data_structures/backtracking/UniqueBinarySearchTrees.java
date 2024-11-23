package algorithms_and_data_structures.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */
public class UniqueBinarySearchTrees {

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

    public List<TreeNode> generateTrees(int n) {
          if(n <= 0)
              return new ArrayList<>();
          return generateTree(1, n);

    }

    private List<TreeNode> generateTree(int start, int end) {
          List<TreeNode> tree = new ArrayList<>();

          if(start > end){
              tree.add(null);
              return tree;
          }

          for(int i = start; i <= end; i++){
              List<TreeNode> leftTree = generateTree(start, i - 1);
              List<TreeNode> rightTree = generateTree(i + 1, end);

              for(TreeNode left: leftTree){
                  for(TreeNode right: rightTree){
                      TreeNode root = new TreeNode(i);
                      root.left = left;
                      root.right = right;
                      tree.add(root);
                  }
              }
          }
          return tree;

    }
    public static void main(String[] args) {
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();

        // Test cases
        int[] tests = {1, 2, 3};

        for (int n : tests) {
            System.out.println("\nTesting n = " + n);
            List<TreeNode> results = solution.generateTrees(n);
            System.out.println("Number of unique BSTs: " + results.size());

            System.out.println("Trees (preorder traversal):");
            for (TreeNode root : results) {
                solution.printTree(root);
                System.out.println();
            }
        }
    }
    // Helper method to print tree
    private void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
