/*
 * MEDIUM 1657. Determine if Two Strings Are Close
 * https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

import java.util.Arrays;
import java.util.HashMap;

public class M1657_TwoStringsAreClose {
    
    public static boolean closeStrings(String word1, String word2) {
        
        if(word1.length() != word2.length()){return false;}
        
        var word_one_tokens = word1.toCharArray();
        var word_two_tokens = word2.toCharArray();
        var len = word_one_tokens.length;
        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();

        for (int i = 0; i < len; i++) {
            
            if(map1.containsKey(word_one_tokens[i])){

                var count = map1.get(word_one_tokens[i]);
                map1.put(word_one_tokens[i], ++count);

            }
            else{

                map1.put(word_one_tokens[i], 1);

            }
        }
        for (int i = 0; i < len; i++) {
            
            if(map2.containsKey(word_two_tokens[i])){

                var count = map2.get(word_two_tokens[i]);
                map2.put(word_two_tokens[i], ++count);

            }
            else{

                map2.put(word_two_tokens[i], 1);

            }
        }

        if(!map1.keySet().equals(map2.keySet())){
            return false;
        }
    
        int[] counts_one = new int[map1.keySet().size()];
        int[] counts_two = new int[map2.keySet().size()];

        int i = 0;
        for(var elem : map1.values()){
            counts_one[i] = elem;
            i++;
        }
        i=0;
        for(var elem : map2.values()){
            counts_two[i] = elem;
            i++;
        }
        Arrays.sort(counts_one);
        Arrays.sort(counts_two);
        for (int j = 0; j < map1.keySet().size(); j++) {
            
            if(counts_one[j] != counts_two[j]){return false;}

        }

        return true;

    }

    public static void main(String[] args) {
        
        var word1 = "cabbba";
        var word2 = "abbccc";

        closeStrings(word1, word2);

    }

    

}
