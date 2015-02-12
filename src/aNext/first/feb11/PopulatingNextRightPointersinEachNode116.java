package aNext.first.feb11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PAUL QI
 * 
 *  Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
    
	Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	
	Initially, all next pointers are set to NULL.
	
	Note:
	
	You may only use constant extra space.
	You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
	For example,
	Given the following perfect binary tree,
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \  / \
	    4->5->6->7 -> NULL
 */

public class PopulatingNextRightPointersinEachNode116 {
	// common solution, but need O(n) space, the last level has n/2 nodes.
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeLinkNode temp = queue.poll();
            if(temp == null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }
            else{
                temp.next = queue.peek();
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
    }
    
    // recursive may not be good for constant space, but still, some refer from others
    public void connectRecursive_Refer(TreeLinkNode root) {
        if(root == null){
            return;
        }
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        
        connect(left);
        connect(right);
        
        while(left!=null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
    
    // now back to the iterative version, how can we improve the space memory?
    // we need to make use of the previous connected node.
    // previous level and current level
    
    // time complex O(n) every node we only traversal twice.
    public void connectIterative_Refer(TreeLinkNode root) {
    	TreeLinkNode previous = root;
    	while(previous!=null){
    		TreeLinkNode current = null;
    		TreeLinkNode head = previous;
    		while(head!=null){
    			if(head.left!=null){
    				if(current == null){
    					current = head.left;
    					current =  current.next = head.right;
    				}
    				else{
    					current = current.next = head.left;
    					current = current.next = head.right;
    				}
    			}
    			head = head.next;
    		}
    		previous = previous.left;
    	}
    	
    }
}


/**
 * Definition for binary tree with next pointer.
 */
class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
}
 
