package aNext.first.feb18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PAUL QI
 * Implement wildcard pattern matching with support for '?' and '*'.

	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false
 */

public class WildcardMatching44 {
	public boolean isMatch(String s, String p){
		// can not pass without the previous condition check.
		if (s == null || p == null) return false;  
		   
	  	// calculate count for non-wildcard char  
	   int count = 0;  
	   for (Character c : p.toCharArray()) {  
	     if (c != '*') ++count;  
	   }  
	   // the count should not be larger than that of s  
	   if (count > s.length()) return false;  
	   
		
		// it is a great DP soultion
		boolean[] result = new boolean[s.length()+1];
		// base case
		result[0] = true;
		for(int i=1; i<=s.length(); i++){
			result[i] = false; // p is empty();
		}
		
		int firstMatch = 0;
		
		for(int j=1; j<=p.length(); j++){
		     if (j > 1 && p.charAt(j-1) == '*' && p.charAt(j-2) == '*') {  
		         continue;  
		       } 
			
				if(p.charAt(j-1) == '*'){	// then we find the first match, then the after part are all true
					for(int k= firstMatch+1; k<=s.length(); k++){
						result[k] = true;
					}
				}
				else{
					int match = -1;
					for(int i=s.length(); i>firstMatch; i--){	// why firstMatch? because before first match always false
						result[i] = (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') && result[i-1];
						if(result[i]) match = i;
					}
					if(match<0) return false;	// if substring cannot at least match substring, return false.
					firstMatch = match;
				}
		}
		return result[s.length()];
	}
	
	public boolean isMatch_memory(String s, String p){
		boolean[][] result = new boolean[s.length()+1][p.length()+1];
		// base case
		result[0][0] = true;
		for(int j=1; j<=p.length(); j++){
			if(p.charAt(j-1) !='*'){
				result[0][j] = false;
			}
			else{
				result[0][j] = result[0][j-1];
			}
		}
		for(int i=1; i<=s.length(); i++){
			result[i][0] = false;
		}
		
		for(int i=1; i<=s.length(); i++){
			for(int j=1; j<=p.length(); j++){
				if(p.charAt(j-1) == '*'){
					boolean re = false;
					for(int k=i;k>=0;k--){
						re = re || result[k][j-1];
						if(re == true){
							result[i][j] = true;
							break;
						}
					}
				}
				else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
					result[i][j] = result[i-1][j-1];
				}
				else{
					result[i][j] = false;
				}
			}
		}
		return result[s.length()][p.length()];
	}
    
	public static void main(String[] args){
    	WildcardMatching44 test = new WildcardMatching44();
//    	System.out.println(test.isMatch("b", "?*?"));
//    	System.out.println(test.isMatch("aa", "a"));
//    	System.out.println(test.isMatch("b", "?*?"));
    	System.out.println(test.isMatch("aab", "?*"));
    	System.out.println(test.isMatch("ab", "*"));
    	System.out.println(test.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
    }
	
	Map<String,Boolean> map = new HashMap<String, Boolean>();
    public boolean isMatch_recursive(String s, String p) {
        if(s.isEmpty()){
            if(p.isEmpty()){
            	return true;
            }
            for(int i=0; i<p.length(); i++){
            	if(p.charAt(i)!='*'){
            		return false;
            	}
            }
            return true;
        }
        
        if(p.isEmpty()){
            return false;
        }
        
        if(map.containsKey(s+"#"+p)){
        	return map.get(s+"#"+p);
        }
        boolean result = false;
        String subP = p.substring(1);
        if(p.charAt(0) == '*'){
        	for(int i=0; i<=s.length(); i++){
        		result = result || isMatch(s.substring(i),p.substring(1));
        	}
        	map.put(s+"#"+p, result);
        	return result;
        }
        else if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'){
            result = isMatch(s.substring(1),p.substring(1));
            map.put(s+"#"+p, result);
            return result;
        }
        else{
        	map.put(s+"#"+p, false);
            return false;
        }
    }
}
