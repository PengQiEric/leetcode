package january26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PAUL QI
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.

	Return all possible palindrome partitioning of s.
	
	For example, given s = "aab",
	Return
	
	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]
	  
 */

public class PalindromePartitioning131 {
	private List<List<String>> results = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
    	if("".equals(s)){
    		return results;
    	}
    	partitionHelper(0, s, new ArrayList<String>());
    	return results;
    }
    
    private void partitionHelper(int start, String s, List<String> result){
    	if(result.size()!=0){				// when to check which this is a proper result? this is one way.
    		if(!check(result)){
    			return;
    		}
    	}
    	if(start == s.length()){
    		results.add(new ArrayList<String>(result));
    		return;
    	}
    	
    	for(int i=start; i<s.length(); i++){
    		result.add(s.substring(start,i+1));
    		partitionHelper(i+1, s, result);
    		result.remove(result.size()-1);
    	}
    }
    
    
    private boolean check(List<String> result){
    	String temp = result.get(result.size()-1);
    	for(int i=0,j=temp.length()-1;i<j;i++,j--){
    		if(temp.charAt(i)!= temp.charAt(j)){
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	PalindromePartitioning131 test = new PalindromePartitioning131();
    	List<List<String>> results = test.partition("abb");
    	for(List<String> t: results){
    		for(String s: t){
    			System.out.print(s+" ");
    		}
    		System.out.println();
    	}
    }
}
