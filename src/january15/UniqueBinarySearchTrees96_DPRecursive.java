package january15;
/**
 * @author Paul Qi
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

public class UniqueBinarySearchTrees96_DPRecursive {

    public int numTrees(int n) {
    	if(n==0){
    		return 0;
    	}
    	else{
    		return generateTree(1, n);
    	}
    }
    
    private int generateTree(int from, int to){
    	if(from >= to) // why from > to should be one? it just means this leaf can be null
    		return 1;

    	int result = 0;
    	for(int i=from; i<=to; i++){
    		result += generateTree(from,i-1)*generateTree(i+1,to);  // construct the tree like left i right
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	UniqueBinarySearchTrees96_DPRecursive test = new UniqueBinarySearchTrees96_DPRecursive();
    	System.out.println(test.numTrees(2));
    }
}
