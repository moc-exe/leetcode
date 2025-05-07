// EASY 1920. Build Array from Permutation
// https://leetcode.com/problems/build-array-from-permutation/?envType=daily-question&envId=2025-05-07

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var buildArray = function(nums) {


    let arr = [];
    for (let i = 0; i < nums.length; i++){
        arr.push(nums[nums[i]]);
    }
    return arr;

};