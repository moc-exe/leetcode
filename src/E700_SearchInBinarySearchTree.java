/*
 * 
 * EASY 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/?envType=study-plan-v2&envId=leetcode-75
 */



public class E700_SearchInBinarySearchTree {
    
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

    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null){return null;}

        if(val == root.val){return root;}
        else if(val < root.val){
            return searchBST(root.left, val);
        }
        else{
            return searchBST(root.right, val);
        }
    }

}
