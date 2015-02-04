package feb01;

/**
 * @author PAUL QI
 *  Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true
 */

public class RegularExpressionMatching10 {
    
	// first let try some original solution
	public boolean isMatch_TLE(String s, String p) {
    	// if two string are empty or P like "X*", X can be any character, we can return true;
		if(s.isEmpty() && (p.isEmpty() || p.length() == 2 && p.charAt(1) == '*'))
			return true;
		
		// besides empty and X*, if only one is empty, return false.
		if(s.isEmpty() && !p.isEmpty() || !s.isEmpty() && p.isEmpty())
			return false;
		
		// precondition s & p are not empty
		if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'){
			
			if(p.length()>=2 && p.charAt(1) == '*'){
				return isMatch(s.substring(1), p)// * mean multiply time
						|| isMatch(s.substring(1),p.substring(2)) // * means only one time
						|| isMatch(s, p.substring(2)); // * means zero time
			}
			return isMatch(s.substring(1), p.substring(1));
		}
		else if(p.length()>=2 && p.charAt(1) == '*'){
			return isMatch(s, p.substring(2));
		}
		return false;
    }
	
	// http://n00tc0d3r.blogspot.com/search?q=Regular+Expression+Matching
	// above solution 
	public boolean isMatch(String s, String p) {
		if(p.isEmpty())return s.isEmpty();
		
		// next character is not '*'
		if(p.length() == 1 || p.charAt(1)!='*'){
			if(s.isEmpty()) return false;
			return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
		}
		else{
			// it means // x* matches empty string or at least one character: x* -> xx*
			return isMatch(s,p.substring(2)) || 
					!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
		}
//		
//		int i = 0;
//		while(i<s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
//			if(isMatch(s.substring(i), p.substring(2)))return true;
//			i++;
//		}
//		return isMatch(s.substring(i),p.substring(2));
	}
	
	public static void main(String[] args){
		RegularExpressionMatching10 test = new RegularExpressionMatching10();
		System.out.println(test.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
	}
}
