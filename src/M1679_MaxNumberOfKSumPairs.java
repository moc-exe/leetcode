import java.util.Arrays;
import java.util.HashMap;

/*
 * MEDIUM 1679. Max Number of K-Sum Pairs
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 */


public class M1679_MaxNumberOfKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int opCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int currCount = map.get(nums[i]);
                map.put(nums[i],++currCount);
            }
            else{
                map.put(nums[i],1);
            }
        }

        Integer[] keys = (Integer[]) map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        
        // int mid = (keys.length % 2 == 0) ? keys.length / 2 : keys.length / 2 + 1; 
        // for (int i = 0; i <= mid; i++) {
            
        //     // special case
        //     if(keys[i] * 2 == k){

        //         // floor func we want here, so no prob
        //         opCount += (map.get(keys[i]) / 2);

        //     }
        //     else if(map.containsKey(k - keys[i])){

        //         opCount += Math.min(map.get(keys[i]), map.get(k - keys[i]));

        //     }

        // }

        for (int i = 0; i < keys.length; i++) {
            
            // special case
            if(keys[i] * 2 == k){

                // floor func we want here, so no prob
                opCount += (map.get(keys[i]));

            }
            else if(map.containsKey(k - keys[i])){

                opCount += Math.min(map.get(keys[i]), map.get(k - keys[i]));

            }

        }

        return opCount / 2;
        
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{3,1,3,4,3};
        System.out.println(maxOperations(arr, 6));

    }
}
