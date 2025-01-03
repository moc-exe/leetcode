/*
 * rated as EASY, but i think it's medium - tier
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/submissions/1496755525/?envType=study-plan-v2&envId=leetcode-75
 */

public class E1071_GreatestCommonDivisorOfStrings {


    public String gcdOfStrings(String str1, String str2){

        char[] word1 = str1.toCharArray();
        char[] word2 = str2.toCharArray();
        int i = 0; 
        var sb = new StringBuilder();
        while(i < word1.length && i < word2.length && word1[i] == word2[i]){
            sb.append(word1[i]);
            i++;
        }
        
        String prefix = sb.toString();
        for (int j = prefix.length(); j >= 0; j--) {
            
            if(j == 0){return "";}

            if(divides(str1, prefix.substring(0, j)) && divides(str2, prefix.substring(0,j))){
                return prefix.substring(0, j);
            }
        

        }

        return "";


    }

    public static boolean divides(String s, String t) {

        if(t.length() < 1 || s.length() < 1){return false;}
        if (s.length() % t.length() != 0) {return false;}
    
        StringBuilder rep = new StringBuilder();
        int repCount = s.length() / t.length();
    
        for (int i = 0; i < repCount; i++) {
            rep.append(t);
        }

        return rep.toString().equals(s);
    }
}
