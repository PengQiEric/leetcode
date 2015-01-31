package january29;

/**
 * @author PAUL QI
 * 
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * More generally, find the k's element.
 */

public class MedianofTwoSortedArrays4 {
	//http://leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
	// http://leetcode.com/2011/03/median-of-two-sorted-arrays.html
	// some really good refer, however, it's really trivial and easy to have bug.
    public double findMedianSortedArrays(int A[], int B[]) {
    	int length = A.length+B.length;
    	if((length & 0x1) == 1){
    		return (double)findKthSmallest(A, 0, A.length-1,B, 0, B.length-1, length/2+1);
    	}
    	else{
    		return (findKthSmallest(A, 0, A.length-1, B, 0, B.length-1, length/2)
    				+ findKthSmallest(A, 0, A.length-1, B, 0, B.length-1, length/2+1))/2.0;
    	}
    }
	
	private int findKthSmallest(int[] A, int startA, int endA, int[] B, int startB, int endB, int k){
		
		// Ai Bj i+j = k-1	i+j = k-1 	// before i(exclusive) i elements before j-1(inclusive),j elements 
		if(endA-startA > endB -startB){
			return findKthSmallest(B, startB, endB, A, startA, endA, k);
		}
		if(endA-startA+1 == 0){
			return B[startB+k-1];
		}
		if(k == 1){
			return Math.min(A[startA], B[startB]);
		}
		
		int i = Math.min(k/2, endA-startA+1);
		int j = k-i;
		
		if(A[startA+i-1] < B[startB+j-1]){
			return findKthSmallest(A, startA+i, endA, B, startB, endB, k-i);
		}
		else if(B[startB+j-1] < A[startA+i-1]){
			return findKthSmallest(A, startA, endA, B, startB+j, endB, k-j);
		}
		else{
			return A[startA+i-1];
		}
	}
	
	public static void main(String[] args){
		MedianofTwoSortedArrays4 test = new MedianofTwoSortedArrays4();
		// test case [] [1]
//		System.out.println(test.findMedianSortedArrays(new int[]{}, new int[]{1}));
//		System.out.println(test.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4}));
//		System.out.println(test.findMedianSortedArrays(new int[]{1,2}, new int[]{1,2}));
		System.out.println(test.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
	}
}
