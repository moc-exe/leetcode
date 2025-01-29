/*
 * Medium 1004. Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */


public class M1004_MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {

        int currMax = 0;
        int finalMax = 0;
        int seqStart = 0;
        int flipsLeft = k; 

        for (int i = 0; i < nums.length; i++){
            
            if(nums[i] == 1){
                currMax++;
            }
            else if(nums[i] == 0 && flipsLeft > 0){

                currMax++;
                flipsLeft--;
                
            
            }
            else{

                if(nums[seqStart] == 0){

                    seqStart++;
                    /*
                     * currMax++;
                     * currMax--;
                     * flipsLeft++;
                     * flipsLeft--;
                     * nothing happens because we flipped back 1 at start and flipped new 0 at end
                     */

                }
                else{

                    while(nums[seqStart] == 1){
                        seqStart++;
                        currMax--;
                    }
                    seqStart++;
                    /*
                     * currMax++;
                     * currMax--;
                     * flipsLeft++;
                     * flipsLeft--;
                     * nothing happens because we flipped back 1 at start and flipped new 0 at end
                     */

                }
            }

            finalMax = Math.max(currMax, finalMax);

        }
        return finalMax;
        
        
    }
}
