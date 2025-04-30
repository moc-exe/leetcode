// Medium 2649. Nested Array Generator
// https://leetcode.com/problems/nested-array-generator/description/


/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    
    let traversedArr = dive([], arr);

    for(let elem of traversedArr){
        yield elem;
    }

};

var dive = function dive(mainArr, currArr){

    if(currArr.length == 0){
        return mainArr;
    }

    for(let elem of currArr){

        if(Array.isArray(elem)){
            dive(mainArr, elem);
        }
        else{
            mainArr.push(elem);
        }
    }
    return mainArr;
}

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */