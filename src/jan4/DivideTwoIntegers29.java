package jan4;

/**
 * @author Paul Qi
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */

public class DivideTwoIntegers29 {
    public static int divide_slow(int dividend, int divisor) {
        int i = 1;
    	if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)){
    		i = -1;
    	}
    	int x = Math.abs(dividend), y = Math.abs(divisor);
    	int j = 0;
    	while(x>=y){
    		x -= y;
    		j++;
    	}
    	return i*j;
    }
    
    // it is still not good enough
    public static int divide_seperate(int dividend, int divisor) {
        int positive = 1;
    	if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)){
    		positive = -1;
    	}
    	int x = Math.abs(dividend), y = Math.abs(divisor);
    	String xStr = Integer.toString(x), yStr = Integer.toString(y);
    	int remain = 0;
    	String result = "";
    	for(int i=0; i<xStr.length(); i+=yStr.length()){
    		int j = 0;
    		int divend = Integer.parseInt(xStr.substring(i, i+yStr.length()));
    		// 5000/300 
    	}
    	
    	return 0;
    }    
    
    public static int divide(int dividend, int divisor) {
        int positive = 1;
        long dividendL = dividend, divisorL = divisor;
    	if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)){
    		positive = -1;
    	}
    	long result=0;
    	long x = Math.abs(dividendL), y = Math.abs(divisorL);
    	for(long t=0,i=31;i>=0; i--){
    		long k = y<<i;
    		if((t+k) <= x){
    			t += y<<i;
    			result |= 1L<<i;
    		}
    	}
    	
    	result = positive<0? -result:result;
    	
    	return result>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)result;
    }

    
    public static void main(String[] args){
//    	System.out.println(divide(8,4));
//    	System.out.println(divide(2147483647,1));
//    	System.out.println(divide(-2147483648,-1));
    	System.out.println(divide(-2147483648,1));
//    	System.out.println("123".substring(0,4));
    }
}
