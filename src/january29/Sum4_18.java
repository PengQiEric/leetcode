package january29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PAUL QI
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

	Note:
	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ² b ² c ² d)
	The solution set must not contain duplicate quadruplets.
	    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
	
	    A solution set is:
	    (-1,  0, 0, 1)
	    (-2, -1, 1, 2)
	    (-2,  0, 0, 2)
 */

public class Sum4_18 {
    public static List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	Arrays.sort(num);
    	// O(n^3)
    	for(int i=0; i<num.length-3; i++){	// test case [-2,-1,0,0,1,2]
    		if(i!=0 && num[i] == num[i-1]){
    			continue;
    		}
    		for(int j=i+1; j<num.length-2; j++){
    			if(j!=i+1 && num[j-1] == num[j]){
    				continue;
    			}
    			int left = target - num[i] - num[j];
    			// two pointers
    			for(int p=j+1,q=num.length-1; p<q;){
    				if(num[p] + num[q] == left){
    					List<Integer> result = new ArrayList<Integer>();
    					result.add(num[i]); result.add(num[j]); result.add(num[p]);result.add(num[q]);
    					results.add(result);
//    					break;		// cannot break; test case [-3,-2,-1,0,0,1,2,3]
    					
    					do{
    						p++;
    					}while(p<=q && num[p] == num[p-1]);
    					do{
    						q--;
    					}while(q>=p && num[q] == num[q+1]);
    					
    				}
    				else if(num[p]+num[q]<left){
    					do{
    						p++;
    					}while(p<=q && num[p] == num[p-1]);
    				}
    				else{
    					do{
    						q--;
    					}while(q>=p && num[q] == num[q+1]);
    				}
    			}
    		}
    	}
    	return results;
    }
    
    // with unorder_multimap, we can solve this problem in O(n^2), unfortunately, java does not have this tool
    public static List<List<Integer>> fourSumHashMap(int[] num, int target){
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	Map<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();
    	Arrays.sort(num);
    	for(int i=0; i<num.length-1; i++){
    		for(int j=i+1; j<num.length; j++ ){
    			List<Integer> temp = new ArrayList<Integer>();
    			temp.add(num[i]);
    			temp.add(num[j]);
    			
    		}
    	}
    	
    	
    	return results;
    }
    
    public static void main(String[] args){
    	List<List<Integer>> result =  Sum4_18.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
    	for(List<Integer> l:result){
    		for(Integer i: l){
    			System.out.print(i+" ");
    		}
    	}
    }
}
