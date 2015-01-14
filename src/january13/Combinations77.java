package january13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Paul Qi
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 */

public class Combinations77 {
/*    public List<List<Integer>> combine(int n, int k) {
        
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	List<Integer> result = new LinkedList<Integer>();
    	for(int i=1; i<=k; i++){
    		result.add(i);
    	}
    	results.add(result);
    	
    	for(int i=k+1; i<=n; i++){
    		int size = results.size();
    		for(int j=0; j<size; j++){
    			List<Integer> temp = results.get(j);
    			copyAndModify(results, temp, i);
    		}
    	}

    	return results;
    }
    
    private void copyAndModify(List<List<Integer>> results, List<Integer> result, int element){
    	for(int i=0; i<result.size(); i++){
    		List<Integer> temp = new LinkedList<Integer>(result);
    		temp.remove(i);
    		temp.add(element);
    		results.add(temp);
    	}
    }
    */
    
    public static void main(String[] args){
    	Combinations77 test = new Combinations77();
//    	List<List<Integer>> result = test.combine(9,8);
    	List<List<Integer>> result = test.combine(4,2);
    	for(List<Integer> l: result){
    		for(Integer i: l){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
    
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	List<Integer> result =  new LinkedList<Integer>();
    	combineHelper(results, k, result, 0, n);
    	return results;
    }
    
    private void combineHelper(List<List<Integer>> results, int k, List<Integer> result, int start, int n){

    	for(int i=start; i<n; i++){
    		result.add(i+1);
        	if(result.size() == k){
        		List<Integer> temp = new LinkedList<Integer>(result);
        		results.add(temp);
        	}
        	else{
        		combineHelper(results,k,result,i+1, n);
        	}
        	result.remove(result.size()-1);
    	}
    }
    
}
