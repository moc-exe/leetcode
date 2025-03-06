/*
 * MEDIUM 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/1565023426/?envType=study-plan-v2&envId=leetcode-75
 */


import java.util.Collections;
import java.util.PriorityQueue;

public class M215_KthLargestInAnArray {

    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }


        int curr = -1;
        while(k > 0){
            curr = q.poll();
            k--;
        }
        return curr;
        

    }
    
}
