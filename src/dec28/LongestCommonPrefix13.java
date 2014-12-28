package dec28;


/**
 * @author Paul Qi
 *	Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix13 {
	// O(n*C); maybe we can order the strings first based on the length of the strings 
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0){
    		return "";
    	}
    	
        for(int i=0; i<strs[0].length(); i++){
        	boolean isCommon = true;
        	for(int j=1; j<strs.length; j++){
        		if(strs[j].length()<(i+1) || strs[j].charAt(i) != strs[0].charAt(i)){
        			isCommon = false; break;
        		}
        	}
        	if(!isCommon){
        		if(i == 0) return "";
        		else
        			return strs[0].substring(0,i);
        	}
        }
        return strs[0];
    }
    
    public static void main(String[] args){
    	System.out.println(longestCommonPrefix(new String[]{"abc","ab","a"}));
    }
}
