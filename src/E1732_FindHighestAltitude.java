/*
 * EASY:1732. Find the Highest Altitude
 * https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * 
 */

public class E1732_FindHighestAltitude {
    
    
    public int largestAltitude(int[] gain) {
     
        int runSum = 0;
        int max = 0;

        for (int i = 0; i < gain.length; i++) {
            
            runSum += gain[i];
            max = Math.max(runSum, max);

        }

        return max;
    }
}
