package january26;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131_anotherbacktracking {
	private List<List<String>> results = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
    	if("".equals(s)){
    		return results;
    	}
    	partitionHelper(0, s, new ArrayList<String>());
    	return results;
    }
    
    private void partitionHelper(int start, String s, List<String> result){
    	if(start == s.length()){
    		results.add(new ArrayList<String>(result));
    		return;
    	}
    	
    	for(int i=start; i<s.length(); i++){
    	    String temp = s.substring(start,i+1);
    	    if(check(temp)){	// check whether it is possible solution before we move to the next step.
    		    result.add(temp);
    		    partitionHelper(i+1, s, result);
    		    result.remove(result.size()-1);
    	    }
    	}
    }
    
    
    private boolean check(String temp){
    	for(int i=0,j=temp.length()-1;i<j;i++,j--){
    		if(temp.charAt(i)!= temp.charAt(j)){
    			return false;
    		}
    	}
    	return true;
    }
}
