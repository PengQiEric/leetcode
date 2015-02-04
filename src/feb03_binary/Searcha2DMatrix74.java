package feb03_binary;

/**
 * @author PAUL QI
 *
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	
	Consider the following matrix:
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.
 */

public class Searcha2DMatrix74 {
	// actually it is all sorted, we just need to find the index of the element.
    public boolean searchMatrix(int[][] matrix, int target) {
    	int row = matrix.length, column = matrix[0].length;
    	int begin = 0, end = row*column-1;
    	while(begin<=end){
    		int mid = (begin+end)/2;
    		int temp = matrix[mid/column][mid%column];	// different part
    		if(temp == target){
    			return true;
    		}
    		else if(temp<target){
    			begin = mid+1;
    		}
    		else{
    			end = mid-1;
    		}
    	}
    	return false;
    }
    
    private boolean searchLine(int[][] matrix, int target, int row, int begin, int end){
    	while(begin<=end){
    		int mid = (begin+end)/2;
    		if(matrix[row][mid] == target){
    			return true;
    		}
    		else if(matrix[row][mid]<target){
    			begin = mid+1;
    		}
    		else{
    			end = mid-1;
    		}
    	}
    	return false;
    }
}
