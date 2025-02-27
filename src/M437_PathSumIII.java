/*
 * MEDIUM 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 *
 */

public class M437_PathSumIII {
    
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

    public int pathSum(TreeNode root, int targetSum) {
        
        counter = 0;

        traverse(root, targetSum);

        return counter;


    }

    public void traverse(TreeNode root, long targetSum){

        if(root == null){return;}

        findPaths(root, targetSum, 0);

        if(root.left != null){
            traverse(root.left, targetSum);
        }
        if(root.right != null){
            traverse(root.right, targetSum);
        }

    }

    public void findPaths(TreeNode root, long targetSum, long currSum){

        if(root == null){return;}

        currSum += root.val;
        if(currSum == targetSum){counter++;}
        if(root.left != null){
            findPaths(root.left, targetSum, currSum);
        }
        if(root.right != null){
            findPaths(root.right, targetSum, currSum);
        }

    }

    


}
