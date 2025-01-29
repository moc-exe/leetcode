/* MEDIUM
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/1523912657/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class M1456_MaxNumVowelsSubstrGivenLen {
    
    public int maxVowels(String s, int k) {
       
        var tokens = s.toCharArray();
        int currMax = 0;
        int currCount = 0;
        for (int i = 0; i < k; i++) {
            
            if(isVowel(tokens[i])){
                currMax++;
            }
        }

        currCount = currMax;

        for (int i = k; i < tokens.length; i++) {
            
            if(isVowel(tokens[i-k])){
                currCount--;
            }
            if(isVowel(tokens[i])){
                currCount++;
            }

            currMax = Math.max(currCount, currMax);

        }

        return currMax;

    }

    public boolean isVowel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': 
                return true;
            default: return false;
        }
    }

    
}
