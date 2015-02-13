package january19_list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author PAUL QI
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode",dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreak139 {
	// it is kind of DP, but we only need to share the same list
    public boolean wordBreak(String s, Set<String> dict) {
    	List<Integer> results = new ArrayList<Integer>();	// record the result, I mean the position can break as word
    	results.add(-1);
    	for(int i=0; i<s.length(); i++){
    		for(int j=results.size()-1; j>=0; j--){
    			if(dict.contains(s.substring(results.get(j)+1, i+1))){
    				results.add(i);
    				break;
    			}
    		}
    	}
    	return results.get(results.size()-1) == s.length()-1;
    }
    
    public static void main(String[] args){
    	WordBreak139 test = new WordBreak139();
    	Set<String> dict = new HashSet<String>();
//    	dict.add("leet"); dict.add("code");
    	dict.add("a"); dict.add("aa");
    	dict.add("aaa"); dict.add("aaaa");
    	dict.add("aaaaa"); dict.add("aaaaaa");
    	dict.add("aaaaaaa"); dict.add("aaaaaaaa");
    	dict.add("aaaaaaaaa"); dict.add("aaaaaaaaaa");
    	System.out.println(test.wordBreak("leetcode", dict));
    	System.out.println(test.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
    }
}
