package Dec22;

/**
 * Unsolved
 * @author Paul Qi
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArray1 {
	
	public static void main(String[] args){
		double result = findMedianSortedArrays_try1(new int[]{1,2,3,4,5,6,13,15},new int[]{7,8,11,12,13,14,15,16});
		System.out.println(result);
	}

	public static double findMedianSortedArrays(int A[], int B[]){
		int length = (A.length + B.length)/2;
		int Astart = 0, Bstart = 0;
		while(length<=1){
			if(A[Astart]<B[Bstart]){
				
			}
		}
		
		return 0;
	}
	
	
	/**
	 * try 1, doesn't work if the two median element are in the same element
	 * and it must requires the two array has the same length
	 */
	public static double findMedianSortedArrays_try1(int A[], int B[]) {
    	int midA, midB;
    	int startA = 0, startB = 0, endA = A.length-1, endB = B.length-1;
    	while(startA<=endA && startB<=endB){
        	midA = (startA+endA)/2;
        	midB = (startB+endB)/2;
        	if(A[midA]<B[midB]){ // drop half of the larger part of B, drop half of the small part of A
        		startA = midA+1;
        		endB = midB-1;
        	}
        	else{ //middle of A >= middle of B
        		startB = midB +1 ;
        		endA = midA-1;
        	}
    	}
    	System.out.println(startA+" "+startB);
//    	return (A[startA]+B[startB])/2.0;
    	return A[startA]>B[startB]?B[startB]:A[startA];
    }
    
}
