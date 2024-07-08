package algorithms_and_data_structures.binarytree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 */
public class MaximumPathSum {

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
    public int maxPathSum(TreeNode root){
          int[] maxSum = new int[]{Integer.MIN_VALUE};
          dfs(root, maxSum);
          return maxSum[0];
    }

    private int dfs(TreeNode node, int[] maxSum) {
          if(node == null){
              return 0;
          }
          int lefSum = Math.max(dfs(node.left, maxSum), 0);
          int rightSum = Math.max(dfs(node.right, maxSum), 0);
          maxSum[0] = Math.max(maxSum[0], lefSum + rightSum + node.val);

          return Math.max(rightSum,lefSum) + node.val;
    }
}

