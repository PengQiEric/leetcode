package january15;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * left, then right, then root
 */

public class BinaryTreePostorderTraversal145 {
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
