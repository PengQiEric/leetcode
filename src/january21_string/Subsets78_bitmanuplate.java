package january21_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78_bitmanuplate {
	// 1. of course we can use dynamic programming to solve it. bottom to top dynamic programming
	
	// 2. backtracking is kind of top-bottom DP. if the subset is like a tree, sometimes it is hard to find the
	// 	  bottom-top solution
	
	/*
	 *  1 Determine the number of subsets using bit strings: 
	 *  we know that the number of subsets equals to 2 to the power of the number of elements in the superset:
	 *  #subsets = 2 ^ #elements. For instance, if our superset is S = {1, 2, 3}, 
	 *  then it has 2^3 = 8 subsets. If our superset has four elements then it has 2^4 = 16 subsets. 
	 *  Moreover, by shifting the bit representation of the number 1 by n, we also get 2^n. 
	 *  Thus, if we shift the bit string of 1 by the number of elements in the superset, 
	 *  we'll get the number of subsets for that superset. For example, if we have S = {1, 2, 3}, 
	 *  then there are 1 << 3 = 2^3 subsets in S.
	 *  
	 *  2 Keeping track of data using bit manipulation: for this problem, 
	 *  we will use a bit string to keep track of subsets and their elements. 
	 *  Take S = {1, 2, 3} as an example. 
	 *  If the bit string is 100 then the subset we're working on has only one element which is 1. 
	 *  If the bit string is 110 then the subset we're working on has two elements which are 1 and 2. 
	 *  We will use & and << bit operators to figure out which bit is 1 in the bit string.
	 */
	
    public List<List<Integer>> subsets(int[] S) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	Arrays.sort(S);
    	int nums=1<<S.length;
    	for(int i=0; i<nums; i++){
    		List<Integer> result = new ArrayList<Integer>();
    		int bitmask = i;
    		int pos = 0;
    		while(bitmask>0){
    			if((bitmask&1) == 1){
    				result.add(S[pos]);
    			}
    			pos++;
    			bitmask = bitmask>>1;
    		}
    		results.add(result);
    	}
    	return results;
    }
    
    public static void main(String[] args){
    	Subsets78_bitmanuplate test = new Subsets78_bitmanuplate();
    	int[] nums =  new int[]{1,2,3};
    	List<List<Integer>> results= test.subsets(nums);
    	for(List<Integer> r: results){
    		for(Integer i: r){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
}
