/*
 * EASY - 1137. N-th Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75
 */

public class E1137_NthTribonacci {

    public int tribonacci(int n){
        
        if(n == 0){
            return 0;
        }
        else if(n == 1 || n == 2){
            return 1;
        }
        else{

            int[] numArray = new int[n+1];
            numArray[0] = 0;
            numArray[1] = 1;
            numArray[2] = 1;

            for (int i = 3; i < numArray.length; i++) {
                numArray[i] = numArray[i-1] + numArray[i-2] + numArray[i-3];
            }

            return numArray[n];

        }


    }    
}
