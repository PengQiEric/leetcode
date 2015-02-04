package january29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PAUL QI
 *
 *  Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

	Try to solve it in linear time/space.
	
	Return 0 if the array contains less than 2 elements.
	
	You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */

public class MaximumGap164 {
	//http://cgm.cs.mcgill.ca/~godfried/teaching/dm-reading-assignments/Maximum-Gap-Problem.pdf
	// great solution based on pigeon hole principle
    public int maximumGap(int[] num) {
    	if(num.length <= 1)	// []
    		return 1;
    	if(num.length == 2)
    		return Math.abs(num[1]-num[0]);
    	
    	int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    	for(int i: num){
    		if(i<min)
    			min = i;
    		if(i>max)
    			max = i;
    	}
    	
    	double bucketDelta = (double)(max-min)/(num.length-1);
    	List<Integer>[] buckets = new List[num.length-1];
    	for(int i=0; i<num.length-1; i++){
    		buckets[i] = new ArrayList<Integer>();
    	}
    	
    	for(int i: num){
    		if(i>min && i<max){
    			int index = (int) Math.floor((i-min)/bucketDelta);
    			buckets[index].add(i);
    		}
    	}
    	
    	int diff = 0;
    	int preMax = buckets[0].size() == 0? min: getMax(buckets[0]);
    	for(int i=1; i<buckets.length; i++){
    		if(!buckets[i].isEmpty()){
    			int curMin = getMin(buckets[i]);
    			diff = curMin-preMax>diff? curMin-preMax: diff;
    			
    			preMax = getMax(buckets[i]);
    		}
    	}
    	
    	if(buckets[buckets.length-1].isEmpty()){
    		diff = diff> max-preMax? diff: max-preMax;
    	}
    	
    	return diff;
    	
    }
    
    private int getMax(List<Integer> list){
    	int max = Integer.MIN_VALUE;
    	for(Integer i: list){
    		if(max<i)
    			max = i;
    	}
    	return max;
    }

    private int getMin(List<Integer> list){
    	int min = Integer.MAX_VALUE;
    	for(Integer i: list){
    		if(min>i)
    			min = i;
    	}
    	return min;
    }
    
    public static void main(String[] args){
    	MaximumGap164 test = new MaximumGap164();
    	System.out.println(test.maximumGap(new int[]{3,6,9,1}));
    }
}
