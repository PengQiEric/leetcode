package feb03_binary;
/**
 * @author Paul Qi
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */

public class SearchforaRange34 {
    public int[] searchRange_no_recursive(int[] A, int target) {
    	int begin = 0; int end = A.length-1;
    	int[] range = new int[]{-1, -1};
    	
    	while(begin<=end){
    		int mid = (begin+end)/2;
    		if(A[mid]>target){
    			end = mid-1;
    		} else if(A[mid]<target){
    			begin = mid+1;
    		}
    		else{ // we find at least a target
    			
    			// find the beginning point
    			int hight = mid-1;
    			while(begin<=hight){
    				int m = (begin+hight)/2;
    				if(A[m] == target)
    					hight = m-1;
    				else		// it is the low bound
    					begin = m+1;
    			}
    			range[0] = begin;
    			
    			// find the ending point
    			int low = mid+1;
    			while(low<=end){
    				int m = (low+end)/2;
    				if(A[m] == target){
    					low = m+1;
    				}
    				else{
    					end = m-1;
    				}
    			}
    			range[1] = end;
    			return range;
    		}
    	}
    	return range;
    }
    
    int start = -1;
    int finish = -1;
    
    public int[] searchRange(int[] A, int target) {
    	searchHelper(A,0,A.length-1, target);
    	return new int[]{start, finish};
    }
    
    private void searchHelper(int[] A, int begin, int end, int target){
    	if(begin > end){
    		return;
    	}
    	int middle = (begin+end)/2;
		if(target == A[middle]){
			if(start == -1 || start > middle) start = middle;
			if(finish == -1 || finish < middle) finish = middle;
		}
		if(target == A[begin]){
			if(start == -1 || start > begin) start = begin;
			if(finish == -1 || finish < begin) finish = begin;
		}
		if(target == A[end]){
			if(start == -1 || start > end) start = end;
			if(finish == -1 || finish < end) finish = end;
		}
    	
    	
    	if(target == A[middle]){
        	searchHelper(A, begin+1, middle-1, target);
        	searchHelper(A,middle+1,end-1, target);
    	}
    	else if(target>=A[begin] && target<A[middle]){
    		searchHelper(A,begin+1,middle-1,target);
    	}
    	else{
    		searchHelper(A,middle+1, end-1, target);
    	}
    }
    
    public static void main(String[] args){
    	SearchforaRange34 test = new SearchforaRange34();
    	int[]  result = test.searchRange_no_recursive(new int[]{5, 7, 8, 8, 8, 10}, 8);
    	System.out.println(result[0]+" "+result[1]);
    }
}
