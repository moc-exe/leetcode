public class App {
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int currMax = 0;
        for (int i = 1; i < prices.length; i++) {
            
            if(prices[i] < min){
                min = prices[i];
            }
            currMax = Math.max(currMax, prices[i] - min);
            

        }
        return currMax;

        
    }
}
