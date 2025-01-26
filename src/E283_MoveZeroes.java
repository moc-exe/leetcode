/*
 * EASY - 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class E283_MoveZeroes {
    
    public static void moveZeroes(int[] nums) {

        int i = 0, j = 0, count = 0;

        for (int k = 0; k < nums.length; k++) {
            if(nums[k] ==0){count++;}
        }

        for (i = 0; i < nums.length; i++) {
            
            if(nums[i] == 0){
                j = i;
                while(j < nums.length && nums[j] == 0){
                    j++;
                }
                if(j<nums.length && i < j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    j++;
                }
            }
        }
        for (int k = nums.length - count; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

    public static void main(String[] args){

        int[] arr = new int[]{1,0,1};
        moveZeroes(arr);
    }
}
