package aNext.first.feb21.refer;

public class BestTimetoBuyandSellStock {
	
	/*
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	   If you were only permitted to complete at most one transaction 
	   (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	 */
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        // get the biggest difference
        int min = prices[0];
        int max = 0;    // at least I can buy and sell immediately
        for(int i=1; i<prices.length; i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else if(prices[i]-min>max){
                max = prices[i] - min;
            }
        }
        return max;
    }
    
    /*
     *  Say you have an array for which the ith element is the price of a given stock on day i.
		Design an algorithm to find the maximum profit. You may complete at most two transactions.
		
		Note:
		You may not engage in multiple transactions at the same time 
		(ie, you must sell the stock before you buy again).
     * 
     */
    /*
     * It's a great two way DP.
     */
    public int maxProfitIII(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int[] maxLeft = new int[prices.length];
        int min = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i]<min){
                maxLeft[i] = maxLeft[i-1];
                min = prices[i];
            }
            else{
                maxLeft[i] = Math.max(prices[i]-min,maxLeft[i-1]);
            }
        }
        int total = maxLeft[prices.length-1];
        
        int max = prices[prices.length-1];
        int[] maxRight = new int[prices.length];
        for(int i=prices.length-2; i>0; i--){
            if(prices[i]>max){
                max = prices[i];
                maxRight[i] = maxRight[i+1];
            }
            else{
                maxRight[i] = Math.max(max - prices[i],maxRight[i+1]);
            }
            
            if(maxRight[i]+maxLeft[i-1]>total){
                total = maxRight[i]+maxLeft[i-1];
            }
        }
        return total;
    }    
}

