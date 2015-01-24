package january21_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PAUL QI
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]
]
 */

public class Subsets78 {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(S);				// make sure it is ordered
        int[] num = new int[S.length];
        subsetsHelper(num, S, 0, results);
        return results;
    }
    
    // maybe it is not a good solution
    public void subsetsHelper(int[] num, int[] s, int start, List<List<Integer>> results){
    	if(start == s.length){
    		copyList(num,results,s);
    	}
    	for(int i=start+1; i<=s.length; i++){
    		num[start] = 1; // because start always be 0
    		subsetsHelper(num, s, i, results);
    		num[start] = 0;
    	}
    }
    
    private void copyList(int[] nums, List<List<Integer>> results, int[] s){
    	List<Integer> result1 =  new ArrayList<Integer>();
    	List<Integer> result2 =  new ArrayList<Integer>();
    	for(int i=0; i<s.length; i++){
    		if(nums[i]==1){
    			result1.add(s[i]);
    		}
    		else{
    			result2.add(s[i]);
    		}
    	}
    	results.add(result1);
    	results.add(result2);
    }
    
    public static void main(String[] args){
    	Subsets78 test = new Subsets78();
    	int[] nums =  new int[]{1,2,3,4};
    	List<List<Integer>> results= test.subsets(nums);
    	for(List<Integer> r: results){
    		for(Integer i: r){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
}
