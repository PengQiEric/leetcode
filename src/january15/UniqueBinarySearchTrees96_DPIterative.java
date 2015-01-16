package january15;

public class UniqueBinarySearchTrees96_DPIterative {
	
	public int numTrees_unfinished(int n){
    	int[][] results = new int[n+1][n+1]; 		// we can use row as the start and column as length
    	// base case
    	for(int i=1; i<=n; i++){
    		results[i][1] = 1;
    	}
    	
    	for(int len = 2; len<=n; len++){
    		for(int start=1; start<=n+1-len; start++){
    			for(int sublen = 1; sublen<len; sublen++){
    				if(len-sublen>1){
    					results[start][len] += results[start][sublen] * results[start+sublen][len-sublen-1];
    				}
    				else{
    					results[start][len] += results[start][sublen];
    				}
    			}
    		}
    	}
		
		return results[1][n];
	}
	
    public int numTrees(int n) {
    	int[][] results = new int[n+1][n+1];      // this method using row as from & column as to
    	
    	// basic case [1,1] [2,2] [3,3] diagonal
    	for(int i=1; i<=n; i++){
    		results[i][i] = 1;
    	}
    	for(int i=1; i<n; i++){ // length
    		for(int j=1; j+i<=n; j++){
    			// now we wanna calculate from j to j+i
    			for(int k=j; k<=j+i; k++){
    				if(k == j){
    					results[j][j+i] += results[k+1][j+i];
    				}
    				else if(k == (i+j)){
    					results[j][j+i] += results[j][k-1];
    				}
    				else{
    					results[j][j+i] += results[j][k-1]*results[k+1][j+i];
    				}
    			}
    		}
    	}
    	
    	return results[1][n];
    }
    
    public static void main(String[] args){
    	UniqueBinarySearchTrees96_DPIterative test = new UniqueBinarySearchTrees96_DPIterative();
    	System.out.println(test.numTrees(2));
    }
}
