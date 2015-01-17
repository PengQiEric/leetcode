package january16;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import aTool.TreeNode;

/**
 * 
 * @author Paul Qi
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:

		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3

	But the following is not:
		    1
		   / \
		  2   2
		   \   \
		   3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.
 */

public class SymmetricTree101 {
	
	// nice deep first search
    public boolean isSymmetric_refer(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    
    }
    public boolean isSymmetric(TreeNode root) {
    	if(root == null){
    		return true;
    	}
    	else{
    		return isSameTree(root.left, root.right);
    	}
    }
    
    
	private boolean isSameTree(TreeNode p1, TreeNode p2){
		if(p1==null && p2==null){
			return true;
		}
		else if(p1==null || p2==null){
			return false;
		}
		return isSameTree(p1.left,p2.right)&&(p1.val == p2.val)&&isSameTree(p1.right,p2.left);
	}
	
	//	Bonus points if you could solve it both recursively and iteratively.
    public boolean isSymmetric_needLotsStructure(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root!=null && ((root.left == null && root.right!=null) || (root.left!=null && root.right == null))){
        	return false;
        }
        
        if(root!=null&& root.left!=null && root.right!=null){
        	queue.addFirst(root.left);
        	queue.addLast(root.right);
        }
        
        while(!queue.isEmpty()){
        	Deque<TreeNode> temp = new ArrayDeque<TreeNode>();
        	while(!queue.isEmpty()){
        		TreeNode left = queue.pollFirst();
        		TreeNode right = queue.pollLast();
        		if(left.val!=right.val){
        			return false;
        		}
        		if(left.left!=null && right.right!=null){
        			temp.addFirst(left.left);
        			temp.addLast(right.right);
        		}
        		else if(!(left.left == null && right.right == null)){
        			return false;
        		}
        		
        		if(left.right!=null && right.left!=null){
        			temp.addFirst(left.right);
        			temp.addLast(right.left);
        		}
        		else if(!(left.right == null && right.left == null)){
        			return false;
        		}
        	}
        	queue.addAll(temp);
        }
        return true;
    }
}
