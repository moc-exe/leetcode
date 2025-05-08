// MEDIUM 1922. Count Good Numbers
// https://leetcode.com/problems/count-good-numbers/description/?envType=daily-question&envId=2025-05-08

/**
 * @param {number} n
 * @return {number}
 */
function countGoodNumbers(n: number): number {
  
    const MOD:bigint = 10n**9n + 7n;
    let finalResult:number = 0;

    if(n % 2 == 0){
        // pair

        let pairCount:bigint = modExp(5n, BigInt(n / 2), MOD);
        let oddCount:bigint = modExp(4n, BigInt(n / 2), MOD);
        finalResult = Number(pairCount * oddCount % MOD);
    }
    else{
        // odd
        let pairCount:bigint = modExp(5n, BigInt((n-1)/2 + 1), MOD);
        let oddCount:bigint = modExp(4n, BigInt((n-1)/2), MOD);
        finalResult = Number(pairCount * oddCount % MOD);

    }

    return finalResult;
};

function modExp(base:bigint, exp:bigint, mod:bigint) : bigint{

    base =  base % mod;
    let result = 1n; 

    while(exp > 0n){

        if(exp % 2n == 1n){

            result = ( result * base ) % mod;
            exp -= 1n; 
        
        }

        base = ( base * base ) % mod;
        exp /= 2n; 
    }

    return result;
}