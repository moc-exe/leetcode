/*
*********************************** DESCRIPTION ********************************
*****     1405. Longest Happy String   ******************
https://leetcode.com/problems/longest-happy-string/?envType=daily-question&envId=2024-10-16

A string s is called happy if it satisfies the following conditions:

s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It is the only correct answer in this case.
 

Constraints:

0 <= a, b, c <= 100
a + b + c > 0

*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class M1405_LongestHappyStr {
    
    private static class Pair{
        private int count; 
        private char c;
        Pair(int n, char c){this.count = n; this.c = c;}
    }

    public static String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {return (-1) * Integer.compare(p1.count, p2.count);}
        });

        StringBuilder sb = new StringBuilder();

        if(a > 0){pq.add(new Pair(a, 'a'));}
        if(b > 0){pq.add(new Pair(b, 'b'));}
        if(c > 0){pq.add(new Pair(c, 'c'));}
        
        int currCount = 0;
        char prevChar = pq.peek().c;
        boolean done = false;
        while(!done){

            if(pq.isEmpty()){done = true; break;}
            if(pq.peek().c == prevChar){

                if(currCount < 2){
                    // then no problem
                    var token = pq.poll();
                    sb.append(token.c);
                    token.count--;
                    if(token.count > 0){pq.add(token);}
                    prevChar = token.c;
                    currCount++;

                }
                else{
                    // else need next in line and switch the prevChar and nullify the count
                    var token1 = pq.poll(); 
                    if(pq.isEmpty()){done = true; break;}
                    var token2 = pq.poll();
                    token2.count--;
                    sb.append(token2.c);
                    prevChar = token2.c;
                    currCount = 1; 
                    pq.add(token1);
                    if(token2.count > 0){pq.add(token2);}

                }
            }
            else{

                var token = pq.poll(); 
                prevChar = token.c;
                currCount = 1;
                token.count--;
                sb.append(token.c);
                if(token.count > 0){pq.add(token);}
            }
        }

        return sb.toString();
    }
}
