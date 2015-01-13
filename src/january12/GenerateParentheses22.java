package january12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Paul Qi
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        // () (()) ()()
    	// OPT(i) = "(" + OPT(j) + ")" + OPT(i-j-1) j<=i-1      
    	// lots of extra space
    	List<String>[] results = new List[n+1];
    	results[0] = Arrays.asList("");
    	for(int i=1; i<results.length; i++){
    		List<String> result = new ArrayList<String>();
    		for(int j=i-1; j>=0; j--){
    			for(String str: results[j]){
    				for(String tl: results[i-j-1]){
    					result.add("("+str+")"+tl);
    				}
    			}
    		}
    		results[i] = result;
    	}
    	return results[n];
    }
    
    public static void main(String[] s){
    	GenerateParentheses22 test = new GenerateParentheses22();
    	System.out.println(test.generateParenthesis(3).toString());
    }
}
