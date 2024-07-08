package algorithms_and_data_structures.minimum_spanning_trees;

import java.util.Deque;
import java.util.LinkedList;

public class IsTreeSymmetric {
    /**
     * using recursive
     * @param root
     * @return
     */
    public boolean isSymmetric1(MaxDepthBinaryTree.TreeNode root) {
        return checkSymmmetry(root.left, root.right);
    }

    private boolean checkSymmmetry(MaxDepthBinaryTree.TreeNode left, MaxDepthBinaryTree.TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return ((left.val == right.val) &&
                checkSymmmetry(left.left, right.right) &&
                checkSymmmetry(left.right, right.left));
    }

    /**
     * iteratively
     * @param root
     * @return
     */
    public boolean isSymmetric2(MaxDepthBinaryTree.TreeNode root){
        Deque<MaxDepthBinaryTree.TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        deque.addFirst(root);

        while(!deque.isEmpty()){
            MaxDepthBinaryTree.TreeNode left = deque.pollFirst();
            MaxDepthBinaryTree.TreeNode right = deque.pollLast();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            deque.addFirst(left.right);
            deque.addLast(right.left);
            deque.addFirst(left.left);
            deque.addLast(right.right);
        }
        return true;
    }

}
