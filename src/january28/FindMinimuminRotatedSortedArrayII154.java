package january28;

/**
 * @author PAUL QI
 * The array may contain duplicates.
 */

public class FindMinimuminRotatedSortedArrayII154 {
	public int findMin(int[] num){
		int begin = 0, end = num.length-1;
		while(begin<end){  // [1,2,2]  [3,2,2,2]  [5,5,5,3,5]
			int median = (begin+end)/2;
			if(num[median]<num[end]){
				end = median;
			}
			else if(num[median]>num[end]){
				begin = median+1;
			}
			else if(num[begin]<num[median]){ // imply num[median] = num[end]
				return num[begin];
			}
			else if(num[begin] > num[median]){
				end = median;
			}
			else{
				begin ++;
				end --;
			}
		}
		return num[begin];
	}
}
