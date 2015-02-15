package aNext.first.feb14;

/**
 * @author PAUL QI
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */

public class MaximalRectangle85 {
	// a genius solution based on https://oj.leetcode.com/discuss/20240/share-my-dp-solution
    public int maximalRectangle(char[][] matrix) {
    	// we can use three variable to compute the height * left * right, and every point get this three variable.
    	// we get from row by row.
    	int n = matrix[0].length;
    	int[] left = new int[n];
    	int[] right = new int[n];
    	int[] height = new int[n];
    	// base case left-> 0, height->0, right->n-1
    	for(int i=0; i<n; i++){
    		right[i] = n-1;
    	}
    	int max = 0;
    	for(int i=0; i<matrix.length; i++){	// row by row
    		int curleft = 0;
    		for(int j=0; j<n; j++){
    			if(matrix[i][j] == '0'){
    				left[j] = 0;	// must return to the initial value
    				curleft = j+1; 
    			}
    			else{
    				left[j] = Math.max(left[j], curleft); // make sure all the element in the rectangle are '1'
    			}
    		}
    		
    		int curright = n-1;
    		for(int j=n-1;j>=0; j--){
    			if(matrix[i][j] == '0'){
    				right[j] = n-1;		// must return to the original value
    				curright = j-1;
    			}
    			else{
    				right[j] = Math.min(right[j], curright);
    			}
    		}
    		
    		for(int j=0; j<n; j++){
    			if(matrix[i][j] == '0'){
    				height[j] = 0;
    			}
    			else{
    				height[j]++;
    			}
    		}
    		
    		for(int j=0; j<n; j++){
    			max = Math.max(max, height[j]*(right[j]-left[j]+1));
    		}
    	}
        // how to create an rectangle, upper down left right
    	return max;
    }
    
    // besides the DP solution, we can transform this problem to N problems of Largest Rectangle in Histogram
    // we can use height[n] to represent the height row by row.
}
