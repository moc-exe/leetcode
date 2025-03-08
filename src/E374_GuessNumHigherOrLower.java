/*
 * EASY 374. Guess Number Higher or Lower
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class E374_GuessNumHigherOrLower {
    
    public class Solution extends GuessGame {
        public int guessNumber(int n) {

            return binarySearch(0, n);

    
        }

        public int binarySearch(int low, int hi){

            if(hi >= low){

                int mid = low + (hi - low) / 2;
                int result = guess(mid);
                if(result < 0){
                    return binarySearch(low, mid-1);
                }
                else if(result > 0){
                    return binarySearch(mid+1, hi);
                }
                else{
                    return mid;
                }
            }
            return -1;    
        }
    }

}
