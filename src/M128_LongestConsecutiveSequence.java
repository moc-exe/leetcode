/*
https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
*********************************** DESCRIPTION ********************************
***********128. Longest Consecutive Sequence***************************
************* Medium ***********************************************************

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

import java.util.HashSet;

public class M128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int max = 0;


        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // find the entry sequence and check the length
        for (int i = 0; i < nums.length; i++) {
            
            // not a typo: if the set doesnt have the (value - 1) it means value is the start of a potential sequence 
            if(set.contains(nums[i]) && !set.contains(nums[i]-1)){

                var curr = nums[i];
                var count = 0;
                
                while(set.contains(curr)){
                    count++;
                    curr++;
                    max = (count > max) ? count : max;
                }
            }
        }
        return max;

    }
}
