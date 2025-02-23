/*
 * 
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

import java.util.Stack;

public class M394_DecodeString {
    public static String decodeString(String s){

        char[] tokens = s.toCharArray();
        int len = tokens.length;
        Stack<Character> stack = new Stack<>();
        StringBuilder expressionBuilder = new StringBuilder();
        StringBuilder numBuilder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            
            char currToken = tokens[i];

            if (currToken == ']'){

                while(!stack.isEmpty() && stack.peek() != '['){
                    expressionBuilder.append(stack.pop());
                }

                stack.pop(); // get rid of the '['

                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    numBuilder.append(stack.pop());
                }
                
                if(numBuilder.length() > 0){
                    int multiplicationFactor = Integer.parseInt(numBuilder.reverse().toString());
                    expressionBuilder.reverse().repeat(expressionBuilder, multiplicationFactor - 1);
                }
                else{
                    expressionBuilder.reverse();
                }
                
                
                char[] processedTokens = expressionBuilder.toString().toCharArray();
                for(var processedToken : processedTokens){
                    stack.push(processedToken);
                }

                numBuilder.setLength(0);
                expressionBuilder.setLength(0);


            }
            else{   stack.push(currToken);  }
        }

        StringBuilder outBuilder = new StringBuilder();
        while(!stack.isEmpty()){

            outBuilder.append(stack.pop());
        }

        return outBuilder.reverse().toString();

    }

    public static void main(String[] args) {
        
        String test = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(decodeString(test));

    }


}
