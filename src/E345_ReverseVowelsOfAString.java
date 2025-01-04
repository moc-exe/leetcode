/*
 * well this one was fine
 * <EASY>
 * https://leetcode.com/problems/reverse-vowels-of-a-string/submissions/1496801881/?envType=study-plan-v2&envId=leetcode-75
 * 
*/

import java.util.ArrayList;
import java.util.Stack;

public class E345_ReverseVowelsOfAString {
    
    public String reverseVowels(String s) {

        char[] tokenz = s.toCharArray();
        var char_staccko = new Stack<Character>();
        var indexes = new ArrayList<Integer>();
        
        for (int i = 0; i < tokenz.length; i++){
            
            if(isVowel(tokenz[i])){

                char_staccko.push(tokenz[i]);
                indexes.add(i);
            
            }
        }

        for(var index : indexes){
            tokenz[index] = char_staccko.pop();
        }

        return String.valueOf(tokenz);


    }

    public boolean isVowel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            return true;
            default: return false;
        }
    }
}
