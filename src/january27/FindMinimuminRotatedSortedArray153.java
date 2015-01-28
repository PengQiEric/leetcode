package january27;

/**
 * @author PAUL QI
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	Find the minimum element.
	
	You may assume no duplicate exists in the array.
 */

public class FindMinimuminRotatedSortedArray153 {
    public int findMin(int[] num) {	// target is finding the first Ai-1 > Ai and Ai is our target
        int begin = 0, end = num.length-1;
        int min = num[0];
        while(begin<=end){
            int median = (begin+end)/2;
            if(num[begin]<num[median]){
                min = Math.min(min,num[begin]);
                begin = median+1;
            }
            else if(num[median] == num[begin]){	// it means only left two element
                min = Math.min(min, num[begin]);
                min = Math.min(min, num[end]);
                begin++;
                end--;
            }
            else{
                min = Math.min(min,num[median]);
                end = median-1;
                begin = begin+1;
            }
        }
        return min;
    }
    
    public int findMin_right(int[] num){
    	int begin = 0, end = num.length-1;
    	int min = num[0];
    	while(begin<=end){	// [1,2] [2,1] [2,1,3]
    		int median = (begin+end)/2;
    		if(begin == end){	// when begin == end, it is the time to return
    			return num[begin];
    		}
    		else if(num[begin]<num[end]){ // never rotated
    			return num[begin];
    		}
    		else if(num[median]<num[end]){
    			end = median;
    		}
    		else{
    			begin = median+1;
    		}
    	}
    	return min;
    }
    
    public int findMin_concise(int[] num){
    	int begin = 0, end = num.length - 1;
    	while(begin<end){ // [1,2] [2,1] [2,1,3]
    		int median = (begin+end)/2;
    		if(num[median] < num[end]){
    			end = median;
    		}
    		else{
    			begin = median+1;
    		}
    	}
    	return num[begin];
    }
}
