package january26;

/**
 * @author PAUL QI
 * 
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

	Return the minimum cuts needed for a palindrome partitioning of s.
	
	For example, given s = "aab",
	Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

public class PalindromePartitioningII132 {
	// FOR DP, I think the most important thing is what you should calculate.
    public int minCut(String s) {	 // test case dde
    	int[] opt = new int[s.length()];
    	for(int i=0; i<s.length(); i++){
    		opt[i] = i;
    	}
    	
    	boolean[][] isPalind = new boolean[s.length()][s.length()];
    	for(int i=1; i<opt.length; i++){
    		for(int j=i; j>=0; j--){
    			if(s.charAt(i) == s.charAt(j) && (i-j<=2 || isPalind[j+1][i-1])){
    				isPalind[j][i] = true;
    			}
    			if(isPalind[j][i]){
    				if(j != 0){
    					opt[i] = Math.min(opt[i], opt[j-1]+1); // test case cdd
    				}
    				else{
    					opt[i] = 0;
    				}
    			}
    		}
    	}
    	return opt[s.length()-1];
    }
    
    public static void main(String[] args){
    	PalindromePartitioningII132 test = new PalindromePartitioningII132();
    	System.out.println(test.minCut("a"));
    	System.out.println(test.minCut("aaabaa"));
    }
}
