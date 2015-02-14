package aNext.first.feb14;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PAUL QI
 * 
 *  Given a string S and a string T, count the number of distinct subsequences of T in S.

	A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	
	Here is an example:
	S = "rabbbit", T = "rabbit"
	
	Return 3.
 */

public class DistinctSubsequences115 {
    public int numDistinct_DP(String S, String T) {
    	// actually we can change it to two one level array then make the space complexity to O(n)
    	// because we only use the results in the previous left and previous left down
    	
    	
    	int[][] results = new int[S.length()+1][T.length()+1];
    	
    	// base case
    	results[0][0] = 1;	// other one domain is 0 will always be 0;
    	// if T == ""
    	for(int i=0; i<=S.length(); i++){
    		results[i][0] = 1;
    	}
    	
    	for(int i=1; i<S.length()+1; i++){
    		for(int j=1; j<T.length()+1; j++){
    			if(S.charAt(i-1) == T.charAt(j-1)){
    				results[i][j] = results[i-1][j] + results[i-1][j-1];
    			}
    			else{
    				results[i][j] = results[i-1][j];
    			}
    		}
    	}
    	return results[S.length()][T.length()];
    }	
	// The biggest problem for recursive is java.lang.StackOverflowError
	Map<String, Integer> cache = new HashMap<String, Integer>();
    public int numDistinct(String S, String T) {
    	if(S.length()<T.length()){
    		return 0;
    	}
    	if(S.equals(T)){
    		return 1;
    	}
    	else if(S.isEmpty() || T.isEmpty()){
    		return 0;
    	}
    	int result = 0;
    	String sub1 = S.substring(1);
    	if(S.charAt(0) == T.charAt(0)){
    		String sub2 = T.substring(1);
    		if(cache.containsKey(sub1+"#"+sub2)){
    			result += cache.get(sub1+"#"+sub2);
    		}
    		else{
    			result += numDistinct(sub1, sub2);
    		}
    	}
    	if(cache.containsKey(sub1+"#"+T)){
    		result += cache.get(sub1+"#"+T);
    	}
    	else{
    		result += numDistinct(sub1, T);
    	}
    	cache.put(S+"#"+T, result);
    	return result;
    }
    
    public static void main(String[] args){
    	DistinctSubsequences115 test = new DistinctSubsequences115();
    	System.out.println(test.numDistinct_DP("rabbbit", "rabbit"));
    	System.out.println(test.numDistinct_DP("ccc", "c"));
    }
}
