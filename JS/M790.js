// MEDIUM : 790. Domino and Tromino Tiling
// https://leetcode.com/problems/domino-and-tromino-tiling/description/?envType=daily-question&envId=2025-05-05


/**
 * @param {number} n
 * @return {number}
 */
var numTilings = function countTiles(n){


    if(n==0){return 0;}
    if(n==1){return 1;}
    if(n==2){return 2;}

    const MOD = 1e9 + 7;
    let map = new Map();
    map.set(0,1);
    map.set(1,1);
    map.set(2,2);
    
    let currCounter = 3;
    while (currCounter <= n){
        let currVal = (2 * map.get(currCounter - 1) % MOD + map.get(currCounter - 3)) % MOD;
        map.set(currCounter, currVal);
        currCounter++;
    }

    return map.get(n);
};