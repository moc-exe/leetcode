/*
 * EASY 3396. Minimum Number of Operations to Make Elements in Array Distinct
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-09
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class E3396_MinNumberOfOpsToMakeElementsDistinct {

    public int minimumOperations(int[] nums) {
     
        int len = nums.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> workingSet = new HashSet<>();
        boolean allDistinct = false;
        int turns = 0;


        for (int i = 0; i < len; i++){

            workingSet.add(nums[i]);
            q.add(nums[i]);

        }

        if(workingSet.size() == len){return turns;}

        while(!allDistinct){

            int count = 3;
            turns++;

            while(count > 0 && q.size() > 0){
            
                q.poll();
                count--;
            
            }

            workingSet = new HashSet<>();
            for(var elem : q){
                workingSet.add(elem);
            }

            if(workingSet.size() == q.size()){
                allDistinct = true;
            }
        
        }

        return turns;
        
    }
    
}
