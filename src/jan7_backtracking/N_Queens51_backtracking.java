package jan7_backtracking;

import java.util.LinkedList;
import java.util.List;

public class N_Queens51_backtracking {
	
	List<String[]> result = new LinkedList<String[]>();
	
	public List<String[]> solveNQueens(int n) {
		int[][] board = new int[n][n];
		dfs(board,0,n);
		return result;
	}
	
	private void dfs(int[][] board, int i, int n){
		if(i>=n){
			result.add(printSolution(board));
		}
		for(int j=0; j< board.length; j++){
			if(isSafe(board, i, j)){
				board[i][j] = 1;
				dfs(board, i+1, n);
				// continue next
				board[i][j] = 0;
			}
		}
	}
	
	private String[] printSolution(int[][] board){
		String[] sol = new String[board.length];
		for(int i=0; i<board.length; i++){
			StringBuffer sb = new StringBuffer();
			for(int j=0; j<board[0].length; j++){
				if(board[i][j] == 0){
					sb.append(".");
				}
				else{
					sb.append("Q");
				}
			}
			sol[i] = sb.toString();
		}
		return sol;
	}
	
	private boolean isSafe(int[][] board, int row, int col){
		for(int i=0; i<row; i++){
			if(board[i][col] == 1)
				return false;
		}

		// left upper diagonal
		for(int i=row,j=col;i>=0 && j>=0; i--,j--){
			if(board[i][j] == 1)
				return false;
		}
		
		for(int i=row,j=col;i>=0 && j<board[0].length; i--,j++){
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
    public static void main(String[] args){
    	N_Queens51_backtracking test = new N_Queens51_backtracking();
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
