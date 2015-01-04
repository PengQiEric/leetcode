package jan4;

/**
 * @author Paul Qi
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

public class RemoveElement27 {
    public int removeElement(int[] A, int elem) {
        int j=0;
        for(int i=0; i<A.length; i++){
        	if(A[i] != elem){
        		A[j++] = A[i];
        	}
        }    	
    	return j;
    }
    
    // replace less elements.
    public int removeElement_fast(int[] A, int elem) {
    	int fast = A.length-1;
    	int i = 0;
    	while(i<=fast){
    		if(A[i] == elem){
    			A[i] = A[fast--];
    		}
    		else{
    			i++;
    		}
    	}
    	return fast+1;
    }
}
