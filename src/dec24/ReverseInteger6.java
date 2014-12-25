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
        Queue<Integer> digits = new LinkedList<Integer>();
        int result=0;
        boolean isPos = x>0?true:false;
        while(x%10 == 0)x = x/10;
        
        while(x!=0){ // cannot use x>0 because x may be negative
        	digits.offer(x%10);
        	x = x/10;
        }
        
        while(!digits.isEmpty()){
        	result = result*10 + digits.poll();
        }
        
        // overflow
        if((isPos && result<0) || (!isPos && result>0)){
        	return 0;
        }
        
        return result;
    }
	
	public static void main(String[] args){
		System.out.println(reverse(-123));
		System.out.println(reverse(-10002));
		System.out.println(reverse(1000000003));
	}
}
