/*
 * MEDIUM 2300. Successful Pairs of Spells and Potions
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

import java.util.Arrays;

public class M2300_SuccessfulPairsOfSpellsPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
     
        
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        
        for (int i = 0; i < pairs.length; i++) {

            int currSpell = spells[i];
            int target = (int) Math.ceil( (double) success / currSpell);
            int firstPotionIndex = lowerBoundBinarySearch(potions, target);
            if(firstPotionIndex == -1){
                pairs[i] = 0;
            }
            else{
                pairs[i] = potions.length - firstPotionIndex;
            }
        }

        return pairs;

    }
    public static int lowerBoundBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int result = -1; 

        while (left < right) {
            
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                result = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(lowerBoundBinarySearch(arr,50));

    }
    
}
