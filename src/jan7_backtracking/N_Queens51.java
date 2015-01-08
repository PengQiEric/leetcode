package jan7_backtracking;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Paul Qi
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other.
 */

public class N_Queens51 {
    
	// I can solve it using DP Status: Time Limit Exceeded
	public List<String[]> solveNQueens(int n) {
    	List<String[]> result = new LinkedList<String[]>();
		// base case;
    	result.add(new String[]{"Q"});
    	
    	// iterative loop
    	for(int i=1; i<n; i++){
    		int count = result.size();
    		for(int j=0; j<count; j++){
    			String[] solution = result.remove(0);
    			int cols = i+1;
    			StringBuffer newStrBuffer = new StringBuffer();
    			for(int k=0; k<cols-1; k++) newStrBuffer.append(".");
    			newStrBuffer.append("Q");
    			String newStr = newStrBuffer.toString();
    			
    			for(int k=0; k<cols; k++){
    				String[] newSol = new String[cols];
    				int oldSol = 0;
    				for(int p=0; p<k; p++,oldSol++){
    					newSol[p] = solution[oldSol]+".";
    				}
    				newSol[k] = newStr;
    				for(int p=k+1; p<cols; p++,oldSol++){
    					newSol[p] = solution[oldSol]+".";
    				}
    				result.add(newSol);
    			}
    			
    		}
    	}
    	return result;
    }
//	public List<String[]> solveNQueens(int n) {
//		
//		return null;
//	}
//	private void trail(int i, int n)
	
    public static void main(String[] args){
    	N_Queens51 test = new N_Queens51();
//    	System.out.println("ab".substring(0,0));
    	List<String[]> result = test.solveNQueens(4);
    	for(String[] ss: result){
    		for(String s: ss){
    			System.out.println(s);
    		}
    		System.out.println();
    	}
    }
}
