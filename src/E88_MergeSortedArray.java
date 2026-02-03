/*
 * https://leetcode.com/problems/merge-sorted-array/submissions/1788606088/?envType=study-plan-v2&envId=top-interview-150
 * 
 */

public class E88_MergeSortedArray {

    public class Solution {
        
        public void merge(int[] nums1, int m, int[] nums2, int n){

            int[] outArr = new int[n+m];
            int len = n +m;
            int i= 0, j = 0, k =0;
            while(i < m && j < n){

                if(nums1[i] <= nums2[j]){
                    outArr[k] = nums1[i];
                    i++;
                }
                else{
                    outArr[k] = nums2[j];
                    j++;
                }
                k++;
            }
            while(i < m){

                outArr[k] = nums1[i];
                i++;
                k++;

            }
            while (j < n) {
                outArr[k] = nums2[j];
                j++;
                k++;
            }

            for(int index = 0; index < len; index++){
                nums1[index] = outArr[index];
            }
        }


    }
    
}
