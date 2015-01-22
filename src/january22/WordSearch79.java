package january22;

/**
 * @author PAUL QI
 *  Given a 2D board and a word, find if the word exists in the grid.
	The word can be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.
	For example,
	Given board =
	
	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
 */

public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        int[][] in = new int[board.length][board[0].length];
        boolean result = false;
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		result = result || match(board, word, 0, i, j, -1, in);
        	}
        }
        return result;
    }
    
    private boolean match(char[][] board, String word, int start, int i, int j, int pos, int[][] in){ // i,j are the position
    	if(start == word.length()){												// come from left,right,up,down
    		return true;
    	}
    	if(i<0 || j<0 || i == board.length || j==board[0].length){
    		return false;
    	}
    	if(in[i][j] == 1 || board[i][j]!=word.charAt(start)){
    		return false;
    	}
    	else{
    		in[i][j] = 1;
    		boolean result;
    		if(pos == 0){ // left
    			 result = match(board,word,start+1,i-1,j,3,in) // bottom is the previous
    					|| match(board,word,start+1,i+1,j,2,in) // up is the previous
    					|| match(board,word,start+1,i,j+1,0,in); // left
    		}
    		else if(pos == 1){
    			 result = match(board,word,start+1,i-1,j,3,in) // bottom is the previous
    					|| match(board,word,start+1,i+1,j,2,in) // up is the previous
    					|| match(board,word,start+1,i,j-1,1,in); // right
    		}
    		else if(pos == 2){
    			 result = match(board,word,start+1,i,j+1,0,in) // left is the previous
    					|| match(board,word,start+1,i+1,j,2,in) // up is the previous
    					|| match(board,word,start+1,i,j-1,1,in); // right
    		}
    		else if(pos == 3){
    			 result = match(board,word,start+1,i,j+1,0,in) // left is the previous
    					|| match(board,word,start+1,i-1,j,3,in) // bottom is the previous
    					|| match(board,word,start+1,i,j-1,1,in); // right
    		}
    		else{
    			 result = match(board,word,start+1,i,j+1,0,in) // left is the previous
    					|| match(board,word,start+1,i-1,j,3,in) // bottom is the previous
    					|| match(board,word,start+1,i,j-1,1,in) // right
    					|| match(board,word,start+1,i+1,j,2,in);
    		}
			in[i][j] = 0;
			return result;
    	}
    }
    
    public static void main(String[] args){
    	WordSearch79 test = new WordSearch79();
    	char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	System.out.println(test.exist(board, "SEE"));
    }
}
