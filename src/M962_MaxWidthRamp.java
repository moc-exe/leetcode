/*
*********************************** DESCRIPTION ********************************
***********962. Maximum Width Ramp***************************
************* Medium ***********************************************************
https://leetcode.com/problems/maximum-width-ramp/description/?envType=daily-question&envId=2024-10-10

A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.

 

Example 1:

Input: nums = [6,0,8,2,1,5]
Output: 4
Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
Example 2:

Input: nums = [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.
 

Constraints:

2 <= nums.length <= 5 * 104
0 <= nums[i] <= 5 * 104

*/

import java.util.Arrays;
import java.util.Comparator;

public class M962_MaxWidthRamp {
    
    // // allows duplicates
    // private static class Tree{

    //     private static class Node{

    //         private Node left;
    //         private Node right;
    //         private int val;
    //         private int occurence;
        
    //         public Node(Node l, Node r, int v){
    //             left = l;
    //             right = r;
    //             val = v;
    //             occurence = 0;
    //         }
    //         // default constructor
    //         public Node(int v){this(null, null, v);}
    //     }

    //     private Node root;

    //     public Tree(){
    //         root = null;
    //     }

    //     private int maxHeight(Node root){

    //         if(root == null){return 0;}
    //         int leftH = maxHeight(root.left);
    //         int rightH = maxHeight(root.right);
    //         return 1 + root.occurence + Math.max(leftH, rightH);

    //     }
    //     private Node add(Node root, int i){

    //         if(root == null){return new Node(i);}
    //         if(root.val == i){
    //             root.occurence++;
    //         }
    //         else if(root.val > i){
    //             root.left = add(root.left, i);
    //         }
    //         else{ // < i 
    //             root.right = add(root.right, i);
    //         }
    //         return root;
    //     }
    //     private void add(int i){

    //         root = add(root, i);

    //     }
    // }


    // public static int maxWidthRamp(int[] nums) {
        
    //     if (nums.length <= 1){return 0;}
        
    //     Tree tree = new Tree(); 

    //     // this is nlog(n)
    //     for (int i : nums) {
    //         tree.add(i);
    //     }

    //     var left = tree.maxHeight(tree.root.left);
    //     var right = tree.maxHeight(tree.root.right);
    //     return left + right;
    // }

    // public static void main(String[] args) {
        
    //     int[] nums = new int[]{9,8,1,0,1,9,4,0,4,1};

    //     System.out.println(maxWidthRamp(nums));

    // }


    
    public int maxWidthRamp(int[] nums) {
    
    
        //

        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                if (nums[index1] < nums[index2]) {
                    return -1;
                } else if (nums[index1] == (nums[index2])) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        int minIndex = Integer.MAX_VALUE;
        int maxSpan = 0;

        for (int index : indices) {
            maxSpan = Math.max(maxSpan, index - minIndex);
            minIndex = Math.min(minIndex, index);
        }

        return maxSpan;

    }



}

