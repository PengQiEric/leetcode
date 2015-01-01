package dec25;

/**
 * Greedy Algorithm
 * @author Paul Qi
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container. (height * width = container)
 * 
 * brute force O(n^2)
 * 
 * I don't find a good way to divide and conquer, because I cannot find a good way to combine the result
 * I try to order the height based on the height, still I cannot find a good way to reduct from O(n^2) to ??
 */

public class ContainerWithMostWater10 {
	//we can use greedy to do that, I refer to others solution, it's so great!
    public static int maxArea(int[] height) {
    	int i = 0, j=height.length-1;
    	int mx = 0;
    	while(i<j){
    		mx = Math.max(mx, (j-i)*Math.min(height[i], height[j]));
    		
    		
    		if(height[i]<height[j]){
    			i++;
    		}
    		else{
    			j--;
    		}
    	}
    	
    	return mx;
    }
    
    public static int maxArea1(int[] height){
    	int i = 0, j=height.length-1;
    	int mx = 0;
    	while(i<j){
    		mx = Math.max(mx, (j-i)*Math.min(height[i], height[j]));
    		
    		if(height[i]<height[j]){
    			do{
    				i++;
    			}while(i<j&& height[i-1]>=height[i]);
    		}
    		else{
    			do{
    				j--;
    			}while(i<j && height[j+1]>=height[j]);
    		}
    		
    	}
    	
    	return mx;
    }
	
	public static void main(String[] args){
		
	}
}
