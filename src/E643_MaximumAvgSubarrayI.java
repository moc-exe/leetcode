/*
 * EASY 643. Maximum Average Subarray I
 * https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * 
 */

public class E643_MaximumAvgSubarrayI{

    public double findMaxAverage(int[] nums, int k) {
        
        double currAvg = Double.MIN_VALUE;
        double currSum = 0;

        for (int i = 0; i < k; i++) {
            
            currSum += nums[i];

        }

        currAvg = currSum / k;

        for (int i = k; i < nums.length; i++) {
            
            currSum -= nums[i-k];
            currSum += nums[i];
            currAvg = Math.max(currAvg, currSum / k);
    
        }
        return currAvg;

    }


}