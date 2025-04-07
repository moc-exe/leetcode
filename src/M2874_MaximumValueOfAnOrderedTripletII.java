/* MEDIUM 2874. Maximum Value of an Ordered Triplet II
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/?envType=daily-question&envId=2025-04-06
 * 
 */

public class M2874_MaximumValueOfAnOrderedTripletII {
    
    public long maximumTripletValue(int[] nums) {
    
        int len = nums.length;

        int[] prefixArr = new int[len];
        int[] suffixArr = new int[len];

        int currMax = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            
            if(nums[i] > currMax){
                currMax = nums[i];
            }
            prefixArr[i] = currMax;
        }
        currMax = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            
            if(nums[i] > currMax){
                currMax = nums[i];
            }
            suffixArr[i] = currMax;
        }

        long out = Long.MIN_VALUE;
        for (int i = 1; i < len-1; i++) {
            
            long currTriplet = ((long) prefixArr[i-1] - nums[i] ) * suffixArr[i+1];
            out = Math.max(out, currTriplet);
        
        }

        return out >= 0 ? out : 0;
    }
}
