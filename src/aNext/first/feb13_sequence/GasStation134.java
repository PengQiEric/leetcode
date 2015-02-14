package aNext.first.feb13_sequence;

/**
 * @author PAUL QI
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
	
	Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
	
	Note:
	The solution is guaranteed to be unique.
 */

public class GasStation134 {
	// with the line 25 & 32, the solution is accepted, but it is still O(n^2) even though with some optimization.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i<gas.length;){
            if(gas[i]>=cost[i]){
                boolean stop = false;
                int left = gas[i]-cost[i];
                for(int j=i+1;j<gas.length && !stop;j++){
                    if(left+gas[j]<cost[j]){
                        stop = true;
                        i = j+1;	// accelerate the search, it is just so fast with this change, I don't know why.
                    }
                    left = left+gas[j]-cost[j];
                }
                for(int j=0;j<i && !stop; j++){
                    if(left+gas[j]<cost[j]){
                        stop = true;
                        i++;	// can I accelerate it?
                    }
                    left = left+gas[j]-cost[j];
                }
                if(!stop){
                    return i;
                }
            }
            else{
                i++;
            }
        }
        return -1;
    }
    
    public int canCompleteCircuit_ON(int[] gas, int[] cost){
    	for(int i=0; i<gas.length; i++){
    		gas[i] -=cost[i];
    	}
    	int result = 0;
    	int sum = 0;
    	// 0 1 2 ..  N-1 0 1.. N-2
    	for(int i=0; i<2*gas.length-1; i++){
    		sum += gas[i%gas.length];
    		if(sum<0){
    			result = i+1;	// check the result range
    			if(result>=gas.length){
    				return -1;
    			}
    			sum = 0;
    		}
    	}
    	return result;
    }
}
