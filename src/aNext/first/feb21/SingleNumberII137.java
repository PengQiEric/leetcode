package aNext.first.feb21;

/**
 * @author PAUL QI
 *  
 *  Given an array of integers, every element appears three times except for one. Find that single one.

	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	
 */

public class SingleNumberII137 {
    public int singleNumber(int[] A) {
    	int res = 0;
    	for(int i=0; i<32; i++){
    		int re = 0;
    		for(int x: A){
    			if((x>>i & 0x1) == 1){
    				re  += 1;
    				re = re%3;	// it's kind of bit vector
    			}
    		}
    		res += re<<i;
    	}
    	return res;
    }
}
