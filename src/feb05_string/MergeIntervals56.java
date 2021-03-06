package feb05_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author PAUL QI
 *  
 *  Given a collection of intervals, merge all overlapping intervals.

	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
 */

/**
 * Definition for an interval.
 */
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals56 {
	// O(nlgn) time complexity, O(n) space complexity 
    public List<Interval> merge(List<Interval> intervals) {
    	Collections.sort(intervals, new MyComparator());	// order the interval by start time
    	List<Interval> results = new ArrayList<Interval>();
    	while(!intervals.isEmpty()){
    		Interval temp = intervals.remove(0);
    		while(!intervals.isEmpty() && intervals.get(0).start<=temp.end){	// precondition the intervals start<= all the intervals after it.
    			Interval t =intervals.remove(0);
    			if(t.end>temp.end){
    				temp.end = t.end;
    			}
    		}
    		results.add(temp);
    	}
    	return results;
    }
    
    /*
     *  Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
		You may assume that the intervals were initially sorted according to their start times.
		
		Example 1:
		Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
		
		Example 2:
		Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
		
		This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */
    
    // in-place O(n) solution if the List is LinkedList
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	Collections.sort(intervals, new MyComparator());
    	int i=0;
    	for(;i<intervals.size();){
    		Interval temp = intervals.get(i);
    		if(newInterval.end<temp.start){	// only here use the sort attribute
    			break;
    		}
    		else if(newInterval.end>=temp.start && newInterval.end<=temp.end
    				|| newInterval.start>=temp.start && newInterval.start<=temp.end){	// it means contains relationship
    			intervals.remove(temp);
    			if(temp.end>newInterval.end){
    				newInterval.end = temp.end;
    			}
    			if(temp.start<newInterval.start){
    				newInterval.start = temp.start;
    			}
    		}
    		else if(newInterval.end>=temp.end && newInterval.start<=temp.start){	// it means new interval contains it!
    			intervals.remove(temp);												// if it contains new interval, we don't do anything.
    		}
    		else{
    			i++;
    		}
    	}
    	intervals.add(i, newInterval);
    	return intervals;
    }
    
    class MyComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start-o2.start;
		}
    }
}
