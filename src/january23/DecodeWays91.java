package january23;


/**
 * @author PAUL QI
 * 
 *   A message containing letters from A-Z is being encoded to numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	
	The number of ways decoding "12" is 2.
 */

public class DecodeWays91 {
    // bottom up
    public int numDecodings(String s) {
    	if(s.length() == 0){
    		return 0;
    	}
    	int[] results = new int[s.length()];
    	results[0] = s.charAt(0) == '0'?0:1;
    	
    	for(int i=1; i<s.length(); i++){
    		if(s.charAt(i)!='0'){
    			results[i] += results[i-1];
    		}
    		if(Integer.parseInt(s.substring(i-1,i+1))<=26 && Integer.parseInt(s.substring(i-1,i+1))>=10){
    			results[i] += i-2>=0?results[i-2]:1;
    		}
    	}
    	return results[s.length()-1];
    }
    
    public static void main(String[] args){
    	DecodeWays91 test = new DecodeWays91();
    	System.out.println(test.numDecodings("12"));
    	System.out.println(test.numDecodings("230"));
    }
}
