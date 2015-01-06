package jan5;

import java.util.Stack;

/**
 * @author Paul Qi
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class LongestValidParentheses32 {
	/*
	 * OPT_END(i) = OPT_END(i-1)+2 if S[i] == ')' && S[i-OPT_END(i-1)] == '('
	 *            = 0 if S[i] == '('
	 */
	// AMAZING!!! it is accepted!!!
    public int longestValidParentheses(String s) {
    	if(s.equals("")){
    		return 0;
    	}
    	
    	int[] opt = new int[s.length()];
    	int[] optEnd = new int[s.length()];
    	opt[0] = 0; optEnd[0] = 0;
    	
    	for(int i=1; i<opt.length; i++){
    		if(s.charAt(i) == ')' && i-optEnd[i-1]-1>=0 && s.charAt(i-optEnd[i-1]-1) == '('){
    			int val = i-optEnd[i-1]-2;
    			if(val>0){
        			optEnd[i] = optEnd[i-1]+2+optEnd[val];
    			}
    			else{
    				optEnd[i] = optEnd[i-1]+2;
    			}
    		}
    		else{
//    			s.charAt(i) == '('
    			optEnd[i] = 0;
    			/*Stack<Character> stack = new Stack<Character>();
    			stack.push(s.charAt(i));
    			int valid = 0,k;
    			for(k=i-1;k>=0; k--){
    				if(s.charAt(k) == '(' && stack.peek() == ')'){
    					valid += 2;
    					stack.pop();
    					if(stack.isEmpty()){
    						if(k-1>=0){
    							optEnd[i] = optEnd[k-1] + valid;
    						}
    						else{
    							optEnd[i] = valid;
    						}
    						break;
    					}
    				}
    				else{
    					stack.push(s.charAt(k));
    				}
    			}
//    			optEnd[i] = valid;
    			if(k<0){
    				optEnd[i] = 0;
    			}*/
    		}
    		opt[i] = Math.max(opt[i-1], optEnd[i]);
    	}    	
    	return opt[opt.length-1];
    }
    
    public static void main(String[] args){
    	LongestValidParentheses32 l = new LongestValidParentheses32();
//    	System.out.println(l.longestValidParentheses("(()()())"));
//    	System.out.println(l.longestValidParentheses("())"));
    	System.out.println(l.longestValidParentheses(")(())()"));
    }
}
