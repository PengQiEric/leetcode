package aNext.first.feb21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PAUL QI
 * 
 *  Say you have an array for which the i th element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. You may complete at most k transactions.

	Note:
	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 
 */

public class BestTimetoBuyandSellStockIV188 {
	
	// why all my solution doesn't work, because I doesn't describe the problem in a right way.
	public int maxProfit_DP(int k, int[] prices){
		int len = prices.length;
        if (k > len / 2) return quickSolve(prices);

		int[][] result = new int[k+1][len];
		for(int i=1;i<=k; i++){
			int tmpMax = result[i-1][0] - prices[0];	// we buy at the begin
			for(int j=1; j<len; j++){
				result[i][j] = Math.max(result[i][j-1], tmpMax+prices[j]); // sell at j
				tmpMax = Math.max(tmpMax, result[i-1][j-1] - prices[j]);
			}
		}
		return result[k][len-1];
	}
	
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
	
	// time out O(N^4) time complexity
	public int maxProfit_DP_not_right_observation(int k, int[] prices){
		int[] result = new int[prices.length];
		int[] result1 = new int[prices.length];
		// base case
		int min = prices[0];
		for(int i=1; i<prices.length; i++){
			if(prices[i]<min){
				min = prices[i];
				result[i] = result[i-1];
			}
			else{
				result[i] = Math.max(prices[i]-min, result[i-1]);
			}
		}
		
		for(int i=2; i<k; i++){
			for(int j=1; j<prices.length; j++){
				for(int m=0; m<=j; m++){
					result1[j] = Math.max(result1[j], result[m]+getMax(prices, m, j));
				}
			}
			result = Arrays.copyOf(result1, result1.length);
			Arrays.fill(result1, 0);
		}
		int max = result[0];
		for(int i: result){
			if(max<i){
				max = i;
			}
		}
		return max;
	}
	
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	public int maxProfit(int k, int[] prices) {
    	return maxProfitHelper(k, prices, 0, prices.length-1);
    }

    private int maxProfitHelper(int k, int[] prices, int begin, int end){
    	if(k == 0){
    		return 0;
    	}
    	if(begin == end){
    		return 0;
    	}
    	if(begin == end-1){
    		return prices[end]>prices[begin]?prices[end]-prices[begin]:0;
    	}
    	int total = 0;
    	for(int i = begin; i<=end; i++){
    		int result;
    		if(map.containsKey(i+"#"+end)){
    			result = map.get(i+"#"+end);
    		}
    		else{
    			result = getMax(prices, i, end);
    		}
    		int before;
    		if(map.containsKey((k-1)+"#"+begin+"#"+i)){
    			before = map.get((k-1)+"#"+begin+"#"+i);
    		}
    		else{
    			before = maxProfitHelper(k-1, prices, begin, i);
    		}
    		total = Math.max(total, before + result);
    	}
    	map.put(k+"#"+begin+"#"+end, total);
    	return total;
    }
    
    private int getMax(int[] prices, int begin, int end){
    	int min = prices[begin];
    	int re = 0;
    	for(int i=begin+1; i<=end; i++){
    		if(min>prices[i]){
    			min = prices[i];
    		}
    		else{
    			re = Math.max(re, prices[i]-min);
    		}
    	}
    	map.put(begin+"#"+end, re);
    	return re;
    }
    
    public static void main(String[] args){
    	BestTimetoBuyandSellStockIV188 test = new BestTimetoBuyandSellStockIV188();
//    	System.out.println(test.maxProfit(1, new int[]{8, 11, 10, 12, 10, 15}));
    	System.out.println(test.maxProfit(11, new int[]{48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94}));
    	System.out.println(test.maxProfit_DP(11, new int[]{48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94}));
    }
}
