package aNext.first.feb13_sequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author PAUL QI
 * 
 *  The gray code is a binary numeral system where two successive values differ in only one bit.

	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
	
	For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	
	00 - 0
	01 - 1
	11 - 3
	10 - 2
	Note:
	For a given n, a gray code sequence is not uniquely defined.
	
	For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	
	For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */

public class GrayCode89 {
	// of course, bit manipulate is better. And it seems that bit manipulate is useful for some sequence problem.
	// great refer http://n00tc0d3r.blogspot.com/2013/03/gray-code-and-variants.html
	public List<Integer> grayCode_bit(int n){
		// the basic idea is <Bi> = 0concate<Bi-1> U 1concate<Bi-1>
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);	// 
		for(int i=0; i<n; i++){
			int flipper = 1<<i;	// move one bit it will be 10
			for(int j = result.size()-1; j>=0; j--){	// it is important to know why we add the number beginning with the end
				result.add(flipper|result.get(j));
			}
		}
		return result;
	}
	
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<Integer>();
        if(n<1){
        	return results;
        }
        Set<Integer> cache = new HashSet<Integer>();
        int[] nums = new int[n];
        grayCodeHelper(cache, nums, results);
        return results;
    }
    
    private void grayCodeHelper(Set<Integer> cache, int[] nums, List<Integer> results){
    	int val = copyResult(nums);
    	cache.add(val);
    	results.add(val);
    	for(int i=nums.length-1; i>=0; i--){
    		nums[i] = nums[i]^0x1;
    		int value = copyResult(nums);
    		if(!cache.contains(value)){
    			grayCodeHelper(cache, nums, results);
    			break;	// it is kind of DFS, but if we find a branch, we can sure this is the target! so we don't need to check other branch.
    		}
    		else{
    			nums[i] = nums[i]^0x1;
    		}
    	}
    }
    
    private int copyResult(int[] nums){
    	StringBuffer sb = new StringBuffer();
    	for(int i: nums){
    		sb.append(i);
    	}
    	int num = Integer.parseInt(sb.toString(), 2);
    	return num;
    }
    
    public static void main(String[] args){
    	GrayCode89 test = new GrayCode89();
    	List<Integer> nums = test.grayCode_bit(2);
    	for(Integer i: nums){
    		System.out.print(i+" ");
    	}
    }
}

