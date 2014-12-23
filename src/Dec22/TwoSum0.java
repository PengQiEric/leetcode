package Dec22;

import java.util.HashMap;

/**
 * @author Paul Qi requirement Given an array of integers, find two numbers such
 *         that they add up to a specific target number. The function twoSum
 *         should return indices of the two numbers such that they add up to the
 *         target, where index1 must be less than index2. Please note that your
 *         returned answers (both index1 and index2) are not zero-based. You may
 *         assume that each input would have exactly one solution. Input:
 *         numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSum0 {
	public static void main(String[] args) {
		System.out.println("I am back, Java!");
		int[] result = twoSum(new int[]{2,7,11,15},9);
		if(result!=null){
			for(int i: result){
				System.out.println(i);
			}
		}
	}
	public static int[] twoSum(int[] numbers, int target){
		HashMap<Integer, Integer> invertedMap = new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++){
			if(invertedMap.containsKey(target-numbers[i])){
				return new int[]{invertedMap.get(target-numbers[i])+1,i+1};
			}
			invertedMap.put(numbers[i], i);
		}
		return null;
	}
}
