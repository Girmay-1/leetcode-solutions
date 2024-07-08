package algorithms_and_data_structures.minimum_spanning_trees;

/**
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxSum(root, maxSum);
        return maxSum[0];
    }
      public int maxSum(TreeNode node, int[] sum){
        if(node == null){
            return 0;
        }

        int leftSum = Math.max(maxSum(node.left, sum), 0);
        int rightSum = Math.max(maxSum(node.right, sum), 0);

        sum[0] = Math.max(sum[0], leftSum + rightSum + node.val);


        return Math.max(leftSum, rightSum) + node.val;
      }
    }




