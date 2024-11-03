/*
*********************************** DESCRIPTION ********************************
*****     796. Rotate String ---  Easy   ******************

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
*/

public class E796_RotateString {
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()){return false;}
        if(s.length() == 1){return s.equals(goal);}

        char[] tokens = s.toCharArray();

        for (int start = 0; start < tokens.length; start++) {
            
            if(check(tokens, start, goal)){return true;}


        }


    }

    public boolean check(char[] c, int start, String goal){

        for(int i = 0; i < goal.length(); i++){
            if(c[(start + i) % goal.length()] != goal.charAt(i)){
                return false;
            }
        }

        return true;


    }
}
