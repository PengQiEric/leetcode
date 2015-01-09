package jan8_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Paul Qi
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3]
 */

public class CombinationSum39 {
	
	private List<List<Integer>> solution = new LinkedList<List<Integer>>();
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<Integer> result = new LinkedList<Integer>();
    	Arrays.sort(candidates);
    	combinationSumHelper(result, candidates, 0, target);
    	return solution;
    }
    
    private void combinationSumHelper(List<Integer> result, int[] candidates, int start, int target){
    	
    	for(int i= start; i<candidates.length && candidates[i]<=target; i++){
    		if(candidates[i] == target){
    			result.add(target);
    			clone(result);
    			result.remove(result.size()-1);
    			break;
    		}
    		else{
    			result.add(candidates[i]);
    			combinationSumHelper(result, candidates, i, target-candidates[i]);
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
    	CombinationSum39 test = new CombinationSum39();
//    	List<List<Integer>> result = test.combinationSum(new int[]{2,4}, 6);
//    	List<List<Integer>> result = test.combinationSum(new int[]{2,3,6,7}, 7);
    	List<List<Integer>> result = test.combinationSum(new int[]{8,7,4,3}, 11);
    	for(List<Integer> l: result){
    		for(Integer i: l){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
}
