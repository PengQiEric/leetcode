package aNext.first.feb12;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author PAUL QI
 *  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

	You have the following 3 operations permitted on a word:
	
	a) Insert a character
	b) Delete a character
	c) Replace a character
 */

public class EditDistance72 {
	/*
	 *  If all subproblems must be solved at least once, a bottom-up dynamic-programming 
	 *  algorithm usually outperforms a top-down memoized algorithm by a constant factor
	    No overhead for recursion and less overhead for maintaining table

		There are some problems for which the regular pattern of table accesses 
		in the dynamic-programming algorithm can be exploited to reduce the time or space requirements even further
		If some subproblems in the subproblem space need not be solved at all, 
		the memoized solution has the advantage of solving only those subproblems that are definitely required
	 */
	
	// downside of dynamice programming is that you have to come up with an ordering.
	public int minDistance_recursive(String word1, String word2){
		int[][] result = new int[word1.length()+1][word2.length()+1];
		// base case
		for(int i=0; i<result[0].length; i++){
			result[0][i] = i;
		}
		
		for(int i=0; i<result.length; i++){
			result[i][0] = i;
		}
		
		for(int i=1; i<=word1.length();i++){
			for(int j=1; j<=word2.length(); j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					result[i][j] = result[i-1][j-1]; 
				}
				else{
					result[i][j] = 1+ Math.min(result[i-1][j], Math.min(result[i][j-1], result[i-1][j-1]));
				}
			}
		}
		return result[word1.length()][word2.length()];
	}
	
	// up - bottom with cache
	Map<String, Integer> cache = new HashMap<String,Integer>();
    public int minDistance(String word1, String word2) {
    	if(word1.isEmpty()){
    		return word2.length();
    	}
    	
    	if(word2.isEmpty()){
    		return word1.length();
    	}
    	
    	if(word1.charAt(0) == word2.charAt(0)){
    		String sub1 = word1.substring(1);
    		String sub2 = word2.substring(1);
    		int re = 0;
    		if(cache.containsKey(sub1+"#"+sub2)){
    			re = cache.get(sub1+"#"+sub2);
    		}
    		else{
    			re = minDistance(sub1, sub2);
    		}
    		cache.put(word1+"#"+word2, re);
			cache.put(word2+"#"+word1, re);
			return re;
    	}
    	else{
    		String sub1 = word1.substring(1);
    		String sub2 = word2.substring(1);
    		int re = 0;
    		if(cache.containsKey(sub1+"#"+word2)){
    			re = cache.get(sub1+"#"+word2);
    		}
    		else{
    			re = minDistance(sub1, word2);
    		}
    		
    		if(cache.containsKey(word1+"#"+sub2)){
    			re = Math.min(re, cache.get(word1+"#"+sub2));
    		}
    		else{
    			re = Math.min(re, minDistance(sub2, word1));
    		}
    		
    		if(cache.containsKey(sub1+"#"+sub2)){
    			re = Math.min(re, cache.get(sub1+"#"+sub2));
    		}
    		else{
    			re = Math.min(re, minDistance(sub1, sub2));
    		}
    		cache.put(word1+"#"+word2, re+1);
			cache.put(word2+"#"+word1, re+1);
			return re+1;
//    		return 1+Math.min(minDistance(word1.substring(1), word2) // delete one character of word1 or insert one character of word2 
//    				, Math.min(minDistance(word1,word2.substring(1)) // delete one character of word2 or insert one character of word1
//    						, minDistance(word1.substring(1), word2.substring(1)))); // replace
    	}
    }
    
    public static void main(String[] args){
    	EditDistance72 test = new EditDistance72();
    	System.out.println(test.minDistance("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef", "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"));
    	System.out.println(test.minDistance_recursive("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef", "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"));
    }
}
