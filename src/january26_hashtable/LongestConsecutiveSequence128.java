package january26_hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PAUL QI
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
	
	Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence128 {
	// sometimes found it is hard to be O(n) just based on the basic structure, now we should
	// remember we may can use other tools
    public int longestConsecutive(int[] num) {
    	Map<Integer, Integer> sum = new HashMap<Integer, Integer>();
    	int max = 1;
    	for(int i=0; i<num.length; i++){ // test case [1,2,0,1]
    		if(!sum.containsKey(num[i])){
	    		int left = sum.get(num[i]-1) == null?0:sum.get(num[i]-1);
	    		int right = sum.get(num[i]+1) == null?0:sum.get(num[i]+1);
	    		int s = left+right+1;
	    		sum.put(num[i], s);
	    		max = Math.max(max, s);
	    		
	    		sum.put(num[i]-left, s);
	    		sum.put(num[i]+right, s);
    		}
    	}
    	return max;
    }
    
    public static void main(String[] args){
    	LongestConsecutiveSequence128 test = new LongestConsecutiveSequence128();
    	System.out.println(test.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    	System.out.println(test.longestConsecutive(new int[]{1,2,0,1}));
    }
}
