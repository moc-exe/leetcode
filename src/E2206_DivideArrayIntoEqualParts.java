/*
 * 
 * EASY 2206. Divide Array Into Equal Pairs
 * https://leetcode.com/problems/divide-array-into-equal-pairs/submissions/1599650801/?envType=daily-question&envId=2025-04-07
 */


import java.util.HashMap;

public class E2206_DivideArrayIntoEqualParts {
    public boolean divideArray(int[] nums) {
    
        if (nums.length % 2 != 0){return false;}

        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            
            int currVal = nums[i];

            if(!map.containsKey(currVal)){
                map.put(currVal, 1);
            }
            else{

                int currCount = map.get(currVal);
                map.put(currVal, currCount+1);
            }
        }

        for(var value : map.values()){

            if(value % 2 != 0){return false;}

        }

        return true;
    
    }
}
