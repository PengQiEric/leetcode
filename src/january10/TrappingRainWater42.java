package january10;

import java.util.Stack;

/**
 * @author Paul Qi
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class TrappingRainWater42 {
    
	public int trap(int[] A) {
	    if (A.length < 2) return 0;

	    int ans = 0;
	    int l = 0, r = A.length - 1;

	    // find the left and right edge which can hold water
	    while (l < r && A[l] <= A[l + 1]) l++;
	    while (l < r && A[r] <= A[r - 1]) r--;

	    while (l < r) {
	        int left = A[l];
	        int right = A[r];
	        if (left <= right) {
	            // add volum until an edge larger than the left edge
	            while (l < r && left >= A[++l]) {
	                ans += left - A[l];
	            }
	        } else {
	            // add volum until an edge larger than the right volum
	            while (l < r && A[--r] <= right) {
	                ans += right - A[r];
	            }
	        }
	    }
	    return ans;
	}
	
	
	public static void main(String[] args){
		TrappingRainWater42 test = new TrappingRainWater42();
		System.out.println(test.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//		System.out.println(test.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}
}
