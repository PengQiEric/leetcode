package january24_list;

/**
 * @author PAUL QI
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
	
	More practice:
	If you have figured out the O(n) solution, 
	try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray53 {
	// O(n) = 2O(n/2) +o(n)     O(nlgn)
	public int maxSubArray_divideandconquer(int[] A) {
		if(A.length == 1){
			return A[0];
		}
		int median = (A.length-1)/2;
		int[] left = maxSubArrayHelper(A, 0, median, 0);
		int[] right = maxSubArrayHelper(A, median+1, A.length-1, 1);
		return left[0]>right[0]?(left[0]>left[1]+right[1]? left[0]:left[1]+right[1])
				:(right[0]>left[1]+right[1]?right[0]:left[1]+right[1]);
	}
	
	
	private int[] maxSubArrayHelper(int[] A, int start, int end, int direction){
		if(start == end){
			return new int[]{A[start],A[start]};
		}
		int median = (start+end)/2;
		int[] left = maxSubArrayHelper(A, start, median, 0);
		int[] right = maxSubArrayHelper(A, median+1, end, 1);
		int[] result = new int[2];
		result[0] = left[0]>right[0]?(left[0]>left[1]+right[1]? left[0]:left[1]+right[1])
				:(right[0]>left[1]+right[1]?right[0]:left[1]+right[1]);
		int max;
		if(direction == 0){
			max = A[end];
			int temp = A[end];
			for(int i=end-1;i>=start; i--){
				temp += A[i];
				if(temp>max){
					max = temp;
				}
			}
		}
		else{
			max = A[start];
			int temp = A[start];
			for(int i=start+1; i<=end; i++){
				temp += A[i];
				if(temp>max){
					max = temp;
				}
			}
		}
		result[1] = max;
		return result;
	}
	
	public int maxSubArray(int[] A) {
       if(A.length == 0){
    	   return 0;
       }
       // do not need memory, because we needn't the previous result
       int opt = A[0], optEnd = A[0];
       for(int i=1; i<A.length; i++){
    	   if(optEnd>0){
    		   optEnd = A[i]+optEnd;
    	   }
    	   else{
    		   optEnd = A[i];
    	   }
    	   opt = opt>optEnd?opt:optEnd;
       }
       return opt;
    }
    public static void main(String[] args){
    	System.out.println((new MaximumSubarray53()).maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    	System.out.println((new MaximumSubarray53()).maxSubArray_divideandconquer(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
