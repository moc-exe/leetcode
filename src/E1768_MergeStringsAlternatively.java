/*
 * EASY: 1768. Merge Strings Alternately
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class E1768_MergeStringsAlternatively {
    
    public String mergeAlternately(String word1, String word2) {
        

        char[] word_tokens_1 = word1.toCharArray();
        char[] word_tokens_2 = word2.toCharArray();
        int i = 0, j = 0;
        var sb = new StringBuilder();
        
        int turn = 0; 
        while(i < word_tokens_1.length && j < word_tokens_2.length){

            if(turn % 2 == 0){
                sb.append(word_tokens_1[i]);
                i++;
                turn++;
            }
            else{
                sb.append(word_tokens_2[j]);
                j++;
                turn++;
            }
        }

        while(i < word_tokens_1.length){
            sb.append(word_tokens_1[i]);
            i++;
        }

        while(j < word_tokens_2.length){
            sb.append(word_tokens_2[j]);
            j++;
        }

        return sb.toString();
    }
}
