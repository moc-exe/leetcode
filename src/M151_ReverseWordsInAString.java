/*
 * MEDIUM 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/submissions/1496881666/?envType=study-plan-v2&envId=leetcode-75
 * 
 * 
 */

public class M151_ReverseWordsInAString {
    public static String reverseWords(String s) {
        
        String[] input = s.trim().split(" ");
        StringBuilder out = new StringBuilder();
        for (int i = input.length - 1; i >= 0; i--){
            if(input[i].length() > 0){
                out.append(input[i].trim());
                if(i != 0){out.append(" ");}
            }
        }

        return out.toString();

    }
}
