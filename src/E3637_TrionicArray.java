//https://leetcode.com/problems/trionic-array-i/submissions/1907157942/?envType=daily-question&envId=2026-02-03
public class E3637_TrionicArray {

    public class Solution {
 
        public boolean isTrionic(int[] nums) {

             int idxP = -1;
            int idxQ = -1;
            int idxN = nums.length - 1;
            int currIdx = 0;

            for (int i = currIdx; i < nums.length; i++) {
                if (i + 1 == idxN) return false;
                if (nums[i + 1] > nums[i]) continue;

                idxP = i;
                currIdx = i; 
                break;
            }
            if (idxP <= 0) return false; 


            for (int i = currIdx; i < nums.length; i++) {
                if (i + 1 == idxN) {   
                    idxQ = i;
                    break;
                }
                if (nums[i + 1] < nums[i]) continue;

                idxQ = i;
                break;
            }
            if (idxQ == -1 || idxQ <= idxP) return false;
            if (idxQ >= idxN) return false;              


            for (int i = idxQ; i < nums.length - 1; i++) {
                if (nums[i + 1] > nums[i]) continue;
                return false;
            }

            return true;
        }
    
    }

}
