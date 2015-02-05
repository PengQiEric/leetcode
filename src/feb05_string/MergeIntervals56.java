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
    public List<Interval> merge(List<Interval> intervals) {
    	Collections.sort(intervals, new MyComparator());	// order the interval by start time
    	List<Interval> results = new ArrayList<Interval>();
    	while(!intervals.isEmpty()){
    		Interval temp = intervals.remove(0);
    		while(!intervals.isEmpty() && intervals.get(0).start<=temp.end){
    			Interval t =intervals.remove(0);
    			if(t.end>temp.end){
    				temp.end = t.end;
    			}
    		}
    		results.add(temp);
    	}
    	return results;
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	Collections.sort(intervals, new MyComparator());
    	int i=0;
    	for(;i<intervals.size();){
    		Interval temp = intervals.get(i);
    		if(newInterval.end<temp.start){
    			break;
    		}
    		else if(newInterval.end>=temp.start && newInterval.end<=temp.end
    				|| newInterval.start>=temp.start && newInterval.start<=temp.end){
    			intervals.remove(temp);
    			if(temp.end>newInterval.end){
    				newInterval.end = temp.end;
    			}
    			if(temp.start<newInterval.start){
    				newInterval.start = temp.start;
    			}
    		}
    		else if(newInterval.end>=temp.end && newInterval.start<=temp.start){
    			intervals.remove(temp);
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
