package january25;


/**
 * @author PAUL QI
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

	For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6.
 */

/*
 * sometimes use some space can save some logic branch
 * Besides keeping track of the largest product, we also need to keep track of the smallest product. 
 * Why? The smallest product, 
 * which is the largest in the negative sense could become the maximum when being multiplied by a negative number.

	Let us denote that:
	
	f(k) = Largest product subarray, from index 0 up to k.
	Similarly,
	
	g(k) = Smallest product subarray, from index 0 up to k.
	Then,
	
	f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
	g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
 */
public class MaximumProductSubarray152 {
    public int maxProduct(int[] A) {	
    		// test case: [-2, 3, -4]  [7,-2,-4] [-1,-2,-9,-6]
    	   // difference between product & sum is product has the magic to make the smallest to biggest
    	if(A.length == 0){
    		return 0;
    	}
    	int opt=A[0],optEnd=A[0],optEndSmall = A[0];
    	for(int i=1; i<A.length; i++){
    		if(A[i]<0){
    			int temp =optEnd;
    			if(optEndSmall <0){
    				optEnd = optEndSmall * A[i];
    			}
    			else{
    				optEnd = A[i];
    			}
    			
    			if(temp>0){
    				optEndSmall = temp*A[i];
    			}
    			else{
    				optEndSmall = A[i];
    			}
    			
    		}
    		else{
    			if(optEnd>0){
    				optEnd = A[i]*optEnd;
    			}
    			else{
    				optEnd = A[i];
    			}
    			
    			if(optEndSmall<0){
    				optEndSmall = A[i]*optEndSmall;
    			}
    			else{
    				optEndSmall = A[i];
    			}
    		}
    		
    		opt = opt>optEnd?opt:optEnd;
    	}
    	return opt;
    }
    public static void main(String[] args){
    	System.out.println((new MaximumProductSubarray152()).maxProduct(new int[]{2,3,-2,4}));
    	System.out.println((new MaximumProductSubarray152()).maxProduct(new int[]{-2,3,-4}));
    	System.out.println((new MaximumProductSubarray152()).maxProduct(new int[]{7,-2,-4}));
    	System.out.println((new MaximumProductSubarray152()).maxProduct(new int[]{-1,-2,-9,-6}));
//    	System.out.println((new MaximumSubarray53()).maxSubArray_divideandconquer(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
