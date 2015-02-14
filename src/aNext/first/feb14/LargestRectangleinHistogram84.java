package aNext.first.feb14;

import java.util.Stack;

/**
 * 
 * @author PAUL QI
 * 
 *  Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 *  find the area of largest rectangle in the histogram.

	Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
	
	The largest rectangle is shown in the shaded area, which has area = 10 unit.
	
	For example,
	Given height = [2,1,5,6,2,3],
	return 10.
 */

public class LargestRectangleinHistogram84 {
	// brute force will be in O(N^2)
    public int largestRectangleArea(int[] height) {
    	int min = Integer.MAX_VALUE;
    	int max = 0;
    	for(int i=0; i<height.length; i++){
    		if(height[i]<min){	// new Element is smaller
    			min = height[i];
    		}
    		else{
    			int tempMin = height[i];
    			for(int j=i;j>=0 && tempMin>min;j--){
    				tempMin = Math.min(tempMin, height[j]);
    				max = Math.max(max, (i-j+1)*tempMin);
    			}
    		}
    		max = Math.max(max, min*(i+1));
    	}
    	return max;
    }
    // the above is also O(N^2), even a little little little bit fast
    
    // we can solve it using recursive version, find the min position, calculate the max, 
    // then break to two subproblem at the place of the min
    
    // also we can use divide and conquer, O(nlgn) basically, for the situation we merge the result, we using O(n)
//    	P(n) = 2P(n/2) + O(n)
    
    
    // we need to calculate each bar as the "smallest" bar, then we need to find the left index and the right index 
    public int largestRectangleArea_stack(int[] height) {
    	Stack<Integer> left = new Stack<Integer>();
    	int max = 0;
    	for(int i=0; i<height.length;){
    		// this is the way to find the right Bar
    		if(left.isEmpty() || height[i] >= height[left.peek()]){
    			left.push(i);
    			i++;
    		}
    		else{	// height[i]<= left.peek(); // find the peek.
    			int element = left.pop();
    			// the left index should be the element in the left of the stack
    			int leftBar = left.isEmpty()?-1:left.peek();	// why is -1? because if it can delete, it means all is larger than it.
    			int rightBar = i;
    			max = Math.max(max, height[element] *(rightBar-leftBar-1));
    		}
    	}
    	int rightBar = height.length;
    	while(!left.isEmpty()){
    		int element = left.pop();
    		int leftBar = left.isEmpty()?-1:left.peek();
    		max = Math.max(max, height[element]*(rightBar-leftBar-1));
    	}
    	return max;
    }
    
    
    public static void main(String[] args){
    	LargestRectangleinHistogram84 test = new LargestRectangleinHistogram84();
    	System.out.println(test.largestRectangleArea_stack(new int[]{2,1,5,6,2,3}));
    }
}
