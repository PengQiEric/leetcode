package aNext.first.feb20;

/**
 * @author PAUL QI
 * 
 *  Given two numbers represented as strings, return multiplication of the numbers as a string.

	Note: The numbers can be arbitrarily large and are non-negative.
 */

public class MultiplyStrings43 {
    public String multiply(String num1, String num2) {
    	int[] result = new int[num1.length()+num2.length()];
    	
    	num1 = new StringBuffer(num1).reverse().toString();
    	num2 = new StringBuffer(num2).reverse().toString();
    	
    	for(int i=0; i<num1.length(); i++){
    		for(int j=0; j<num2.length(); j++){
    			result[i+j] += (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
    			result[i+j+1] += result[i+j]/10;
    			result[i+j] %=10;
    		}
    	}
    	int i = result.length-1;
    	while(i>=0 && result[i] == 0){
    		i--;
    	}
    	StringBuffer sb = new StringBuffer();
    	while(i>=0){
    		sb.append(result[i]);
    		i--;
    	}
    	return sb.length() == 0? "0":sb.toString();
    }
    
    
    /*
     * Binary Add
     */
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i>=0 || j>=0){
            if(i>=0){
                carry += a.charAt(i)-'0';
                i--;
            }
            
            if(j>=0){
                carry += b.charAt(j)-'0';
                j--;
            }
            sb.append(carry%2);
            carry = carry/2;
        }
        if(carry == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
