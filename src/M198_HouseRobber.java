/*
 * MEDIUM - HOUSE ROBBER 198
 * https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class M198_HouseRobber {

    public int rob(int[] nums){

        if (nums.length == 0){return 0;}
        
        int[] memo = new int[nums.length+1];
        memo[0] = 0; 
        memo[1] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(memo[i], nums[i] + memo[i-1]);
        }

        return memo[memo.length-1];

    }
    
}
