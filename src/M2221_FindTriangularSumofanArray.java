
class Solution {
    public int triangularSum(int[] nums) {
        
        int[] newNums = new int[nums.length];
        return triangularSumHelper(nums, nums.length, newNums);
    }

    private int triangularSumHelper(int[] nums, int currLen, int[] newNums){

        if(currLen == 1) return nums[0];
        for(int i = 0; i < currLen - 1; i++){
            newNums[i] = (nums[i] + nums[i+1]) % 10; 
        }
        return triangularSumHelper(newNums, currLen-1, nums);
    };

}