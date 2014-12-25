package dec25;

/**
 * @author Paul Qi
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

public class PalindromeNumber8 {
	
    public static boolean isPalindrome(int x) {
        
    	//negative integers cannot be palindromes
    	if(x<0){
        	return false;
        }
    	int result = 0;
    	int y = x;
    	while(y!=0){
    		// even overflow, it does not affect the result.
    		result = result*10 + y%10;
    		y = y/10;
    	}
    	return result == x;
    }
	
	public static void main(String[] args){
		System.out.println(isPalindrome(12));
	}
}
