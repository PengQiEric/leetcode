package feb03_binary;

/**
 * @author PAUL QI
 * 
 *  A peak element is an element that is greater than its neighbors.

	Given an input array where num[i] ­ num[i+1], find a peak element and return its index.
	
	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	
	You may imagine that num[-1] = num[n] = -°.
	
	For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
	
	Note:
	Your solution should be in logarithmic complexity.

 */

public class FindPeakElement162 {
    public int findPeakElement(int[] num) {	// [0] [1 2] [2 1] [3,1,2] [1 2 3] [1,3,2]
        int begin = 0, end = num.length-1;
        while(begin<= end){
        	int median = (begin+end)/2;
        	if(median+1<num.length && num[median] < num[median+1]){
        		begin = median+1;
        	}
        	else if(median-1>=0 && num[median] < num[median-1]){
        		end = median-1;
        	}
        	else{
        		return median;
        	}
        }
        return -20000;	// for the code, this can never be reached, so we can change to any number
    }
    
    // this is more concise, but need more loop
    public static int findPeak(int[] num){
    	   if (num.length <= 1) return 0;
    	    int mid = 0, l = 0, h = num.length - 1;

    	    while (l < h) {	// before l == h, it quits	[1,3,2]
    	        mid = (l + h) / 2;
    	        if (num[mid] > num[mid + 1])
    	            h = mid;
    	        else if (num[mid] < num[mid + 1])
    	            l = mid + 1;
    	    }

    	    return l;
    }
    
    public static void main(String[] args){
    	System.out.println(findPeak(new int[]{1,2}));
    }
}
