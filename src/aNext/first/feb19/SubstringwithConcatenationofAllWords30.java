package aNext.first.feb19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PAUL QI
 * 
 *  You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

	For example, given:
	S: "barfoothefoobarman"
	L: ["foo", "bar"]
	
	You should return the indices: [0,9].
	(order does not matter).
 */

public class SubstringwithConcatenationofAllWords30 {
	// great refer from http://n00tc0d3r.blogspot.com/2013/06/substring-with-concatenation-of-all.html
	// basic idea is we do not need to check some strings multiple times
	// this algorithm will cost O(kn) k is the length of the one word in the array.
	public List<Integer> findSubString(String s, String[] L){
		List<Integer> re = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int length = L[0].length();
		for(int i = 0; i<length; i++){
			init(L, map);
			int start = i;
			int count = 0;
			int end = start;
			while(end<= s.length()-length){
				String sub = s.substring(end, end+length);
				if(map.containsKey(sub) && map.get(sub)>0){
					count ++ ;
					map.put(sub, map.get(sub)-1);
					end += length;
				}
				else if(map.containsKey(sub)){
					String sameString = s.substring(start, start+length);
					while(!sameString.equals(sub)){
						start = start + length;
						map.put(sameString, map.get(sameString)+1);
						count--;
						sameString = s.substring(start,start+length);
					}
					start = start+length;
					end += length;
				}
				else{
					end = end + length;
					start = end;
					count = 0;
					init(L, map);
				}
				if(count == L.length){
					re.add(start);
				}
			}
		}
		return re;
	}
	
	
	// time complexity O(n*(n+m(m initialize the map))), space complex O(n); 
    public List<Integer> findSubstring(String S, String[] L) {
    	Map<String,Integer> ori = new HashMap<String,Integer>();
    	init(L, ori);
    	List<Integer> re = new ArrayList<Integer>();

    	
    	int dis = L[0].length();
    	int length = L.length*dis;
        int start = 0;
        while(start<=S.length()-length){
        	int poss = start;
        	int count = 0;
        	String temp = S.substring(start, start+dis);
        	while(ori.containsKey(temp) && ori.get(temp)>0){
        		count++;
        		ori.put(temp, ori.get(temp)-1);
        		if(count == L.length){
        			re.add(poss);
        			break;
        		}
        		start = start+dis;
        		temp = S.substring(start,start+dis);
        	}
        	start = poss+1;
        	ori.clear();
        	init(L,ori);
        }
        return re;
    }
    
    private void init(String[] L, Map<String, Integer> ori){
    	ori.clear();
    	for(String s: L){
    		if(ori.containsKey(s)){
    			ori.put(s, ori.get(s)+1);
    		}
    		else{
    			ori.put(s, 1);
    		}
    	}
    }
    
    public static void main(String[] args){
    	SubstringwithConcatenationofAllWords30 test = new SubstringwithConcatenationofAllWords30();
//    	List<Integer> re = test.findSubString("barfoothefoobarman", new String[]{"foo", "bar"});
//    	List<Integer> re = test.findSubString("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"});
//    	List<Integer> re = test.findSubString("aaa", new String[]{"a","a"});
//    	List<Integer> re = test.findSubString("abababab", new String[]{"a","b","a"});
    	List<Integer> re = test.findSubString("abababab", new String[]{"ab","ba"});
//    	List<Integer> re = test.findSubString("aaaaaaaa", new String[]{"aa","aa","aa"});
    	for(Integer i: re){
    		System.out.print(i+" ");
    	}
    }
}
