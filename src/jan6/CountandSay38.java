package jan6;


/**
 * @author Paul Qi
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */

public class CountandSay38 {
    public String countAndSay(int n) {
    	String result = "1";
    	for(int i=2; i<=n; i++){
    		result = countHelper(result);
    	}
    	return result;
    }
    
    private String countHelper(String n){
    	String result="";
    	int index=0;
    	while(index<n.length()){
    		char i = n.charAt(index);
    		int j = 1;
    		while(++index<n.length() && i == n.charAt(index)){
    			j++;
    		}
    		result += j+""+i;
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	CountandSay38 test = new CountandSay38();
    	System.out.println(test.countAndSay(5));
    }
}
