package jan1;

import java.util.Arrays;

/**
 * @author Paul Qi
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class _3SumClosest16 {

    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = 0;
        int variance = Integer.MAX_VALUE;
        for(int i=0; i<num.length-2; i++){ // why length-2, assume {0,0,0},it should be 3-2
        	if(i>0 && num[i-1] == num[i])
        		continue;
        	/* I don't know how to describe the two pointers problem. 
        	 */
        	for(int j=i+1, k=num.length-1; j<k;){
        		int sol = num[i]+num[j]+num[k];
        		if(sol == target){
        			return target;
        		}
        		else if(sol < target){
        			j++;
        		}
        		else{
        			k--;
        		}
    			if(Math.abs(target - sol) < variance){
    				variance = Math.abs(target - sol);
    				result = sol;
    			}
        	}
        }
    	return result;
    }
    
    public static void main(String[] args){
    	System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    	System.out.println(threeSumClosest(new int[]{1,1,1,0}, 100));
    }
    
}
