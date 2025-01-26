import java.util.ArrayList;
import java.util.HashMap;

/*
 * 
 * https://leetcode.com/problems/increasing-triplet-subsequence/submissions/1520574478/?envType=study-plan-v2&envId=leetcode-75
 * 334. Increasing Triplet Subsequence - MEDIUM
 */

public class M334_IncreasingTripletSubsequence{

    public boolean increasingTriplet(int[] nums) {

        if(nums.length < 3){return false;}

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // populate the map
        var max = Integer.MIN_VALUE;
        var min = Integer.MAX_VALUE;
        //var len = nums.length;
        
        // mins
        for (int i = 0; i < nums.length; i++) {
            
            min = (nums[i] < min) ? nums[i] : min;
            var temp_list = new ArrayList<Integer>();
            temp_list.add(min);
            map.put(i, temp_list);
        
        }

        // maxs
        for (int j = nums.length - 1; j >= 0; j--) {
            
            max = (nums[j] > max) ? nums[j] : max;
            map.get(j).add(max);
    
        }

        for (int i = 1; i < nums.length - 1; i++) {
            
            var left = map.get(i-1).get(0);
            var right = map.get(i+1).get(1);
            if(nums[i] > left && nums[i] < right){return true;}
        }

        return false;

    }


}