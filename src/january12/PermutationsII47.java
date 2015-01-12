package january12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul Qi
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */

public class PermutationsII47 {

	// [2,2,1,1]   1,2,2,1  1,2,1,2
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteHelper(num, 0, result);
		return result;
    }
	
	private void permuteHelper(int[] num, int start, List<List<Integer>> result){
		if(start>=num.length){
			List<Integer> temp = copyResult(num);
			result.add(temp);
		}
		
		for(int i=start; i<num.length; i++){
			// basically, we want to detect which condition we should not recurse again.
//			if (i != start && num[i] == num[i-1]) {
//				continue;
//			}
/*			boolean isDiff = swap(num,start,i);
			if(isDiff){
				permuteHelper(num, start+1, result);
				swap(num,start,i);
			}*/
			if(containsDuplicate(num,start,i)){
				swap(num,start,i);
				permuteHelper(num, start+1, result);
				swap(num,start,i);
			}
		}
	}
	
    private boolean swap(int[] num, int i, int j){
    	// basically they are the same, swapping has no effect

    	if(i!=j){
/*        	if(j>0 && num[j-1] == num[j]){
        		return false;
        	}
    		if(num[i] == num[j]){
    			return false;
    		}*/
	    	num[i] ^= num[j];
	    	num[j] ^= num[i];
	    	num[i] ^= num[j];
    	}
    	return true;
    }
    
    private List<Integer> copyResult(int[] result){
    	List<Integer> r = new ArrayList<Integer>();
    	for(int i: result){
    		r.add(i);
    	}
    	return r;
    }
    
    // 2,3,2,3   2,2,3,3,3       2,3,2,3,2   3,3,2,2,2   3,2,2,3,2
    //2,3,2,3,3
    // why need to check all the elements before the end? 
    private boolean containsDuplicate(int[] arr, int start, int end) {
    	for (int i = start; i <= end-1; i++) {
    		if (arr[i] == arr[end]) {
    			return false;
    		}
    	}
    	return true;
    }
     
    
    public static void main(String[] args){
    	PermutationsII47 test = new PermutationsII47();
//    	List<List<Integer>> result = test.permuteUnique(new int[]{1,1,2});
//    	List<List<Integer>> result = test.permuteUnique(new int[]{2,2,1,1});
    	List<List<Integer>> result = test.permuteUnique(new int[]{2,2,3,3,3});
    	for(List<Integer> l: result){
    		for(Integer i: l){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
}
