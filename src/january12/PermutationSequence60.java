package january12;

/**
 * 
 * @author Paul Qi
 * The set [1,2,3,É,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */

public class PermutationSequence60 {
	// we can use NextPermutation for k times
    public String getPermutation(int n, int k) {
    	int[] nums = new int[n];
    	for(int i=0; i<n; i++){
    		nums[i] = i+1;
    	}
    	for(int i=1; i<k; i++){
    		nextPermutation(nums);
    	}
    	StringBuffer str = new StringBuffer();
    	for(int i: nums){
    		str.append(i);
    	}
    	return str.toString();
    }
    
    private void nextPermutation(int[] num){
    	int i;
    	for(i=num.length-1; i>=0; i--){
    		// 1 3 5 4 2
    		if(i>0 && num[i]>num[i-1]){
    			break;
    		}
    	}
    	// Go from the end of array
    	for(int j=num.length-1; j>=i; j--){
    		if(num[j]>num[i-1]){
    			swap(num,j,i-1);
    			break;
    		}
    	}
    	for(int p=i,q=num.length-1; p<q; p++,q--){
    		swap(num,p,q);
    	}
    	
    }
    
    private void swap(int[] num, int i, int j){
		int temp = num[j];
		num[j] = num[i];
		num[i] = temp;
    }
    
    public static void main(String[] args){
    	PermutationSequence60 test = new PermutationSequence60();
    	System.out.println(test.getPermutation(4, 10));
    }
}
