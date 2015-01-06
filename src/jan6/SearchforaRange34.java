package jan6;

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
    	int begin = 0, end = A.length-1;
    	int start = -1, finish = -1;
    	while(begin<=end){
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
    			
    		}
    		else if(target>=A[begin] && target<A[middle]){
    			begin = begin+1;
    			end = middle-1;
    		}
    		else{
    			begin = middle+1;
    			end = end-1;
    		}
    		
    	}
    	return new int[]{-1,-1};
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
    	int[]  result = test.searchRange(new int[]{5, 7, 8, 8, 8, 10}, 8);
    	System.out.println(result[0]+" "+result[1]);
    }
}
