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
	/*
	 * BFS is better for finding the minimum length of shortest path 
	 * while DFS is better for finding the actual shortest path.
	 */
	
	List<List<String>> results = new ArrayList<List<String>>();
	Map<String,List<String>> store = new HashMap<String, List<String>>();
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	Queue<String> queue = new LinkedList<String>();
    	queue.add(start);
    	int level = 0; // why we need this, because we need to know when to stop the DFS.
    				  // why we cannot use the start key not in the map to stop? because dict may contains it!
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		boolean levelFound = false;
    		Set<String> visited = new HashSet<String>();
    		for(int i=0; i<size; i++){
    			String s = queue.poll();
    			if(isOneDiff(s,end)){
    				levelFound = true;
    				List<String> re = new ArrayList<String>();
    				re.add(end);
    				cacheValue(re, s, level);
    			}
    			else if(!levelFound){
    				for(Iterator<String> iter = dict.iterator(); iter.hasNext();){
    					String value = iter.next();
    					if(isOneDiff(s,value)){	
//    						iter.remove();	// this solution is wrong, because we cannot delete it immediately, maybe
    										// at the same level of the parent node, maybe it also be the next child.
    										// we want all the solution, so we cannot delete it immediately.
    						if(store.containsKey(value)){
    							List<String> temp = store.get(value);
    							temp.add(s);
    							store.put(value,temp);
    						}
    						else{
    							List<String> temp = new ArrayList<String>();
    							temp.add(s);
    							store.put(value, temp);
    						}
    						if(!visited.contains(value)){
    							queue.add(value);
    						}
    						visited.add(value);
    					}
    				}
    			}
    		}
    		dict.removeAll(visited);	// delete all this level nodes
    		level++;
    	}
    	return results;
    }
    
    // DFS get results
    private void cacheValue(List<String> re, String s, int depth){
    	if(depth>0){
    		List<String> list = store.get(s);
    		re.add(0,s);
    		for(String str: list){
    			cacheValue(re,str,depth-1);
    		}	
    		re.remove(0);
    	}
    	else{
    		re.add(0, s);
    		results.add(new ArrayList<String>(re));
    		re.remove(0);
    	}
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
    	dict.add("ted");
    	dict.add("tex");
    	dict.add("red");
    	dict.add("tax");
    	dict.add("tad");
    	dict.add("den");
    	dict.add("rex");
    	dict.add("pee");
    	List<List<String>> result = test.findLadders("red", "tax", dict);
    	for(List<String> l: result){
    		for(String s:l){
    			System.out.print(s+" ");
    		}
    		System.out.println();
    	}
    }
}
