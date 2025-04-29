// MEDIUM 2799. Count Complete Subarrays in an Array
// https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/?envType=daily-question&envId=2025-04-28

var countCompleteSubarrays = function(nums) {
    let countSet = new Set();
    for (let elem of nums) {
        countSet.add(elem);
    }

    let countDistinct = countSet.size;
    let countArrays = 0;

    for (let left = 0; left < nums.length; left++) {
        let mainMap = new Map();
        let right = left;        

        while (right < nums.length) {
            if (mainMap.has(nums[right])) {
                mainMap.set(nums[right], mainMap.get(nums[right]) + 1);
            } 
            else {
                mainMap.set(nums[right], 1);
            }

            if (mainMap.size == countDistinct) {
                countArrays++;
            }

            right++;
        }
    
    
    }

    return countArrays;
};