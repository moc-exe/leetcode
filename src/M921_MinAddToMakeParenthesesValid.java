/*

https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/?envType=daily-question&envId=2024-10-09
*********************************** DESCRIPTION ********************************
***********921. Minimum Add to Make Parentheses Valid***************************
************* Medium ***********************************************************

A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
 

Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.

*/

import java.util.Stack;

public class M921_MinAddToMakeParenthesesValid{
    

    public int minAddToMakeValid(String s) {
     
        char[] tokens = s.toCharArray();
        int len = tokens.length;
        Stack<Character> stack = new Stack<>();
        int minAddons = 0;

        for (int i = 0; i < len; i++) {
            
            var currToken = tokens[i];

            if(currToken == '('){
                stack.push(currToken);
            }
            else{ // meaning it's gonna be ')'

                if(stack.isEmpty()){
                    // no match... clearly we need to add a left parenthesis for it
                    minAddons++;
                }
                else{
                    stack.pop();
                }
            }
        }

        
        while(!stack.isEmpty()){ // meaning some left parentheses werent matched, we need to add an equal number of right ones
            stack.pop();
            minAddons++;
        }
        return minAddons;
    }


}