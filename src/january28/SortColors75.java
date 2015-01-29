package january28;

/**
 * @author PAUL QI
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	
	Note:
	You are not suppose to use the library's sort function for this problem.
	
	Follow up:
	A rather straight forward solution is a two-pass algorithm using counting sort.
	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
	
	Could you come up with an one-pass algorithm using only constant space?
 */

public class SortColors75 {
	//it is not kind of partition, it is kind of two pointers
    public void sortColors(int[] A) {	// [1,2,0,0,1,2,2,1] [0] always the basic case first [0,0] [2,2]
        int endZero = 0, beginTwo = A.length-1;
        
        for(int i=0; i<=beginTwo;){
        	if(A[i] == 0){
        		swap(A,i,endZero);
        		if(i == endZero){	// always try the basic case
        			i++;
        		}
        		endZero++;
        	}
        	else if(A[i] == 2){
        		swap(A,i,beginTwo--);
        	}
        	else{
        		i++;
        	}
        }
    }
    
    private void swap(int[] A, int i, int j){
    	int temp = A[j];
    	A[j] = A[i];
    	A[i] = temp;
    }
    
    // we can use the partition to solve this problem, first partition based on 0, second partition based on 1, 
    // then we done, O(2n) 
}
