package january15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * left, then right, then root
 */

public class BinaryTreePostorderTraversal145 {
	
	// deserialization of binary tree
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return null;
	}
	
	
	
	// if we think about the order left-right-root, the preorder is root-left-right, if we change the preorder to
	// root-right-left, then the mirror should be the post-order
	// how can we get the mirror order? using a stack.
	public List<Integer> postOrderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> backStack = new Stack<Integer>();
		TreeNode cur = root;
		while(cur!=null){
			stack.push(cur);
			backStack.push(cur.val);
			cur = cur.right;
		}
		
		while(!stack.isEmpty()){
			cur = stack.pop();
			cur = cur.left;
			while(cur!=null){
				stack.push(cur);
				backStack.push(cur.val);
				cur = cur.right;
			}
		}
		while(!backStack.isEmpty()){
			result.add(backStack.pop());
		}
		return result;
	}
	
	
	
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> state = new Stack<Integer>();	// other data structure to record the state?
        if(root!=null){
        	stack.push(root);
        	state.push(0);
        }
        
        while(!stack.isEmpty()){
        	// how to make sure the left&right have already visited. state vector
        	if(state.peek() == 2){
        		result.add(stack.pop().val);
        		state.pop();
        	}
        	else if(state.peek() == 1){
        		if(stack.peek().right!=null){
        			stack.push(stack.peek().right);
        			//change the state of the root from 1 to 2
        			state.pop(); state.push(2);
        			state.push(0);
        		}
        		else{
        			result.add(stack.pop().val);
        			state.pop();
        		}
        	}
        	else{
        		if(stack.peek().left!=null){
        			stack.push(stack.peek().left);
        			// change the state of the root from 0 to 1
        			state.pop(); state.push(1);
        			state.push(0);
        		}
        		else{
        			// if the left is null, just change the state from 0 to 1
        			state.pop(); state.push(1);
        		}
        	}
        }
        
        return result;
    }
	
}
