/*
 * https://leetcode.com/problems/removing-stars-from-a-string/submissions/1552027861/?envType=study-plan-v2&envId=leetcode-75
 * MEDIUM 2390. Removing Stars From a String
 * 
*/

import java.util.Stack;

public class M2390_RemovingStarsFromString {
    public String removeStars(String s) {
        
        char[] tokenz = s.toCharArray();
        Stack<Character> staccko = new Stack<>();

        for (int i = 0; i < tokenz.length; i++) {
            
            char currToken = tokenz[i];
            if (currToken == '*' && !staccko.isEmpty()){
                staccko.pop();
            }
            else{

                staccko.push(currToken);
            }

        }

        Character[] arr = staccko.toArray(new Character[0]);
        var sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();

    }
    
}
