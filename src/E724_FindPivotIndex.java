/*
 * EASY 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class E724_FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        
        int[] leftSums = new int[nums.length];
        int[] rightSums = new int[nums.length];

        leftSums[0] = 0;
        int currSum = 0;
        for (int i = 1; i < nums.length; i++) {
            currSum += nums[i-1];
            leftSums[i] = currSum;
        }

        rightSums[nums.length - 1] = 0;
        currSum = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            currSum += nums[i+1];
            rightSums[i] = currSum;
        }

        for (int i = 0; i < nums.length; i++) {
            
            if(rightSums[i] == leftSums[i]){
                return i;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{1,7,3,6,5,6};

        System.out.println(pivotIndex(arr));

    }
}
