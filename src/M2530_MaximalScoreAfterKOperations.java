/*
*********************************** DESCRIPTION ********************************
*****     2530. Maximal Score After Applying K Operations   ******************
https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/?envType=daily-question&envId=2024-10-14

You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

In one operation:

choose an index i such that 0 <= i < nums.length,
increase your score by nums[i], and
replace nums[i] with ceil(nums[i] / 3).
Return the maximum possible score you can attain after applying exactly k operations.

The ceiling function ceil(val) is the least integer greater than or equal to val.

 

Example 1:

Input: nums = [10,10,10,10,10], k = 5
Output: 50
Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.
Example 2:

Input: nums = [1,10,3,3,3], k = 3
Output: 17
Explanation: You can do the following operations:
Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases by 3.
The final score is 10 + 4 + 3 = 17.
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class M2530_MaximalScoreAfterKOperations {
    public long maxKelements(int[] nums, int k) {
        
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        long sum = 0; 
        while(k > 0){
        
            var elem = pq.poll();
            if (elem == 1){break;} // means largest left in the collection is 1, therefore no need to waste cycles
            sum += elem;
            var newElem = (int) Math.ceil((double) elem / 3);
            pq.add(newElem);
            k--;
        }
        
        while(k > 0){
            sum++;
            k--;
        }

        return sum;

    }

}
