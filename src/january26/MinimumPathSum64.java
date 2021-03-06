package january26;

/**
 * @author PAUL QI
 *  Given a m x n grid filled with non-negative numbers, 
 *  find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
//        int[][] results = new int[grid.length][grid[0].length];
        // does not need any extra space
        for(int i=0; i<grid.length; i++){
        	for(int j=0; j<grid[0].length; j++){
        		if(i-1>=0 && j-1>=0){
        			grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1])+grid[i][j];
        		}
        		else if(i-1>=0){
        			grid[i][j] = grid[i-1][j]+grid[i][j];
        		}
        		else if(j-1>=0){
        			grid[i][j] = grid[i][j-1]+grid[i][j];
        		}
        		else{
        			grid[i][j] = grid[i][j];
        		}
        	}
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }
}
