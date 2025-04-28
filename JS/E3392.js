// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/?envType=daily-question&envId=2025-04-28
// EASY 3392. Count Subarrays of Length Three With a Condition

/**
 * @param {number[]} nums
 * @return {number}
 */
var countSubarrays = function(nums) {
    
    let count = 0;
    for(let i = 1; i < nums.length - 1; i++){

        if(nums[i-1] + nums[i+1] == nums[i] / 2){
            count++;
        }
    }
    return count;
};