/* EASY - 2873. Maximum Value of an Ordered Triplet I
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/?envType=daily-question&envId=2025-04-06
 */

 public class E2873_MaximumValueOfAnOrderedTriplet{

    public long maximumTripletValue(int[] nums) {
        
        long maxTriplet = Long.MIN_VALUE;

        // we want maximal i, minimal j, maximal k

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    
                    long curr_i = nums[i];
                    long curr_j = nums[j];
                    long curr_k = nums[k];

                    maxTriplet = Math.max(maxTriplet, (curr_i - curr_j) * curr_k);

                }
            }
        }

        return maxTriplet >= 0 ? maxTriplet : 0;

    }
 }