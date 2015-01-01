package jan1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Paul Qi
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ² b ² c)
 * The solution set must not contain duplicate triplets.
 *  For example, given array S = {-1 0 1 2 -1 -4},
 *  A solution set is:
 *  (-1, 0, 1) (-1, -1, 2)
 */

public class _3Sum15 {
	
	// Time Limit Exceeded
    public static List<List<Integer>> threeSum1(int[] num) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	Arrays.sort(num);
//    	HashMap<Integer, Integer> invertedMap = new HashMap<Integer, Integer>();
//    	for(int i=0; i<num.length; i++){
//    		invertedMap.put(num[i], i);
//    	}
//    	int[][] twosum =  new int[num.length][num.length];
    	for(int i=0; i<num.length; i++){
    		if(i>0 && num[i-1] == num[i])
    			continue;
    		for(int j=i+1; j<num.length; j++){
    			int twosum = -num[i]-num[j];
    				if(twosum>=num[j]){
    					for(int k=j+1; k<num.length; k++){
    						if(num[k] == twosum){
    							List<Integer> sol = new LinkedList<Integer>();
    							sol.add(num[i]);sol.add(num[j]);sol.add(num[k]);
    							result.add(sol);
    						}
    					}
    				}
    		}
    	}
    	
    	return result;
    }
    
	// Time Limit Exceeded
    public static List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	Arrays.sort(num);
    	//java.lang.ArrayIndexOutOfBoundsException
    	for(int i=0; i<num.length-2; i++){
    		if(i>0 && num[i-1] == num[i])
    			continue;
    		
    		//Like the problem of Container With Most Water
    		for(int j=i+1, k= num.length-1; j<k;){
						if((num[i]+num[j]+num[k]) == 0){
							List<Integer> sol = new LinkedList<Integer>();
							sol.add(num[i]);sol.add(num[j]);sol.add(num[k]);
							result.add(sol);
							do{
								j++;
							}while(j<k && num[j] == num[j-1]);
							do{
								k--;
							}while(j<k && num[k] == num[k+1]); //java.lang.ArrayIndexOutOfBoundsException
						}
						else if((num[i]+num[j]+num[k])<0){
							do{
								j++;
							}while(j<k && num[j] == num[j-1]);
						}
						else{
							do{
								k--;
							}while(j<k && num[k] == num[k+1]);						
						}
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args){
    	System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());
    	System.out.println(threeSum(new int[]{0, 0, 0}).toString());
    	System.out.println(threeSum(new int[]{0, 0, 0, 0}).toString());
    }
}
