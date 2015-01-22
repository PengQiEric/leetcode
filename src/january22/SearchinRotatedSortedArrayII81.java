package january22;
/**
 * @author PAUL QI
 * 
 *  Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?
	
	Would this affect the run-time complexity? How and why?
	
	Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII81 {
    
	public boolean search(int[] A, int target) {
        return binarySearch(A, 0, A.length-1, target);
    }
	
	private boolean binarySearch(int[] A, int begin, int end, int target){
		if(begin>end){
			return false;
		}
		
		int middle = (begin+end)/2;
		if(target == A[begin] || target == A[end] || target == A[middle]){
			return true;
		}
		
		if(A[begin]<A[middle]){
			if(target>A[begin] && target<A[middle]){
				return binarySearch(A, begin+1, middle-1, target);
			}
			else{
				return binarySearch(A, middle+1, end-1, target);
			}
		}
		else if(A[middle]<A[end]){
			if(target>A[middle] && target<A[end]){
				return binarySearch(A, middle+1, end-1, target);
			}
			else{
				return binarySearch(A, begin+1, middle-1, target);
			}
		}
		else{	// some one may just go on to the [i+1,j] and search, then it may have iterative version
			if(A[begin] == A[middle] && A[middle] == A[end]){
				return binarySearch(A, begin+1, middle-1, target) || binarySearch(A, middle+1, end-1, target);
			}
			else if(A[middle]>A[end]){
				// begin == middle && middle > end 
				return binarySearch(A, middle+1, end-1, target);
			}
			else{
				return binarySearch(A, begin+1, middle-1, target);
			}
		}
	}
}
