package january12;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Paul Qi
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Permutations46 {
	// when can we use backtracking? some stragety problem?
	
    List<List<Integer>> result = new LinkedList<List<Integer>>();

    public List<List<Integer>> permute(int[] num) {
        if(num.length>=1){
        	List<Integer> temp = new LinkedList<Integer>();
        	temp.add(num[0]);
        	result.add(temp);
        }
        
        for(int i=1; i<num.length; i++){
        	int length = result.size();
        	for(int j=0; j<length; j++){
        		List<Integer> old = result.remove(0);
        		copyAdd(old, num[i]);
        	}
        }
        return result;
    }
    
    // cost too many time to change the data structure
    private void copyAdd(List<Integer> old, int num){
    	for(int i=0; i<=old.size(); i++){
    		List<Integer> temp = new LinkedList<Integer>(old);
    		/*
    		for(Integer j: old){
    			temp.add(j);
    		}*/
    		temp.add(i, num);
    		result.add(temp);
    	}
    }
    
    public static void main(String[] args){
    	Permutations46 test = new Permutations46();
    	List<List<Integer>> result = test.permute(new int[]{1,2,3});
    	for(List<Integer> l: result){
    		for(Integer i: l){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
}
