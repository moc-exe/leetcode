/*
 * EASY 1207. Unique Number of Occurrences
 * https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Arrays;
import java.util.HashMap;

public class E1207_UniqueNumberOfOccurences{
    
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            
            int token = arr[i];

            if(map.containsKey(token)){
                int curr = map.get(token);
                map.put(token, ++curr);
            }
            else{
                map.put(token, 1);
            }
        }

        int[] counts = new int[map.size()];

        int i = 0; 
        for (var elem : map.values()) {
            counts[i] = elem;
            i++;
        }
        Arrays.sort(counts);
        for (int j = 1; j < counts.length; j++) {
            
            if(counts[j-1] == counts[j]){
                return false;
            }
        }
        return true;
    }
}