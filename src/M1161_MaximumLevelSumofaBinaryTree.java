
/*
 * MEDIUM 1161. Maximum Level Sum of a Binary Tree
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

import java.util.HashMap;

public class M1161_MaximumLevelSumofaBinaryTree {
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

    public int maxLevelSum(TreeNode root){

        HashMap<Integer, Integer> map = new HashMap<>();

        traverse(root, 1, map);

        int maxVal = Integer.MIN_VALUE;
        int minKey = 1;
        for(var entry : map.entrySet()){

            int currVal = entry.getValue();
            int currKey = entry.getKey();

            if(currVal > maxVal){

                maxVal = currVal;
                minKey = currKey;

            }
            else if(currVal == maxVal && currKey < minKey){
                minKey = currKey;
            }
        }

        return minKey;

    }

    public void traverse(TreeNode root, int currLevel, HashMap<Integer, Integer> map){

        if(root == null){return;}

        if(map.containsKey(currLevel)){
            var currVal = map.get(currLevel);
            currVal += root.val;
            map.put(currLevel, currVal);
        }
        else{
            map.put(currLevel, root.val);
        }

        if(root.left != null){
            traverse(root.left, currLevel+1, map);
        }
        if(root.right!= null){
            traverse(root.right, currLevel+1, map);
        }
    }
}
