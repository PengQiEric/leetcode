package Dec22;

/**
 * @author Paul Qi
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArray1 {
	
	public static void main(String[] args){
		double result = findMedianSortedArrays(new int[]{1,2,3,4,5,6,7,20},new int[]{9,10,11,12,13,14,15,16});
		System.out.println(result);
	}

    public static double findMedianSortedArrays(int A[], int B[]) {
    	int midA, midB;
    	int startA = 0, startB = 0, endA = A.length, endB = B.length;
    	while(startA<endA && startB<endB){
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
    	return (A[startA]+B[startB])/2.0;
    }
    
}
