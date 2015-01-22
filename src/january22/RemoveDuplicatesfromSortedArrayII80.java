package january22;

/**
 * @author PAUL QI
 *  Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	
	Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class RemoveDuplicatesfromSortedArrayII80 {
    public int removeDuplicates(int[] A) {
    	int length = A.length;
    	for(int i=0,j=i+2; j<length;){
    		if(A[i] == A[j] && A[j] == A[j-1]){
    			length--;
    			moveFirst(i, A);
    		}
    		else{
    			i++;
    			j++;
    		}
    	}
    	return length;
    }
    // test case [1 1 1 2]
    private void moveFirst(int i, int[] A){
    	for(int j=i+1; j<A.length; j++){
    		A[j-1] = A[j];
    	}
    }
}
