package january13;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence60_refer {

	/**
	 * this is a great solution based on some common idea.
	 * 
	 * It makes me think about how to relate some math knowledge to the computer computing.
	 * For this specified question, we can find that :
	 * if the highest number is a specified digit less than n, it has (n-1)! permutation.
	 * 
	 * then we use k-1 / (n-1)! then we can get the highest digit. 
	 * Why we need to use k-1 not k, think about 1,2,3, and we want the 6, 
	 * then we should use 2 not 3 to get the last element in the array. 
	 */
	
    public String getPermutation(int n, int k) {
    	
    	List<Integer> digits = new ArrayList<Integer>();
    	for(int i=0; i<n; i++){
    		digits.add(i+1);
    	}
    	int[] counts = new int[n];
    	counts[0] = 1;
    	for(int i=1; i<n; i++){
    		counts[i] = i*counts[i-1];
    	}
    	
    	String result = "";
    	k = k-1;	// why do that? For index begin with 0?
    	while(n>0){
    		int digit = k/counts[n-1];
    		result += digits.remove(digit);
    		k = k%counts[n-1];
    		n--;
    	}
    	
    	return result;
    }
    
    public static void main(String[] args){
    	PermutationSequence60_refer test = new PermutationSequence60_refer();
//    	System.out.println(test.getPermutation(3, 0));
    	
    	
    	long d = (long)-2147483648 / -1;
    	System.out.println(d*-1 == -2147483648);
    }
}
