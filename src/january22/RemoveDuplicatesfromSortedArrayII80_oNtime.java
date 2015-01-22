package january22;

public class RemoveDuplicatesfromSortedArrayII80_oNtime {
    	
    	// great solution refer by 
       //  http://tech-wonderland.net/blog/leetcode-remove-duplicates-from-sorted-array-i-and-ii.html
    // test case [1,1,1,2] 3
	// test case [1,1,1] 3
    public int removeDuplicates(int[] A, int k) {
    	int length = A.length;
    	if(length<k){
    		return length;
    	}
    	int i=1, j=1;
    	int count = 1;
    	while(j<length){
    		if(A[j]!=A[j-1]){
    			A[i++] = A[j];
    			count = 1;
    		}
    		else{ // A[j] == A[j-1];
    			if(++count<k){
    				A[i++] = A[j];
    			}
    		}
    		j++;
    	}
    	return i;
    }
}
