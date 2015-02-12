package aNext.first.feb12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author PAUL QI
 * 
 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	For example,
	
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	Return
	  [
	    ["hit","hot","dot","dog","cog"],
	    ["hit","hot","lot","log","cog"]
	  ]
	Note:
	All words have the same length.
	All words contain only lowercase alphabetic characters.
 */

public class WordLadderII126 {
    public List<List<String>> findLadders_invalid(String start, String end, Set<String> dict) {
    	List<List<String>> results = new ArrayList<List<String>>();
    	Queue<String> queue = new LinkedList<String>();
    	Map<String,String> store = new HashMap<String, String>();
    	queue.add(start);
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		boolean levelFound = false;
    		for(int i=0; i<size; i++){
    			String s = queue.poll();
    			if(isOneDiff(s,end)){
    				levelFound = true;
    				cacheValue(store, results,end, s);
    			}
    			else if(!levelFound){
    				for(Iterator<String> iter = dict.iterator(); iter.hasNext();){
    					String value = iter.next();
    					if(isOneDiff(s,value)){	
//    						iter.remove();	// this solution is wrong, because we cannot delete it immediately, maybe
    										// at the same level of the parent node, maybe it also be the next child.
    										// we want all the solution, so we cannot delete it immediately.
    						store.put(value, s);
    						queue.add(value);
    					}
    				}
    			}
    		}
    	}
    	return results;
    }
    
    private void cacheValue(Map<String,String> store, List<List<String>> results, String end, String s){
    	List<String> result = new LinkedList<String>();
    	result.add(s);
    	while(store.containsKey(s)){
    		s = store.get(s);
    		result.add(0, s);
    	}
    	result.add(end);
    	results.add(result);
    }
    
    private boolean isOneDiff(String s, String t){
    	int count = 0;
    	for(int i=0;i<s.length(); i++){
    		if(s.charAt(i)!=t.charAt(i)){
    			count++;
    		}
    		if(count>1){
    			return false;
    		}
    	}
    	return count == 1;
    }
    
    public static void main(String[] args){
    	WordLadderII126 test = new WordLadderII126();
    	Set<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dog");
    	dict.add("cog");
    	dict.add("pot");
    	dict.add("dot");
    	List<List<String>> result = test.findLadders("hot", "dog", dict);
    	for(List<String> l: result){
    		for(String s:l){
    			System.out.print(s+" ");
    		}
    		System.out.println();
    	}
    }
}
