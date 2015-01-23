package january13;

/**
 * @author PAUL QI
 * 
 *  The set [1,2,3,É,n] contains a total of n! unique permutations.
	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3):
	
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
	
	Note: Given n will be between 1 and 9 inclusive.
 */

public class PermutationSequence60_backtracking {

    public String getPermutation(int n, int k) {
    	int[] nums = new int[n];
    	for(int i=0; i<n; i++){
    		nums[i] = i+1;
    	}
    	permutationHelper(nums, 0, 0, k);
    	StringBuffer sb =  new StringBuffer();
    	for(int i: nums){
    		sb.append(i);
    	}
    	return sb.toString();
    }
    
    private int permutationHelper(int[] nums, int start, int count, int k){
    	
    	if(start == nums.length){
    		if(++count == k){
    			return count;
    		}
    	}
    	
    	for(int i= start; i<nums.length; i++){
    		swap(nums, i, start);
    		int j;
    		for(j=i;j>start+1;j--){
    			if(nums[j-1]>nums[j]){
    				swap(nums, j-1, j);
    			}
    			else{
    				break;
    			}
    		}
    		count = permutationHelper(nums, start+1, count, k);
    		if(count == k){
    			return count;
    		}
    		else{
    			for(int p=j; p<i;p++){
    				swap(nums,p,p+1);
    			}
    			swap(nums, i, start);
//    			printArray(nums);
    		}
    	}
    	return count;
    }
    private void swap(int[] num, int i, int j){
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
    private void printArray(int[] nums){
    	System.out.print("[");
    	for(int i: nums){
    		System.out.print(i+",");
    	}
    	System.out.println("]");
    }
    
    /*
     * "123"
	 * "132"
	 * "213"
	 * "231"
	 * "312"
	 * "321"
     */
    public static void main(String[] args){
    	// it is incorrect because of the change order   1,2,3  -> 3,2,1   but we should get 3,1,2
    	PermutationSequence60_backtracking test = new PermutationSequence60_backtracking();
    	// 1,2,3,4  1,2,4,3  1,3,2,4  1,3,4,2  1,4,2,3 1,3,2,4  
    	System.out.println(test.getPermutation(4, 7));
    }
}
