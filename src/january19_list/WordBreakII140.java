package january19_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author PAUL QI
 * 
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 *
 */

public class WordBreakII140 {
	// this is accepted solution, but it is ugly!!!
    public List<String> wordBreak(String s, Set<String> dict) {
    	List<Integer> results = new ArrayList<Integer>();
    	results.add(-1);
    	for(int i=0; i<s.length(); i++){
    		for(int j=results.size()-1; j>=0; j--){
    			if(dict.contains(s.substring(results.get(j)+1, i+1))){
    				results.add(i);
    				break;
    			}
    		}
    	}
        if(results.get(results.size()-1) != s.length()-1){
        	return new ArrayList<String>();
        }
        else{
        	 return wordBreak_outofmemory(s,dict);
        }
    }
	
	
	/*
	 * matchedString.add(str+" "+word);
	 * this leads to 
	 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOfRange(Arrays.java:3209)
	at java.lang.String.<init>(String.java:215)
	at java.lang.StringBuilder.toString(StringBuilder.java:430)
	at january19_list.WordBreakII140.wordBreak(WordBreakII140.java:43)
	at january19_list.WordBreakII140.main(WordBreakII140.java:67)
	 */
    public List<String> wordBreak_outofmemory(String s, Set<String> dict) {
        Map<Integer, List<String>> tempResult = new HashMap<Integer, List<String>>();
        List<Integer> indexWord = new ArrayList<Integer>();
        indexWord.add(-1);
        for(int i=0; i<s.length(); i++){
        	List<String> matchedString = new ArrayList<String>();
        	boolean isWord = false;
        	for(int j=indexWord.size()-1; j>=0; j--){
        		int index = indexWord.get(j);
        		String word = s.substring(index+1,i+1); // never forget i+1
        		if(dict.contains(word)){
        			isWord = true;
        			List<String> startPart = tempResult.get(index);
        			if(startPart == null){
        				matchedString.add(word);
        			}
        			else{
        				for(String str: startPart){
        					matchedString.add(str+" "+word);
        				}
        			}
        		}
        	}
        	if(isWord){
        		indexWord.add(i);
        	}
    		tempResult.put(i,matchedString);
        }
        return tempResult.get(s.length()-1);
    }
    
    public static void main(String[] args){
    	WordBreakII140 test = new WordBreakII140();
    	Set<String> dict = new HashSet<String>();
//    	dict.add("cat"); dict.add("and");
//    	dict.add("cats"); dict.add("sand"); dict.add("dog");
    	dict.add("a"); dict.add("aa");
    	dict.add("aaa"); dict.add("aaaa");
    	dict.add("aaaaa"); dict.add("aaaaaa");
    	dict.add("aaaaaaa"); dict.add("aaaaaaaa");
    	dict.add("aaaaaaaaa"); dict.add("aaaaaaaaaa");
//    	dict.add("aaa"); dict.add("sand"); dict.add("dog");
    	List<String> s = test.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict);
    	for(String str:s){
    		System.out.println(str);
    	}
    }
}
