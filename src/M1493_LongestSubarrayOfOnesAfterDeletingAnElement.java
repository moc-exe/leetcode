/*
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/submissions/1524954128/?envType=study-plan-v2&envId=leetcode-75
 * MEDIUM - 1493. Longest Subarray of 1's After Deleting One Element
 * 
 */


public class M1493_LongestSubarrayOfOnesAfterDeletingAnElement {
    
    public static int longestSubarray(int[] nums) {
        
        int currLen = 0;
        int max = 0;
        boolean zeroEncountered = false;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == 1){
                currLen++;
            }
            else if(nums[i] == 0 && !zeroEncountered){

                zeroEncountered = true;

            }
            else{
                // zero encountered and we encounter another one

                int startIndex = i - currLen - 1;
                if(nums[startIndex] == 0){

                    while(startIndex < i && nums[startIndex] != 1){
                        startIndex++;
                    }

                }
                else{ // means nums[startIndex] = 1

                    while(startIndex < i && nums[startIndex] != 0){
                        startIndex++;
                    }
                    if(startIndex != i){
                        startIndex++;
                    }

                }
                
                
                currLen = i - startIndex;
                
            }

            max = (zeroEncountered ? Math.max(max, currLen) : Math.max(max, currLen - 1));

        }

        return max;

    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(arr));
    }


}
