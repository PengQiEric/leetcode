package january28;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PAUL QI
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.

	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	
	Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class LargestNumber179 {
    public String largestNumber(int[] num) {
    	String[] numStrs = new String[num.length];
    	for(int i=0; i<numStrs.length; i++){
    		numStrs[i] = String.valueOf(num[i]);
    	}
        Arrays.sort(numStrs, new SpecialComparator());
        StringBuffer sb = new StringBuffer();
        for(String s: numStrs){
        	sb.append(s);
        }
        if("0".equals(numStrs[0])){
            return "0";
        }
        return sb.toString();
    }
    class SpecialComparator implements Comparator<String>{

    	@Override
    	public int compare(String o1, String o2) {
    		// the for loop can delete
    		for(int i=0,j=0;i<o1.length() && j<o2.length();i++,j++ ){
    			if(o1.charAt(i) > o2.charAt(j)){
    				return -1;
    			}
    			else if(o1.charAt(i)<o2.charAt(j)){
    				return 1;
    			}
    		}
    		return (o2+o1).compareTo(o1+o2);
    	}
    	
    }
    
    public static void main(String[] args){
    	LargestNumber179 test = new LargestNumber179();
    	System.out.println(test.largestNumber(new int[]{3,30,34,5,9}));
    	System.out.println(test.largestNumber(new int[]{1,1,1}));
    }
}

