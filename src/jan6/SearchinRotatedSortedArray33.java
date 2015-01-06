package jan6;

/**
 * @author Paul Qi
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */

public class SearchinRotatedSortedArray33 {

    public int search(int[] A, int target) {
     
    	int begin = 0, end = A.length-1;
    	while(begin<=end){
        	int middle = (begin+end)/2;
        	if(target == A[begin]) return begin;
        	if(target == A[middle]) return middle;
        	if(target == A[end]) return end;
        	
    		if((A[begin]<A[middle] && target> A[begin] && target<A[middle]) 
    				|| (A[middle]< A[end] && (target<A[middle]|| target>A[end]))){
    			begin = begin+1;
    			end = middle-1;
    		}
    		else{
    			begin = middle+1;
    			end = end-1;
    		}
    	}
    	return -1;
    }
	
	public static void main(String[] args){
		SearchinRotatedSortedArray33 test = new SearchinRotatedSortedArray33();
		System.out.println(test.search(new int[]{},0));
	}
}
