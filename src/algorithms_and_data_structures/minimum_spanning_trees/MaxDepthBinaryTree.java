package algorithms_and_data_structures.minimum_spanning_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * three ways to solve this (recursive, DFS, BFS)
 *
 * space O(n) and time O(n)
 */

public class MaxDepthBinaryTree {
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
     * using DPF (recursive)
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root){
        return (root == null)? 0: 1 + Math.max(maxDepth1(root.right), maxDepth1(root.left));
    }

    /**
     * using BFS (iterative)
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        treeNodeQueue.offer(root);
        int depth = 0;
        while(!treeNodeQueue.isEmpty()){
            int levelSize = treeNodeQueue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = treeNodeQueue.poll();
                if(node.left != null){
                    treeNodeQueue.offer(node.left);
                }if(node.right != null){
                    treeNodeQueue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth3(TreeNode root){
        if(root == null){
            return 0;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        nodeStack.push(root);
        int maxDepth = 0;
        depth.push(1);
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int dep = depth.pop();
            maxDepth = Math.max(maxDepth, dep);
            if(node.right != null){
                nodeStack.push(node.right);
                depth.push(dep + 1);
            }if(node.left != null){
                nodeStack.push(node.right);
                depth.push(dep + 1);
            }
        }

        return  maxDepth;
    }

}
