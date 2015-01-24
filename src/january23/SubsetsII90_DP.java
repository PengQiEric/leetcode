package january23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PAUL QI
 *  Given a collection of integers that might contain duplicates, S, return all possible subsets.

	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,2], a solution is:
	[[2],[1],[1,2,2],[2,2],[1,2],[]]
 */

public class SubsetsII90_DP {
    public List<List<Integer>> subsetsWithDup(int[] num) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	List<List<Integer>> hasElement = new ArrayList<List<Integer>>();
    	List<List<Integer>> noneElement =  new ArrayList<List<Integer>>();
    	Arrays.sort(num);
    	// base case
    	noneElement.add(new ArrayList<Integer>());
    	List<Integer> base = new ArrayList<Integer>();
    	base.add(num[0]);
    	hasElement.add(base);
    	
    	for(int i=1; i<num.length; i++){
    		int firstQueueLength = hasElement.size();
    		int secondQueueLength = noneElement.size();
    		
    		if(num[i]!=num[i-1]){
	    		for(int j=0; j<secondQueueLength; j++){
	    			List<Integer> temp = new ArrayList<Integer>(noneElement.get(j));
	    			temp.add(num[i]);
	    			hasElement.add(temp);
	    		}
    		}
    		for(int j=0; j<firstQueueLength; j++){
    			List<Integer> remove =  hasElement.remove(0);
    			noneElement.add(remove);
    			List<Integer> temp = new ArrayList<Integer>(remove);
    			temp.add(num[i]);
    			hasElement.add(temp);
    		}
    	}
    	results.addAll(hasElement);
    	results.addAll(noneElement);
    	return results;
    }
    
    
    public static void main(String[] args){
    	SubsetsII90_DP test = new SubsetsII90_DP();
    	int[] nums =  new int[]{1,2,2};
    	List<List<Integer>> results= test.subsetsWithDup(nums);
    	for(List<Integer> r: results){
    		for(Integer i: r){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
}
