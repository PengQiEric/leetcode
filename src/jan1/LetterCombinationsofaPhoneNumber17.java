package jan1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Paul Qi
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * A combination problem
 */

public class LetterCombinationsofaPhoneNumber17 {
    public static List<String> letterCombinations(String digits) {
    	String[] mapChars = new String[11];
    	// init map
    	mapChars[0] = ""; mapChars[1] = "";
    	mapChars[2] = "abc";
    	mapChars[3] = "def";
    	mapChars[4] = "ghi";
    	mapChars[5] = "jkl";
    	mapChars[6] = "mno";
    	mapChars[7] = "pqrs";
    	mapChars[8] = "tuv";
    	mapChars[9] = "wxyz";
    	List<String> result =  new LinkedList<String>();
    	
    	if(digits.equals("")){
//    	if(digits == ""){
    		result.add("");
    		return result;
    	}
    	
    	int curCount = 0;
    	for(int i=0; i<digits.length(); i++){
    		if(curCount == 0){
    			int mapNum = digits.charAt(i)-48;
    			String chars = mapChars[mapNum];
    			for(int j=0; j<chars.length(); j++){
    				result.add(Character.toString(chars.charAt(j)));
    			}
    			curCount = chars.length();
//    			System.out.println(result.toString());
    		}
    		else{
    			String chars = mapChars[digits.charAt(i)-48];
    			for(int j=0; j<curCount; j++){
    				String s = result.remove(0);
    				for(int k=0; k<chars.length(); k++){
    					result.add(s+chars.charAt(k));
//    					System.out.println(result.toString());
    				}
    			}
    			curCount = curCount * chars.length();
//    			System.out.println(result.toString());
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args){
//    	System.out.println(letterCombinations("23").toString());
    	System.out.println(letterCombinations("").toString());
    }
}
