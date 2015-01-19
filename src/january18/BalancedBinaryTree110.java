package january18;

import aTool.TreeNode;


/**
 * @author Paul Qi
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */

public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
    	return height(root) == -1 ? false : true;
    }
    
    private int height(TreeNode root){
    	if(root == null)
    		return 0;
    	
    	int left = height(root.left);
    	int right = height(root.right);
    	if(left == -1 || right == -1 || Math.abs(left-right)>1){
    		return -1;
    	}
    	else{
    		return Math.max(left, right)+1;
    	}
    }
    
}
