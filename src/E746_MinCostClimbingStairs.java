/*
 * EASY - 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/?envType=study-plan-v2&envId=leetcode-75
 */
public class E746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int dp[] = new int[cost.length+1];
        int len = cost.length;
        dp[len] = 0;
        dp[len-1] = cost[len-1];
        dp[len-2] = cost[len-2];

        if(len > 2){

            for (int i = len-3; i >= 0; i--) {
                dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
            }
        }

        return Math.min(dp[0],dp[1]);
        
    }
    
}
