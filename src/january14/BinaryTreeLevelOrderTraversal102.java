package january14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 */

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root == null){
    		return results;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		List<Integer> result = new ArrayList<Integer>();
    		int size = queue.size();
    		for(int i=0; i<size; i++){
    			TreeNode node = queue.poll();
    			result.add(node.val);
    			if(node.left!=null)
    				queue.add(node.left);
    			if(node.right!=null)
    				queue.add(node.right);
    		}
    		results.add(result);
    	}
    	
    	return results;
    }
}
