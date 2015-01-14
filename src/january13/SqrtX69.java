package january13;

/**
 * @author Paul Qi
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */

public class SqrtX69 {
	
	// lg(n) is fast enough. 
//    public static int sqrt(int x) {
//    	
//    	return x;
//    }

    public static void main(String[] args){
    	System.out.println(sqrt(1));
    }

	public static int sqrt(int x) {
	    int begin = 1, end = x;
	    while(begin<=end){
	    	int mid = (begin+end)/2;
	/*    	if(begin == x/begin){	// do not use begin*begin to determine, it may overflow
	    		return begin;
	    	}
	    	if(end == x/end){
	    		return end;
	    	}*/
	    	if(mid == x/mid){
	    		return mid;
	    	}
	    	else if(mid > x/mid){
	    		end = mid-1;
	    	}
	    	else{
	    		begin = mid+1;
	    	}
	    }
		return end;
	}
}
