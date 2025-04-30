// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/?envType=daily-question&envId=2025-04-30
// EASY 1295. Find Numbers with Even Number of Digits

/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumbers = function(nums) {
    
    let count = 0;
    for(let elem of nums){

        if(elem.toString().split('').length % 2 == 0){
            count++;
        }

    }

    return count;

};