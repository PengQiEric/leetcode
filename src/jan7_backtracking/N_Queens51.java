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
    			for(int k=0; k<cols; k++){
    				String[] newSol = new String[cols];
    				// change old Strings
    				for(int p=0; p<solution.length; p++){
    					if(k<cols-1){
    						newSol[p] = solution[p].substring(0, k)+'.'+solution[p].substring(k);
    					}
    					else{
    						newSol[p] = solution[p].substring(0, k)+'.';
    					}
    				}
    				String newS = "";
    				for(int p=0; p<k; p++){
    					newS += ".";
    				}
    				newS += "Q";
    				for(int p=k+1; p<newSol.length; p++){
    					newS += ".";
    				}
    				newSol[newSol.length-1] = newS;
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
    	List<String[]> result = test.solveNQueens(8);
    	for(String[] ss: result){
    		for(String s: ss){
    			System.out.println(s);
    		}
    		System.out.println();
    	}
    }
}
