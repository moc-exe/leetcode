/*
 * EASY 872: 872. Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.ArrayList;

public class E872_LeafSimilarTrees {
    
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        ArrayList<Integer> treeList1 = new ArrayList<>();
        ArrayList<Integer> treeList2 = new ArrayList<>();

        traverse(root1, treeList1);
        traverse(root2, treeList2);
        
        return treeList1.equals(treeList2) ? true : false;

    }

    public void traverse(TreeNode root, ArrayList<Integer> list){

        if(root.left != null){

            traverse(root.left, list);

        }
        if(root.right != null){
            
            traverse(root.right, list);
        }
        if(root.right == null && root.left == null){
            // both are null, it's a leaf
            list.add(root.val);
        }
    }







}
