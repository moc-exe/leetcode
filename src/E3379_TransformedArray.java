// https://leetcode.com/problems/transformed-array/submissions/1910801296/?envType=daily-question&envId=2026-02-07
public class E3379_TransformedArray{

    public int[] constructTransformedArray(int[] nums) {
     

        int len = nums.length;
        int[] out = new int[len];

        for (int i = 0; i < nums.length; i++) {
            
            int currElem = nums[i];

            if(currElem  > 0){

                int pos = (i + currElem) % len;
                out[i] = nums[pos];
            
            }
            else if (currElem < 0){

                // to achieve mathematical behavior (positive remainder), use: (value % modulus + modulus) % modulus -- sure will do
                int pos = ((i - Math.abs(nums[i])) % len + len) % len;
                out[i] = nums[pos]; 
            }
            else{ // == 0 
            
                out[i] = currElem;
            
            }
        }
        return out;
    }


};