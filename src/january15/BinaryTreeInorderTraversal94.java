package january15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * 
 * left first, then root, then right
 */

public class BinaryTreeInorderTraversal94 {
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<Integer>();
    	Stack<TreeNode> elements = new Stack<TreeNode>();
    	Stack<Integer> states = new Stack<Integer>();
    	
    	if(root!=null){
    		elements.push(root);
    		states.push(0);
    	}
    	
    	while(!elements.isEmpty()){
    		if(states.peek() == 1){
    			TreeNode current = elements.pop();
    			result.add(current.val);
    			states.pop();
    			if(current.right!=null){
    				elements.push(current.right);
    				states.push(0);
    			}
    		}
    		else{
    			if(elements.peek().left == null){
    				// only change the state from 0 to 1
    				states.pop(); states.push(1);
    			}
    			else{
    				// change the state from 0 to 1
    				states.pop(); states.push(1);
    				
    				elements.push(elements.peek().left);
    				states.push(0);
    			}
    		}
    	}
    	return result;
    }
    
    
    // great solution, it's kind of understanding the essence
    public List<Integer> inorderTraversal_nostate(TreeNode root) {
    	List<Integer> results = new ArrayList<Integer>();
    	TreeNode cur = root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(cur!=null){
    		stack.push(cur);
    		cur = cur.left;
    	}
    	
    	while(!stack.isEmpty()){
    		cur = stack.pop();
    		results.add(cur.val);
    		cur = cur.right;
    		while(cur!=null){
    			stack.push(cur);
    			cur = cur.left;
    		}
    	}
    	
    	return results;
    }
    
}
