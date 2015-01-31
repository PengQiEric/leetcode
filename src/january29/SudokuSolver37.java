package january29;

public class SudokuSolver37 {
    public void solveSudoku(char[][] board) {
//    	System.out.println(sudokuHelper(board, 0, -1));
    	sudokuHelper(board, 0, -1);
    }
    
    private boolean sudokuHelper(char[][] board, int x, int y){
    	for(int j=y+1;j<board[0].length; j++){
    		if(board[x][j] == '.'){
    			for(int i=1; i<=9; i++){
    				board[x][j] = (char) (i+48);
    				if(isSafe(board, x, j)){
    					if(sudokuHelper(board, x, j)){
    						return true;
    					}
    				}
    			}
    			board[x][j] = '.';	//backtracking
    			return false;
    		}
    	}
    	
    	for(int i=x+1; i<board.length; i++){
    		for(int j=0; j<board[0].length; j++){
    			if(board[i][j] == '.'){
        			for(int k=1; k<=9; k++){
        				board[i][j] = (char) (k+48);
        				if(isSafe(board, i, j)){
        					if(sudokuHelper(board, i, j)){
        						return true;
        					}
        					else{
        						board[i][j] = '.';
        					}
        				}
        			}
        			board[i][j] = '.'; //backtracking
        			return false;
    			}
    		}
    	}
    	return true;
    }
    
    private boolean isSafe(char[][] board, int x, int y){
//    	int b = x;
    	// hash table can accelerate this process.
    	for(int i=0;i<board.length; i++){
    		if(i!=x  && board[i][y] == board[x][y]){
    			return false;
    		}
    	}
    	for(int i=0; i<board[0].length; i++){
    		if(i!=y && board[x][i] == board[x][y]){
    			return false;
    		}
    	}
    	
    	for(int i=x/3*3; i<=x/3*3+2; i++)
    		for(int j= y/3*3; j<=y/3*3+2; j++)
    			if(i!=x && j!=y && board[i][j] ==  board[x][y])
    				return false;
    	return true;
    }
    
    public static void main(String[] args){
    	SudokuSolver37 test = new SudokuSolver37();
    	char[][] board = new char[9][9];
    	board[0] = "..9748...".toCharArray();
    	board[1] = "7........".toCharArray();
    	board[2] = ".2.1.9...".toCharArray();
    	board[3] = "..7...24.".toCharArray();
    	board[4] = ".64.1.59.".toCharArray();
    	board[5] = ".98...3..".toCharArray();
    	board[6] = "...8.3.2.".toCharArray();
    	board[7] = "........6".toCharArray();
    	board[8] = "...2759..".toCharArray();
    	test.solveSudoku(board);
    	System.out.println();
    }
}
