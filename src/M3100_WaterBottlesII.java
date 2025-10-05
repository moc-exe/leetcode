/*
    M3100 Water Bottles II
 * https://leetcode.com/problems/water-bottles-ii/submissions/1790503606/?envType=daily-question&envId=2025-10-03
 * 
 * 
 */

public class M3100_WaterBottlesII{

    class Solution {
        
        public int maxBottlesDrunk(int numBottles, int numExchange) {

            int fullBottles = numBottles;
            int emptyBottles = 0;
            int exchangeRate = numExchange;
            int drankCounter = 0;
            int[] temp;

            while(fullBottles > 0){

                drankCounter += fullBottles;
                emptyBottles += fullBottles;
                fullBottles = 0;
                temp = exchange(fullBottles, emptyBottles, exchangeRate);
                if(temp == null) break;
                fullBottles = temp[0];
                emptyBottles = temp[1];
                exchangeRate = temp[2];
            }
            
            return drankCounter;

        }
        
        public int[] exchange(int numFullBottles, int numEmptyBottles, int numExchange){

            if(numEmptyBottles < numExchange) return null;    
            int[] outArr = new int[3];
            
            outArr[1] = numEmptyBottles - numExchange;
            outArr[0] = numFullBottles+1;
            outArr[2] = numExchange+1;

            return outArr;

        }
    
    }


};
