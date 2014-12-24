package Dec23;

/**
 * @author Paul Qi
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */

public class LongestPalindromicSubstring4 {
	public static void main(String[] args){
		System.out.println(longestPalindrome("aba"));
	}
	
	/*
	 * modify OPT_END(i);
	 * OPT(i) = MAX (OPT(i-1), OPT_END(i))
	 */
	//Run extending out of time
    public static String longestPalindrome(String s) {
    	class Palindrome{
    		int start; int end; int length;
    		Palindrome(int start, int end){
    			this.start = start; this.end = end; this.length = end-start+1;
    		}
    	}
    	
    	Palindrome[] opt = new Palindrome[s.length()];
    	opt[0] = new Palindrome(0,0);
    	Palindrome[] optEnd = new Palindrome[s.length()];
    	optEnd[0] = new Palindrome(0, 0);
    	
    	for(int i=1; i<s.length(); i++){
			
    		if((optEnd[i-1].start - 1) >0 && s.charAt(optEnd[i-1].start-1) == s.charAt(i)){
				optEnd[i] = new Palindrome(optEnd[i-1].start-1, i);
			}
    		else{
    			for(int k=optEnd[i-1].start; k<=i; k++){
    				int begin = k, end=i;
    				while(begin<end){
    					if(s.charAt(begin) == s.charAt(end)){
    						begin++; end--;
    					}
    					else{
    						break;
    					}
    				}
    				if(begin>=end){
    					optEnd[i] = new Palindrome(k, i);
    					break;
    				}
    			}
    		}
    		
    		if(optEnd[i].length > opt[i-1].length){
    			opt[i] = new Palindrome(optEnd[i].start, optEnd[i].end);
    		}
    		else{
    			opt[i] = new Palindrome(opt[i-1].start, opt[i-1].end);
    		}
    	}
    	return s.substring(opt[s.length()-1].start, opt[s.length()-1].end+1);
    }
}
