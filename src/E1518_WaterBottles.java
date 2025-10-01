/*
 * E1518 Water Bottles
 * https://leetcode.com/problems/water-bottles/description/?envType=daily-question&envId=2025-10-01
 * 
 * 
 */
public class E1518_WaterBottles {
    
    public class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {

            boolean done = false;
            int drankCounter = 0;
            int currFull = numBottles;
            int currEmpty = 0;
            while(!done){

                drankCounter += currFull;
                currEmpty += currFull;
                currFull = 0;
                int[] exchangeResult = exchange(currEmpty, numExchange);
                currFull = exchangeResult[0];
                currEmpty = exchangeResult[1];

                if(currFull == 0) done = true;

            }

            return drankCounter;
        }

        private int[] exchange(int numEmpty, int numExchange){

            int[] out = new int[2];

            int full = Math.floorDiv(numEmpty, numExchange);
            int remaining = numEmpty % numExchange;

            out[0] = full; 
            out[1] = remaining;
            return out; 
        }
    
    }


}
