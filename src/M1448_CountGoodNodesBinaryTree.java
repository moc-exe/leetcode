/*
 * MEDIUM 1448. Count Good Nodes in Binary Tree
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class M1448_CountGoodNodesBinaryTree {
    
    public class TreeNode{
        
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

    static int counter = 0; 

    public int goodNodes(TreeNode root){
     
        // gotta be pre-order traversal is what i say lmaooo
        traverse(root, Integer.MIN_VALUE);
        int out = counter; 
        counter = 0; 
        return out;
    }

    public void traverse(TreeNode root, int currMax){

        if(root == null){return;}

        if(root.val >= currMax){
            counter++;
            currMax = root.val;
        }
        if(root.left != null){
            traverse(root.left, currMax);
        }
        if(root.right != null){
            traverse(root.right, currMax);
        }
    }




}
