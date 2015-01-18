package january17;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 */

public class BinaryTreeZigzagLevelOrderTraversal103 {
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	boolean reverse = false;
    	Deque<TreeNode> elements = new LinkedList<TreeNode>();
    	if(root!=null){
    		elements.add(root);
    	}
    	
    	while(!elements.isEmpty()){
    		List<Integer> result = new ArrayList<Integer>();
    		int length = elements.size();
    		if(reverse){
	    		for(int i=0; i<length; i++){
	    			TreeNode element = elements.pollLast();
	    			result.add(element.val);
	    			if(element.right!=null){
	    				elements.addFirst(element.right);
	    			}
	    			if(element.left!=null){
	    				elements.addFirst(element.left);
	    			}
	    		}
    		}
    		else{
	    		for(int i=0; i<length; i++){
	    			TreeNode element = elements.pollFirst();
	    			result.add(element.val);
	    			if(element.left!=null){
	    				elements.add(element.left);
	    			}
	    			if(element.right!=null){
	    				elements.add(element.right);
	    			}
	    		}    			
    		}
    		results.add(result);
    		reverse = !reverse;
    	}
    	
    	return results;
    }
}
