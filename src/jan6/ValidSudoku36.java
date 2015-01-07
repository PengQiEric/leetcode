package jan6;

import java.util.HashSet;

/**
 * @author Paul Qi
 * Determine if a Sudoku is valid.
 * 
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

public class ValidSudoku36 {
	// NP certification
    public boolean isValidSudoku(char[][] board) {
    	
    	//every line
    	HashSet<Character> tester = new HashSet<Character>();
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board[i].length; j++){
    			if(tester.contains(board[i][j])){
    				return false;
    			}
    			else if(board[i][j]!='.'){
    				tester.add(board[i][j]);
    			}
    		}
    		tester.clear();
    	}
    	
    	// every column
    	for(int j=0; j<board[0].length; j++){
    		for(int i=0; i<board.length; i++){
    			if(tester.contains(board[i][j])){
    				return false;
    			}
    			else if(board[i][j]!='.'){
    				tester.add(board[i][j]);
    			}
    		}
    		tester.clear();
    	}
    	
    	for(int i=0; i<board.length; i+=3){
    		for(int j=0; j<board[i].length; j+=3){
    			for(int k=i; k<i+3; k++){
    				for(int p=j; p<j+3; p++){
    	    			if(tester.contains(board[k][p])){
    	    				return false;
    	    			}
    	    			else if(board[k][p]!='.'){
    	    				tester.add(board[k][p]);
    	    			}
    				}
    			}
    			tester.clear();
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	ValidSudoku36 test = new ValidSudoku36();
    	test.isValidSudoku(new char[][]{{'1','2','3'},{'1','2','3'},{'1','2','3'}});
    }
}
