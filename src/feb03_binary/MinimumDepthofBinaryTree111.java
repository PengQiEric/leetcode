package feb03_binary;

import java.util.LinkedList;
import java.util.Queue;

import aTool.TreeNode;

/**
 * @author PAUL QI
 * 
 *  Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes along the shortest path from the root node 
	down to the nearest leaf node.
 */

public class MinimumDepthofBinaryTree111 {
	// The DFS version is pretty straightforward, let's try BFS for some unbalanced tree, BFS works better.
    public int minDepth(TreeNode root) {
    	int len = 0;
    	Queue<TreeNode> que = new LinkedList<TreeNode>();
    	if(root!=null){
    		que.offer(root);
    		que.offer(null);
    	}
    	while(!que.isEmpty()){
    		TreeNode cur = que.poll();
    		if(cur == null){
    			len++;
    			if(!que.isEmpty()){
    				que.offer(null);
    			}
    		}
    		else{
    			if(cur.left == null && cur.right == null){
    				return len+1;
    			}
    			
    			if(cur.left!=null){
    				que.offer(cur.left);
    			}
    			if(cur.right!=null){
    				que.offer(cur.right);
    			}
    		}
    	}
    	return len;
    }
}
