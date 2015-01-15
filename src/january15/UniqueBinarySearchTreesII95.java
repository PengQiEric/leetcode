package january15;

import java.util.LinkedList;
import java.util.List;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
  
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 
 */

public class UniqueBinarySearchTreesII95 {
    
	// this is one dimension array solution
	/*
	 * Basically we can use two dimension array, it means
	 *  OPT(i,j) = OPT(i,k-1)+k+OPT(k+1,j) for all k in [i,j]
	 *  it seems hard to implement in iterative pattern. or it need a lots of space
	 * 
	 */
	
	
	public List<TreeNode> generateTrees(int n) {
    	
    	List<TreeNode> results = new LinkedList<TreeNode>();
    	if(n == 0){
    		results.add(null);
    	}
    	if(n>=1){
    		results.add(new TreeNode(1));
    	}
    	
    	for(int i=2; i<=n; i++){
    		int size = results.size();
    		for(int j=0; j<size; j++){
    			TreeNode example = results.remove(0);
    			constructNewTree(results, i, example);
    		}
    	}
    	
    	return results;
    }
    
    private void constructNewTree(List<TreeNode> results, int newElement, TreeNode cur){
    	TreeNode newNode = new TreeNode(newElement);
    	newNode.left = cur;
    	TreeNode newTree = cloneTree(newNode);
    	newNode.left = null;
    	results.add(newTree);
    	
    	TreeNode trace = cur;
    	while(trace!=null){
    		TreeNode rPart = trace.right;
    		trace.right = newNode;
    		newNode.left = rPart;
    		
    		TreeNode nTree = cloneTree(cur);
    		results.add(nTree);
    		
    		trace.right = rPart;
    		newNode.left = null;
    		
    		trace = trace.right;
    	}
    }
    
    // clone is the same as traversal, DFS or BFS
    private TreeNode cloneTree(TreeNode original){
    	if(original == null){
    		return null;
    	}
    	else{
        	TreeNode clone = new TreeNode(original.val);
    		clone.left = cloneTree(original.left);
    		clone.right = cloneTree(original.right);
    		return clone;
    	}
    }
    
    public static void main(String[] args){
    	BinaryTreeInorderTraversal94 test = new BinaryTreeInorderTraversal94();
    	UniqueBinarySearchTreesII95 test1 = new UniqueBinarySearchTreesII95();
    	List<TreeNode> results = test1.generateTrees(3);
    	for(TreeNode tn: results){
    		System.out.println(test.inorderTraversal(tn).toString());
    	}
    	
    	
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	TreeNode n3 = new TreeNode(3);
    	TreeNode n4 = new TreeNode(4);
    	TreeNode n5 = new TreeNode(5);
    	
//    	n1.left = n2; 
//    	n1.right = n3; n3.left=n4; //n3.right = n5;
//    	System.out.println(test.inorderTraversal(n1));
//    	System.out.println(test.inorderTraversal(test1.cloneTree(n1)));
    }
}
