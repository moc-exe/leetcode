/*
 * EASY: 1790. Check if One String Swap Can Make Strings Equal
 * Daily challenge
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/?envType=daily-question&envId=2025-02-05
 */

public class E1790_StringSwapCheck {
    public boolean areAlmostEqual(String s1, String s2) {
     
        if(s1.length() != s2.length()){
            return false;
        }

        char[] s1tokens = s1.toCharArray();
        char[] s2tokens = s2.toCharArray();
        
        int len = s2tokens.length;
        int errCounter = 0;
        int first = -1;
        int second = -1;

        for (int i = 0; i < len; i++) {
            
            if(s1tokens[i] != s2tokens[i]){

                errCounter++;
                
                if(errCounter == 1){
                    first = i;
                }
                else if(errCounter == 2){
                    second = i;
                }
                else{
                    return false;
                }

            }
        }
        if(errCounter == 0){return true;}
        else if(errCounter != 2){return false;}
        if(s1tokens[first] == s2tokens[second] && s1tokens[second] == s2tokens[first]){
            return true;
        }
        return false;
    }
}
