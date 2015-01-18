package january17;

import java.util.LinkedList;
import java.util.List;

import aTool.TreeNode;

public class RecoverBinarySearchTree99_MorrisTraversal {

	// traversal the tree with O(1) space
	// basically it is partial threaded Binary Tree 
	// 	where the right null pointer will point to the successor
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> results = new LinkedList<Integer>();
    	TreeNode cur = root;
    	while(cur!=null){
    		if(cur.left == null){
    			results.add(cur.val);
    			cur = cur.right;
    		}
    		else{
    			TreeNode prev = cur.left;
    			while(prev.right!=null && prev.right!= cur){
    				prev = prev.right;  
    			}
    			
    			if(prev.right == null){ // the right most node in the current left subtree
    				prev.right = cur;
    				cur = cur.left;
    			}
    			
    			if(prev.right == cur){ // finish traversal the left subtree
    				results.add(cur.val);
    				prev.right = null;
    				cur = cur.right;
    			}
    		}
    	}
    	
    	return results;
    }
    
    // do next time
    // http://n00tc0d3r.blogspot.com/2013/05/recover-binary-search-tree.html
    public void recoverTree(TreeNode root) {
    	//
    }
}
