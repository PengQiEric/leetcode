package Dec23;

/**
 * @author Paul Qi
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class longestSubstringWithoutRepeatingCharacters2 {
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstring("bbbadcef"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
		System.out.println(lengthOfLongestSubstring("wcibxubumenmeyatdrmydiajxloghiqfmzhlvihjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfyk"));
	}
	
	/*
	 *  OPT(i) = Max( OPT(i-1) , OPT_End(i-1)+1 if A[i] is unique in OPT_End(i-1);
	 *  OPT_End(i) = OPT_End(i-1)+1 if A[i] is unique in OPT_End(i-1) : 1;
	 */
	
    public static int lengthOfLongestSubstring(String s) {
    	if(s.length() == 0){
    		return 0;
    	}    	
    	int[] opt = new int[s.length()];
    	int[] optEnd = new int[s.length()];
    	opt[0] = 1;
    	optEnd[0] = 1;
    	for(int i=1; i<s.length(); i++){
    		boolean found = false;
			char last = s.charAt(i);
    		for(int j=i-1; j>=i-1-optEnd[i-1]+1; j--){
    			if(last == s.charAt(j)){
    				optEnd[i] = i-j;
    				found = true;
    				break;
    			}
    		}
    		if(!found){
    			optEnd[i] = optEnd[i-1]+1;
    		}
    		opt[i] = Math.max(opt[i-1], optEnd[i]);
    	}
    	return opt[s.length()-1];
    }
}
