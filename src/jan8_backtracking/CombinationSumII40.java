package jan8_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Paul Qi
 *
 * same as the CombinationSum except
 * The solution set must not contain duplicate combinations.
 */

public class CombinationSumII40 {
	private List<List<Integer>> solution = new LinkedList<List<Integer>>();
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<Integer> result = new LinkedList<Integer>();
    	Arrays.sort(candidates);
    	combinationSumHelper(result, candidates, 0, target);
    	return solution;
    }
    
    private void combinationSumHelper(List<Integer> result, int[] candidates, int start, int target){
    	
    	for(int i= start; i<candidates.length && candidates[i]<=target; i++){
    		// how to remove duplicate.
    		int k=0,last=result.size()-1;
    		for(int j=i; j>=0 &&candidates[j] == candidates[i]; j--,k++);
    		while(!result.isEmpty() && last>=0 && result.get(last--) == candidates[i])k--;
    		if(k!=1)continue;
    		
    		if(candidates[i] == target){
    			result.add(target);
    			clone(result);
    			result.remove(result.size()-1);
    			break;
    		}
    		else{
    			result.add(candidates[i]);
    			combinationSumHelper(result, candidates, i+1, target-candidates[i]);
    			// backtracking
    			result.remove(result.size()-1);
    		}
    	}
    }
    
    private void clone(List<Integer> original){
    	List<Integer> clone = new LinkedList<Integer>();
    	for(int i: original){
    		clone.add(i);
    	}
    	solution.add(clone);
    }
    
    public static void main(String[] args){
    	CombinationSumII40 test = new CombinationSumII40();
//    	List<List<Integer>> result = test.combinationSum(new int[]{2,4}, 6);
//    	List<List<Integer>> result = test.combinationSum(new int[]{2,3,6,7}, 7);
//    	List<List<Integer>> result = test.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    	List<List<Integer>> result = test.combinationSum2(new int[]{3,1,3,5,1,1}, 8);
    	for(List<Integer> l: result){
    		for(Integer i: l){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
    
}
