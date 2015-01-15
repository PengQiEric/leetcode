package january15;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * 
 * Root first, then left, then right
 */

public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if(root!=null){
    		result.add(root.val);
    		if(root.right!=null){
    			stack.push(root.right);
    		}
    		if(root.left!=null){
    			stack.push(root.left);
    		}
    	}
    	while(!stack.isEmpty()){
    		TreeNode current = stack.pop();
    		result.add(current.val);
    		if(current.right!=null){
    			stack.add(current.right);
    		}
    		if(current.left!=null){
    			stack.add(current.left);
    		}
    	}
    	
    	return result;
    }
}
