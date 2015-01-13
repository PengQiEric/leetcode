package jan5;

/**
 * @author Paul Qi
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class NextPermutation31 {
	//wrong!!!!
    public static void nextPermutation_cannot_find_the_rule(int[] num) {
    	int i;
    	int increament = -1;
    	int val = 0;
    	for(i=num.length-1; i>0; i--){
    		if(num[i]>num[i-1]&& increament<0){
    			int temp = num[i];
    			num[i] = num[i-1];
    			num[i-1] = temp;
    			break;
    		}
    		else if(num[i]<=num[i-1] && increament<0){
    			increament = i;
    			val = num[increament];
    			num[increament] = num[i-1];
    		}
    		else if(num[i]<=num[i-1] && increament>=0){
    			num[i] = num[i-1];
    		}
    		else if(num[i]>num[i-1] && increament>=0){
    			num[i] = num[i-1];
    			num[i-1] = val;
    			break;
    		}
    	}
    	if(i == 0){
    		if(increament>0){
    			for(int k=1; k<increament; k++){
    				num[k] = num[k+1];
    			}
        		num[increament] = val;
    		}
    		for(int k=0,j=num.length-1;k<j; k++,j--){
    			int temp = num[k];
    			num[k] = num[j];
    			num[j] = temp;
    		}
    	}
    }
    
    /*
     * 1. Start from its last element, traverse backward to find the first one 
     *    with index i that satisfy num[i-1] < num[i]. So, elements from num[i] to num[n-1] is reversely sorted.
     * 2. To find the next permutation, we have to swap some numbers at different positions, 
     *    to minimize the increased amount, we have to make the highest changed position as high as possible. 
     *    Notice that index larger than or equal to i is not possible as num[i,n-1] is reversely sorted. 
     *    So, we want to increase the number at index i-1, 
     *    clearly, swap it with the smallest number between num[i,n-1] that is larger than num[i-1]. 
     *    For example, original number is 121543321, we want to swap the '1' at position 2 with '2' at position 7.
     * 3. The last step is to make the remaining higher position part as small as possible, 
     *    we just have to reversely sort the num[i,n-1]
     */
    
    public static void nextPermutation(int[] num) {
    	
    	int i;
    	for(i=num.length-1; i>0; i--){
    		if(num[i-1]<num[i])break;
    	}
    	
    	if(i==0){
    		for(int j=0,k=num.length-1; j<k; j++,k--){
    			swap(num,j,k);
    		}
    	}
    	else{
    		for(int j=num.length-1; j>=i; j--){
    			if(num[j]>num[i-1]){
    				swap(num,i-1,j);
    				break;
    			}
    		}
    		for(int j=i,k=num.length-1; j<k; j++,k--){
    			swap(num,j,k);
    		}
    	}
    }
    
    private static void swap(int[] num, int i, int j){
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
    
    public static void main(String[] args){
    	// 1,5,4,2 5,1,1      2,1,3,4
    	int[] num = new int[]{1,5,4,2};
//    	int[] num = new int[]{3,2,1};
//    	int[] num = new int[]{1};
//    	int[] num = new int[]{1,3,2};
    	nextPermutation(num);
    	for(int i: num){
    		System.out.print(i+" ");
    	}
    }
}
