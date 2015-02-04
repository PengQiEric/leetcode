package feb02_dp;

/**
 * @author PAUL QI
 * 
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

public class LongestPalindromicSubstring5 {
	
	// there are 2N-1 centers.   O(n^2) time O(1) space 
	public String longestPalindrome_center(String s){
		int start = 0, length = 1;
		
		for(int i=0; i<s.length()-1; i++){
			// check about the bound problem
			int j = i-1, k = i+1;
			while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)){
				j--;k++;
			}
			int len = k-j+1 - 2; // len-2;
			if(len>length){
				start = j+1;
				length = len;
			}
			j = i; k=i+1;
			while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)){
				j--;k++;
			}
			len = k-j+1 -2;
			if(len>length){
				start = j+1;
				length = len;
			}
		}
		return s.substring(start,start+length);
	}
	
	public static void main(String[] args){
		LongestPalindromicSubstring5 test = new LongestPalindromicSubstring5();
		System.out.println(test.longestPalindrome_center("aaaa"));
	}
	
	// it's two dimension DP, I have already done one dimension version yet. O(n^2) O(n^2) time & space
    public String longestPalindrome_DP(String s) {
    	boolean[][] result = new boolean[s.length()][s.length()];
    	int maxLen = 1;
    	int start = 0;
    	
    	for(int i=0; i<s.length(); i++){
    		result[i][i] = true;
    	}
    	
    	for(int i=0; i<s.length()-1; i++){
    		if(s.charAt(i) == s.charAt(i+1)){
    			maxLen = 2;
    			start = i;
    			result[i][i+1] = true;
    		}
    	}
    	
    	for(int l = 3; l<=s.length(); l++){	// ababab
    		for(int i = 0; i<=s.length()-l; i++){
    			int j = i+l-1;
    			if(s.charAt(i) == s.charAt(j) && result[i+1][j-1]){
					result[i][j] = true;
					maxLen = l;
					start = i;
    			}
    			else{
    				result[i][j] = false;
    			}
    		}
    	}
    	return s.substring(start, start+maxLen);
    }
}
