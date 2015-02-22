package aNext.first.feb21;

import java.util.List;

/**
 * @author PAUL QI
 * 
 *  Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	
	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

 */

public class Triangle120 {
	// it can also bottom-up, this is top-down, but time complexity are the same.
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size() == 0){
    		return 0;
    	}
    	for(int i=1; i<triangle.size(); i++){
    		List<Integer> temp = triangle.get(i);
    		List<Integer> lastLevel = triangle.get(i-1);
    		temp.set(0, temp.get(0)+lastLevel.get(0));
    		temp.set(temp.size()-1, temp.get(temp.size()-1)+lastLevel.get(lastLevel.size()-1));
    		for(int j=1; j<temp.size()-1; j++){
    			int last = Math.min(lastLevel.get(j-1), lastLevel.get(j));
    			int now = temp.get(j);
    			temp.set(j, last+now);
    		}
    	}
    	
    	List<Integer> lastLevel = triangle.get(triangle.size()-1);
    	int min = lastLevel.get(0);
    	for(int i: lastLevel){
    		if(min>i){
    			min = i;
    		}
    	}
    	return min;
    }
}
