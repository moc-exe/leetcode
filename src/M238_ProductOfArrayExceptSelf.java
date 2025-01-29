/*
 * MEDIUM 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class M238_ProductOfArrayExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int l_running = 1;
        for (int i = 0; i < len; i++) {
            
            if(i == 0){
                left[i] = l_running;
            }
            else{
                l_running *= nums[i-1];
                left[i] = l_running;
            }
        }
        int r_running = 1;
        for (int i = len - 1; i >= 0; i--) {
            if(i == len - 1){
                right[i] = r_running;
            }
            else{
                r_running *= nums[i+1];
                right[i] = r_running;
            }

        }
        int[] out = new int[len];
        for (int i = 0; i < len; i++) {
            out[i] = left[i] * right[i];
        }
        return out;
        
    }

}
