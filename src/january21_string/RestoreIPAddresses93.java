package january21_string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PAUL QI
 * 
 *  Given a string containing only digits, restore it by returning all possible valid IP address combinations.

	For example:
	Given "25525511135",
	return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

public class RestoreIPAddresses93 {
	private List<String> rs = new ArrayList<String>();
    
	public List<String> restoreIpAddresses(String s) {
		if(s.length()>=4 && s.length()<=12){
			int[] nums = new int[3];
			restoreHelper(nums, 0, 0, 3, s);
		}
        return rs;
    }
    
	/*
	 * test case:
	 * "010010"
	 */
    private void restoreHelper(int[] nums, int start, int i, int k, String s){
    	if(i == k){
    		if(start>s.length()-1){ 	// test case "0000"
    			return;
    		}
    		if(start !=s.length()-1 && s.charAt(start) == '0'){ // test case "010010"
    			return;
    		}
    		
    		long lastPart = Integer.parseInt(s.substring(start));
    		if(lastPart>=0 && lastPart<=255){
    			constructResult(nums, s);
    		}
    		return;
    	}
    	for(int j=start; j<s.length() && j<=start+2; j++){
    		nums[i] = j;
    		if(j!=start && s.charAt(start) == '0'){ //// test case "010010"
    			continue;
    		}
    		if(j == start+2){
    			if(Integer.parseInt(s.substring(start,j+1))>255){
    				continue;
    			}
    		}
    		restoreHelper(nums, j+1, i+1, k, s);
    	}
    }
    
    private void constructResult(int[] nums, String s){
    	String result = s.substring(0,nums[0]+1)+"."+s.substring(nums[0]+1,nums[1]+1)
    						+"."+s.substring(nums[1]+1, nums[2]+1)+"."+s.substring(nums[2]+1);
    	rs.add(result);
    }
    
    public static void main(String[] args){
    	RestoreIPAddresses93 test = new RestoreIPAddresses93();
//    	List<String> result = test.restoreIpAddresses("25525511135");
//    	List<String> result = test.restoreIpAddresses("0000");
    	List<String> result = test.restoreIpAddresses("010010");
    	for(String s:result){
    		System.out.println(s);
    	}
    }
}
