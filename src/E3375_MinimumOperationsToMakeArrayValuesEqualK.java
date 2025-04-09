/**
 * EASY 3375. Minimum Operations to Make Array Values Equal to K
 * https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09
 * 
 */

import java.util.HashSet;


public class E3375_MinimumOperationsToMakeArrayValuesEqualK{

    public int minOperations(int[] nums, int k){

        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
        
            if(nums[i] < k){return -1;}
            else if(nums[i] > k){
                set.add(nums[i]);
            }

        } 
        return set.size();
    }
    
}
