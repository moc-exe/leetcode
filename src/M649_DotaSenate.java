/*
 * MEDIUM 649. Dota2 Senate
 * https://leetcode.com/problems/dota2-senate/submissions/1553380673/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class M649_DotaSenate {
    public String predictPartyVictory(String senate) {
     
        char[] senators = senate.toCharArray();
        int currTurn = 0;
        int countR = 0; 
        int countD = 0; 
        int debtR = 0; 
        int debtD = 0;
        boolean winnerFound = false;

        // first scan to know how many we got of each fraction
        for (int i = 0; i < senators.length; i++) {
            
            char currSenator = senators[i];
            if(currSenator == 'R'){
                countR++;
            }
            else{countD++;}
        }
        while(!winnerFound){

            char currSenator = senators[currTurn];
            if(currSenator == 'X'){
                // then deactivated
            }
            else if(currSenator == 'R'){

                if(countD == 0){
                    // then victory
                    winnerFound = true;
                    return "Radiant";

                }
                else if(debtD > 0){

                    senators[currTurn] = 'X';
                    countR--;
                    debtD--;
                }
                else{

                    debtR++; 

                }
            }
            else{
                // then D 

                if(countR == 0){
                    // then victory
                    winnerFound = true;
                    return "Dire";

                }
                else if(debtR > 0){

                    senators[currTurn] = 'X';
                    countD--;
                    debtR--;
                }
                else{

                    debtD++; 

                }
            }

            currTurn++;
            if(currTurn >= senators.length){
                currTurn = 0;
            }

        }

        return null;
    }
    
}
