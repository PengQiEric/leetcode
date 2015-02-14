package aNext.first.feb13_sequence.refer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PAUL QI
 * 
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	Each number in C may only be used once in the combination.
	
	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6] 
 */

public class CombinationSumII {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        combinationHelper(num, 0, target, new ArrayList<Integer>());
        return results;
    }
    
    private void combinationHelper(int[] num, int start, int target, List<Integer> result){
        for(int i=start; i<num.length; i++){    // why for loop, I have already make decision this step, why need for loop?
            if(target<num[i]) break;            // I think I can have other way to check the result. 
                                                // but this way may because we now want the next num in this exact position.
                                                // all the element after the previous element can in this order.
            int j = i-1, count = 0;
            while(j>=0 && num[j] == num[i]){
                count++; j--;
            }
            j = result.size()-1;
            while(count>0 && j>=0 && result.get(j) == num[i]){
            	j--;
            	count--;	// we can only delete it when it matches the condition, so we cannot use count--;
            }
            if(count>0)continue;
            
            if(num[i] == target){
                result.add(num[i]);
                results.add(new ArrayList<Integer>(result));
                result.remove(result.size()-1);
                break;
            }
            else{
                result.add(num[i]);
                combinationHelper(num,i+1,target-num[i],result);
                result.remove(result.size()-1);
            }
        }
    }
    
    public static void main(String[] args){
    	CombinationSumII test = new CombinationSumII();
    	List<List<Integer>> re = test.combinationSum2(new int[]{2,2,2}, 4);
    	System.out.println();
    }
}
