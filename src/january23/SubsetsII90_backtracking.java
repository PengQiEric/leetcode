package january23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90_backtracking {
	
	
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(num);				// make sure it is ordered
        int[] in = new int[num.length];
        subsetsHelper(in, num, 0, results);
        return results;
    }

    public void subsetsHelper(int[] in, int[] num, int start, List<List<Integer>> results){
    	copyList(in, results, num);			// it is great, because it calculate the result which the num is zero
    	
    	for(int i=start; i<num.length; i++){
    		in[i] = 1;
    		subsetsHelper(in, num, i+1, results);
    		in[i] = 0;
    		while(i+1<num.length && num[i] == num[i+1])i++; // because next loop will be i+1
    	}
    }
    
    private void copyList(int[] nums, List<List<Integer>> results, int[] s){
    	List<Integer> result1 =  new ArrayList<Integer>();
    	for(int i=0; i<s.length; i++){
    		if(nums[i]==1){
    			result1.add(s[i]);
    		}
    	}
    	results.add(result1);
    }
    
    public static void main(String[] args){
    	SubsetsII90_backtracking test = new SubsetsII90_backtracking();
    	int[] nums =  new int[]{1,2,2};
    	List<List<Integer>> results= test.subsetsWithDup(nums);
    	for(List<Integer> r: results){
    		for(Integer i: r){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
    }
    
    // this is great solution
}
