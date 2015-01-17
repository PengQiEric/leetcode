package january16;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p == null && q== null){
    		return true;
    	} else if(p == null || q == null){
    		return false;
    	}
    	return isSameTree(p.left,q.left)&&(p.val == q.val)&&isSameTree(p.right,q.right);
    }
}
