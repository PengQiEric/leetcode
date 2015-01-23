package january22;

/**
 * @author PAUL QI
 *
 *  Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

	Below is one possible representation of s1 = "great":
	
	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
	To scramble the string, we may choose any non-leaf node and swap its two children.
	
	For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
	
	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t
	We say that "rgeat" is a scrambled string of "great".
	
	Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
	
	    rgtae
	   /    \
	  rg    tae
	 / \    /  \
	r   g  ta  e
	       / \
	      t   a
	We say that "rgtae" is a scrambled string of "great".
	
	Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
	
 */

public class ScrambleString87_invalid {
	
	
    
    public static void main(String[] args){
//    	ScrambleString87 test = new ScrambleString87();
//    	System.out.println(test.isScramble("great", "rgaet"));
//    	System.out.println(test.isScramble("abb", "bab"));
//    	System.out.println(test.isScramble("abc", "bac"));
//    	System.out.println(test.isScramble("abc", "cab"));
    }
    
	/*	// it recommends dynamic programming, but dynamic what? 
	 * This is totally wrong, because it may not divide by average.
    public boolean isScramble(String s1, String s2) {
    	if(s1.equals(s2)){
    		return true;
    	}
    	
    	if(s1.length() == 1){
    		if(s1.charAt(0) == s2.charAt(0)){
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    	if(s1.length() == 2){
    		if(s1.charAt(0) == s2.charAt(0)&& s1.charAt(1) == s2.charAt(1)){
    			return true;
    		}
    		if(s1.charAt(1) == s2.charAt(0) && s1.charAt(0) == s2.charAt(1)){
    			return true;
    		}
    		return false;
    	}
    	
    	
    	int length = s1.length();
    	int index = s2.indexOf(s1.charAt(0));
    	// may not have one binary tree for even number like abb
    	
			 abb        abb
			 / \        / \
			a   bb     ab  b
    	 
    	boolean result;
    	if(index>length/2-1){
    		result = isScramble(s1.substring(0,length/2), s2.substring(length-length/2,length))
    							&& isScramble(s1.substring(length/2), s2.substring(0, length-length/2));
    		if(length%2!=0){	// test case : abb bab TRUE
        		result = result ||
    					(isScramble(s1.substring(0,length/2+1), s2.substring(length-length/2-1,length))
    					&& isScramble(s1.substring(length/2+1), s2.substring(0, length-length/2-1)));
    		}
    	}
    	else{
    		result = isScramble(s1.substring(0,length/2),s2.substring(0,length/2))
    				&& isScramble(s1.substring(length/2), s2.substring(length/2));
    		if(length%2!=0){
    			result = result ||
    					(isScramble(s1.substring(0,length/2+1),s2.substring(0,length/2+1))
        				&& isScramble(s1.substring(length/2+1), s2.substring(length/2+1)));
    		}
    	}
    	if(index>length/2){ // test case "abc" "bac" TRUE
    		result = result ||
					(isScramble(s1.substring(0,length/2+1), s2.substring(length-length/2-1,length))
					&& isScramble(s1.substring(length/2+1), s2.substring(0, length-length/2-1)));
    	}
    	else{
    		result = result ||
					(isScramble(s1.substring(0,length/2+1),s2.substring(0,length/2+1))
    				&& isScramble(s1.substring(length/2+1), s2.substring(length/2+1)));
    	}
    	return result;
    		// test case "abc" "cab" TRUE
    }
    */

}
