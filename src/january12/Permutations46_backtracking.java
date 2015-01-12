package january12;

import java.util.ArrayList;
import java.util.List;

public class Permutations46_backtracking {

	// the basic idea is swap numbers
    public List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	permuteHelper(result, num, 0);
    	return result;
    }
    
    
    private void permuteHelper(List<List<Integer>> result, int[] num, int start){
    	// change from num.length to num.length-1, it will slow
    	if(start>=num.length-1){
    		List<Integer> temp = copyResult(num);
    		result.add(temp);
    		return;
    	}
    	for(int j=start; j<num.length; j++){
    		swap(num, start, j);
    		permuteHelper(result, num, start+1);
    		swap(num, start, j);
    	}
/*    	for(int i=start; i<num.length; i++){
    		for(int j=i+1; j<num.length; j++){
    			swap(num,i,j);
    			permuteHelper(result, num, start+1);
    			//this step is backtracking
    			swap(num,i,j);
    		}
    	}*/
    }
    
    private void swap(int[] num, int i, int j){
    	if(i!=j){
	    	num[i] ^= num[j];
	    	num[j] ^= num[i];
	    	num[i] ^= num[j];
    	}
    }
    
    private List<Integer> copyResult(int[] result){
    	List<Integer> r = new ArrayList<Integer>();
    	for(int i: result){
    		r.add(i);
    	}
    	return r;
    }
    
    public static void main(String[] args){
    	Permutations46_backtracking test = new Permutations46_backtracking();
    	List<List<Integer>> result = test.permute(new int[]{1,2,3});
//    	List<List<Integer>> result = test.permute(new int[]{1,1,2});
    	for(List<Integer> l: result){
    		for(Integer i: l){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
    
}
