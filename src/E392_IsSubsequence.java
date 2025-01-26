/*
 * EASY 392 : Is Subsequence?
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class E392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length() > t.length()){return false;}

        char[] subseq_tokens = s.toCharArray();
        char[] main_tokens = t.toCharArray();
        
        int curr_token_index = 0;
        for (int i = 0; i < subseq_tokens.length; i++) {
            
            while(curr_token_index < main_tokens.length && main_tokens[curr_token_index] != subseq_tokens[i]){
                curr_token_index++;
            }
            if(curr_token_index >= main_tokens.length){
                return false;
            }
            curr_token_index++;

        }
        return true;


    }
    
}
