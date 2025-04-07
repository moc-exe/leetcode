/*
 * MEDIUM - 2140. Solving Questions With Brainpower
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/?envType=daily-question&envId=2025-04-06
 * 
 */

public class M2140_SolvingQuestionsWBrainpower{
    public long mostPoints(int[][] questions){
        
        int len = questions.length;
        long[] dp = new long[len+1];

        for (int i = len-1; i >= 0; i--){

            int nextIndex = i + questions[i][1]+1; 
            
            long solved = questions[i][0];
            if(nextIndex < len){

                solved += dp[nextIndex];
            
            }
            
            long notSolved = dp[i+1];

            dp[i] = Math.max(solved, notSolved);
        
        }

        return dp[0];

    }
    
}
