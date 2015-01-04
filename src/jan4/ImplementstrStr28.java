package jan4;

/**
 * @author Paul Qi
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * I think KMP is one of the best;
 * You could demonstrate to your interviewer that this problem can be solved using known efficient algorithms 
 * such as Rabin-Karp algorithm, KMP algorithm, and the Boyer- Moore algorithm.
 */

public class ImplementstrStr28 {
    // brute force O(nm) running 
	public static int strStr(String haystack, String needle) {
		
		for(int i=0; i<=haystack.length()-needle.length(); i++){
			int j,k;
			for( j=0,k=i; j<needle.length(); j++,k++){
				if(haystack.charAt(k)!=needle.charAt(j)) break;
			}
			if(j == needle.length()){
				return i;
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args){
		System.out.println(strStr("abcabcd", "abcd"));
	}
}
