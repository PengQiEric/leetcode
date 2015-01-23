package january22;

import java.util.HashMap;
import java.util.Map;

// it is a top-bottom DP with memorization
public class ScrambleString87_withmemory {
	
	private Map<String,Boolean> cache =  new HashMap<String, Boolean>();
	// this method is exponent time complexity solution
	// this gives a O(n^4) solution http://n00tc0d3r.blogspot.com/2013/05/scramble-string.html
    public boolean isScramble(String s1, String s2) {
    	if(s1.length() == 1){
    		if(s1.equals(s2)){
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    	if(cache.get(s1+s2)!=null && cache.get(s1+s2)){
    		return true;
    	}
    	else if(cache.get(s1+s2)!=null){
    		return false;
    	}
    	int length = s1.length();
    	for(int i=1; i<length; i++){
    		if((isScramble(s1.substring(0,i), s2.substring(0,i))&& isScramble(s1.substring(i), s2.substring(i)))
    				|| (isScramble(s1.substring(0,i), s2.substring(length-i,length))) 
    				&& isScramble(s1.substring(i), s2.substring(0, length-i))){
    			cache.put(s1+s2, true);
    			cache.put(s2+s1, true);
    			return true;
    		}
    	}
    	cache.put(s1+s2, false);
    	cache.put(s2+s1, false);
    	return false;
    }
    
    public static void main(String[] args){
    	ScrambleString87_withmemory test = new ScrambleString87_withmemory();
    	System.out.println(test.isScramble("great", "rgaet"));
    	System.out.println(test.isScramble("abb", "bab"));
    	System.out.println(test.isScramble("abc", "bac"));
    	System.out.println(test.isScramble("abc", "cab"));
    }
}
