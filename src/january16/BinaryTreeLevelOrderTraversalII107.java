package january16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 */

public class BinaryTreeLevelOrderTraversalII107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	LinkedList<List<Integer>> results = new LinkedList<List<Integer>>();
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
    		results.addFirst(result);
    	}
    	
    	return results;
    }
}
