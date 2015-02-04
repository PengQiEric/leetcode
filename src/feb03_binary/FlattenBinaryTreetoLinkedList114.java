package feb03_binary;

import java.util.Stack;

import aTool.TreeNode;

/**
 * @author PAUL QI
 * Given a binary tree, flatten it to a linked list in-place.

	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
 */

public class FlattenBinaryTreetoLinkedList114 {
	
	
	
	// most common solution, using a stack, but not an in-place solution
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode previous = root;
        if(root.right!=null){
            stack.push(root.right);
        }
        if(root.left!=null){
            stack.push(root.left);
            previous.left = null;
        }
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
                cur.left = null;
            }
            previous.right = cur;
            previous = cur;
        }
    }
    
    
    // recursive version, but need to store some common data, I don't think this is a good way to do recursive
    private TreeNode nextVisit = null;
    public void flatten_recursive(TreeNode root) {
        if(root == null){
            return;
        }
        
        TreeNode rightPart = root.right;
        if(nextVisit == null){
            nextVisit = root;	// the first time does not set the left branch to null;
        }
        else{
            nextVisit.right = root;
            nextVisit.left = null;
            nextVisit = root;
        }
        
        flatten(root.left);
        flatten(rightPart);
    }
}
