package jan9;

/**
 * @author Paul Qi
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */

public class FirstMissingPositive41 {
	
    public int firstMissingPositive(int[] A) {
    	int k= partition(A);
    	for(int i=0; i<=k; i++){
    		int element = Math.abs(A[i]);
    		if(element<=k+1){
    			A[element-1] = A[element-1]>0?-A[element-1]:A[element-1];
    		}
    	}
    	int i;
    	for(i=0; i<=k; i++){
    		if(A[i]>0)break;
    	}
    	return i+1;
    }
    
    private int partition(int[] A){
    	int q=-1;
    	for(int i=0; i<A.length; i++){
    		if(A[i]>0){
    			q++;
    			swap(A,q,i);
    		}
    	}
    	return q;
    }
    
    private void swap(int[] A, int i, int j){
    	if(i!=j){
    		A[i] ^= A[j]; //XOR
    		A[j] ^= A[i];
    		A[i] ^= A[j];
    	}
    }
    
    public static void main(String[] args){
    	FirstMissingPositive41 test = new FirstMissingPositive41();
    	System.out.println(test.firstMissingPositive(new int[]{3,4,-1,2}));
    	System.out.println(test.firstMissingPositive(new int[]{1}));
    }
}
