package january16;

import java.util.LinkedList;
import java.util.Queue;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBinarySearchTree98 {
	
	boolean first = true;
	int prev = 0;	// record the last value in the array
	// using inorder DFS, because the BST should be an increasing array 
    public boolean isValidBST(TreeNode root) {
    	
    	if(root == null){
    		return true;
    	}
    	return isValidBST(root.left)&&isCheck(root.val)&&isValidBST(root.right);
    }
    
    private boolean isCheck(int val){
    	if(first){
    		prev = val;
    		first = false;
    		return true;
    	}
    	if(val<= prev) return false;
    	prev = val;
    	return true;
    }

    
    
    
    
	// basically only BFS or DFS
	// why BFS does not work
	/*
	 *    10
  		 / \
 		5   13
    		/ \
   		   4   20
	 *  this is invalid, because 4 is less than 10, it should be in the left branch from the root
	 * 
	 */
    public boolean isValidBST_invalid(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null){
        	queue.add(root);
        }
        
        while(!queue.isEmpty()){
        	TreeNode current = queue.poll();
        	if(current.left!=null && current.left.val>=current.val){
        		return false;
        	}else if(current.left!=null){
        		queue.add(current.left);
        	}
        	
        	if(current.right!=null && current.right.val<=current.val){
        		return false;
        	}else if(current.right!=null){
        		queue.add(current.right);
        	}
        }
        return true;
    }
}
