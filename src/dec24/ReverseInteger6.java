package dec24;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Paul Qi
 * Reverse digits of an integer.
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? 
 * Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 */

public class ReverseInteger6 {
    public static int reverse(int x) {
        int result=0;        
        while(x!=0){ // cannot use x>0 because x may be negative
            // overflow
        	if(result > 214748364 || (result == 214748364 && x%10>=7) || result < -214748364 || (result == -214748364 && x%10<-6)){
        		return 0;
        	}
        	result = result*10 + x%10;
        	x = x/10;
        }
        return result;
    }
	
	public static void main(String[] args){
		System.out.println(reverse(-123));
		System.out.println(reverse(1000));
		System.out.println(reverse(1563847412));
		System.out.println(reverse(-2147483648));
	}
}
