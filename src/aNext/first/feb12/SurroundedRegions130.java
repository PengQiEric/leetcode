package aNext.first.feb12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author PAUL QI
 *  
 *  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

	A region is captured by flipping all 'O's into 'X's in that surrounded region.
	
	For example,
	X X X X
	X O O X
	X X O X
	X O X X
	After running your function, the board should be:
	
	X X X X
	X X X X
	X X X X
	X O X X
 */

public class SurroundedRegions130 {
	// how to solve this problem? It's hard to find which one should be flipped. 
	// But we can easy find which one we should not flip. The one connect to the boundary element. 
	// Then we can use DFS or BFS to search all the elments from the boundary.
	
//	O(n) time, one element at most visited four time, by his neighbors. O(n) memory space
    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
    	Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        int width = board[0].length;
        int heigh = board.length;
    	for(int i=0; i<board[0].length; i++){
        	if(board[0][i] == 'O'){
        		board[0][i] = 'N';	// non-flip
        		List<Integer> temp = new ArrayList<Integer>(); temp.add(0); temp.add(i);
        		queue.add(temp);
        	}
        	if(board[heigh-1][i] == 'O'){
        		board[heigh-1][i] = 'N';	// non-flip
        		List<Integer> temp = new ArrayList<Integer>(); temp.add(heigh-1); temp.add(i);
        		queue.add(temp);
        	}
        }
        for(int i=0; i<board.length; i++){
        	if(board[i][0] == 'O'){
        		board[i][0] = 'N';	// non-flip
        		List<Integer> temp = new ArrayList<Integer>(); temp.add(i); temp.add(0);
        		queue.add(temp);
        	}
        	if(board[i][width-1] == 'O'){
        		board[i][width-1] = 'N';	// non-flip
        		List<Integer> temp = new ArrayList<Integer>(); temp.add(i); temp.add(width-1);
        		queue.add(temp);
        	}
        }
        
        while(!queue.isEmpty()){
        	List<Integer> temp = queue.poll();
        	int i= temp.remove(0), j= temp.remove(0);
        	if(i>0 && board[i-1][j] == 'O'){
        		List<Integer> newNode = new ArrayList<Integer>();
        		newNode.add(i-1); newNode.add(j);
        		board[i-1][j] = 'N';
        		queue.add(newNode);
        	}
        	if(i<heigh-1 && board[i+1][j] == 'O'){
        		List<Integer> newNode = new ArrayList<Integer>();
        		newNode.add(i+1); newNode.add(j);
        		board[i+1][j] = 'N';
        		queue.add(newNode);
        	}
        	
        	if(j>0 && board[i][j-1] == 'O'){
        		List<Integer> newNode = new ArrayList<Integer>();
        		newNode.add(i); newNode.add(j-1);
        		board[i][j-1] = 'N';
        		queue.add(newNode);
        	}
        	
        	if(j<width-1 && board[i][j+1] == 'O'){
        		List<Integer> newNode = new ArrayList<Integer>();
        		newNode.add(i); newNode.add(j+1);
        		board[i][j+1] = 'N';
        		queue.add(newNode);
        	}
        }
        
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<width; j++){
        		if(board[i][j] == 'O'){
        			board[i][j] = 'X';
        		} 
        		else if(board[i][j] == 'N'){
        			board[i][j] = 'O';
        		}
        	}
        }
    }
}
