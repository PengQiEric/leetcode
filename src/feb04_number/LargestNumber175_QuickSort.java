package feb04_number;


public class LargestNumber175_QuickSort {
	// this is an old way quick sort
	// now JAVA implements the three-way partition quick sort., and the partition part is kind of SortColors.
	
	private int compare(String s1, String s2){
		return (s2+s1).compareTo(s1+s2);
	}
	
	private void swap(String[] strs, int i, int j){
		String temp = strs[i];
		strs[i] = strs[j];
		strs[j] = temp;
	}
	
	// implement partition by myself again.
	private int partition(String[] strs, int low, int high){
		int i= low, j = high;
		while(i<j){
			while(i<=high && compare(strs[low], strs[i])>=0){
				i++;
			}
			while(j>= low && compare(strs[low], strs[j])<0){
				j--;
			}
			if(i<j){
				swap(strs,i,j);
			}
		}
		swap(strs,low,j);
		return j;
	}
	
	private int partition_1(String[] strs, int low, int high){
		
		int i = low, j = high+1;
		while(true){
			while(compare(strs[++i],strs[low])<0){
				if(i == high) break;	// break is only break the inner-loop.
			}
			while(compare(strs[--j],strs[low])>0){
				if(j == low) break;
			}
			
			if(i>=j)break;
			swap(strs,i,j);
		}
		swap(strs,low,j);
		return j;
	}
	
	private void sort(String[] strs, int low, int high){
		if(high<=low){
			return;
		}
		int j = partition(strs, low, high);
		sort(strs,low,j-1);
		sort(strs,j+1,high);
	}
	
    public String largestNumber(int[] num) {
    	String[] numStrs = new String[num.length];
    	for(int i=0; i<numStrs.length; i++){
    		numStrs[i] = String.valueOf(num[i]);
    	}
        sort(numStrs, 0, numStrs.length-1);
        StringBuffer sb = new StringBuffer();
        for(String s: numStrs){
        	sb.append(s);
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
    	LargestNumber175_QuickSort test = new LargestNumber175_QuickSort();
    	System.out.println(test.partition(new String[]{"30","40","50"},0,2));
    	System.out.println(test.largestNumber(new int[]{3,30,34,5,9}));
    	System.out.println(test.largestNumber(new int[]{1,1,1}));
    }
}
