package algorithms_and_data_structures.minimum_spanning_trees;

import java.util.Stack;

public class CountNodes {
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
    /**
     * recursively
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root){
        return dfs(root);
    }
    private int dfs(TreeNode node) {
        if(node == null){
            return 0;
        }
        int right = dfs(node.right);
        int left = dfs(node.left);
        return  right + left + 1;
    }

    /**
     * interatively
     * @param root
     * @return
     */
    public int coutnNodes2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        if(root == null){
            return 0;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            count++;
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountNodes countNodes = new CountNodes();

    }
}

