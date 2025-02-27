/*
 * EASY 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class E104_MaximumDepthBinaryTree {
    
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

    public int maxDepth(TreeNode root) {

        if (root == null){
 
             return 0;
 
        }
 
         int leftDepth = maxDepth(root.left);
         int rightDepth = maxDepth(root.right);
 
         return 1 + Math.max(leftDepth, rightDepth);
 
 
 
     }




}
