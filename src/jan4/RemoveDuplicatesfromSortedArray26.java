package jan4;

/**
 * @author Paul Qi
 * Given a sorted array, remove the duplicates in place such that each element appear only once 
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */

public class RemoveDuplicatesfromSortedArray26 {
    public static int removeDuplicates(int[] A) {    	
    	int j = 0;
    	for(int i=0; i<A.length;i++){
    		if(i==0 || A[i]!=A[i-1]){
    			A[j] = A[i];
    			j++;
    		}
    	}
    	return j;
    }
    
    public static void main(String[] args){
    	System.out.println(removeDuplicates(new int[]{1,1,1}));
    }
}
