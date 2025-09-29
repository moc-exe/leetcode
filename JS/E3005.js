/**
 * @param {number[]} nums
 * @return {number}
 */
var maxFrequencyElements = function(nums) {
    
    let frequencyMap = new globalThis.Map();

    for(let num of nums){

        if(frequencyMap.has(num)){
            let count = frequencyMap.get(num);
            frequencyMap.set(num, ++count);
        }
        else{
            frequencyMap.set(num, 1);
        }
    }

    let maxCount = 0;
    for(let [k,v] of frequencyMap.entries()){
        maxCount = Math.max(maxCount, v);
    }

    let totalKeysWithMaxCount = 0;
    for(let [k,v] of frequencyMap.entries()){
        if(v === maxCount){totalKeysWithMaxCount += v;}
    }

    return totalKeysWithMaxCount;
};

