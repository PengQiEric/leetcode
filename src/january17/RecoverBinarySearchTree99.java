package january17;

import january15.BinaryTreeInorderTraversal94;

import java.util.Stack;

import aTool.TreeNode;

/**
 * @author Paul QI
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 */

public class RecoverBinarySearchTree99 {
	
	// 1. easy to find the wrong element? in-order traversal? but how to find which two are swapped by mistake?
    public void recoverTree_iterative(TreeNode root) {
        // a solution using more space
    	
    	// how to find the two swapped element, based on the observation
    	// First previous<=current Second previous<= current 
    	// then we get the bigger of the first and the smaller of the second
    	// if we can only find one pair, then those are the the element we are looking for. 
    	
    	// refer http://n00tc0d3r.blogspot.com/2013/05/recover-binary-search-tree.html
    	
    	TreeNode first =null,second=null, cur=root, prev=null;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(cur!=null){
    		stack.push(cur);
    		cur = cur.left;
    	}
    	
    	while(!stack.isEmpty()){
    		cur = stack.pop();
    		if(prev!=null && cur.val<= prev.val){
    			if(first == null){
    				first = prev;
    				second = cur;
    			}
    			else{
    				second = cur;
    				break;
    			}
    		}
    		
    		prev= cur; // prev record every visited element
			cur = cur.right;
			while(cur!=null){
				stack.push(cur);
				cur = cur.left;
			}
    	}
    	swapTwoElement(first, second);
    	
    	// space spend is O(h) speed spend is O(n)
    }
    
    public static void main(String[] args){
    	TreeNode n1 = new TreeNode(2);
    	TreeNode n2 = new TreeNode(1);
    	n1.right = n2;
    	
    	RecoverBinarySearchTree99 test = new RecoverBinarySearchTree99();
    	test.recoverTree(n1);
    	BinaryTreeInorderTraversal94 test1 = new BinaryTreeInorderTraversal94();
    	
    }
    
    public void recoverTree(TreeNode root) {
    	TreeNode[] elements = new TreeNode[2];
    	inorderTraversal(root, elements, null);
    	swapTwoElement(elements[0], elements[1]);
    }
    
    // The recursive is not difficult, but we need to know how to store some value
    private TreeNode inorderTraversal(TreeNode root, TreeNode[] elements, TreeNode prev){
    											// return the last element
    	if(root == null){
    		return prev;
    	}
    	/*
    	 * 		1
    	 * 	 	 \
    	 *    	  0
    	 */
    	// it tells us the last node 
    	TreeNode anyname = 
    		inorderTraversal(root.left, elements, prev);
    	if(anyname!=null && root.val <= anyname.val){
    		if(elements[0] == null){
    			elements[0] = anyname;
    			elements[1] = root;
    		}
    		else{
    			elements[1] = root;
    		}
    	}
    	return inorderTraversal(root.right, elements, root); // update the prev(i.e.) the last node should be the new prev
    }
    
    private void swapTwoElement(TreeNode first, TreeNode second){
    	if(first == null || second == null)return;
    	// only change the value of the two element, it may be the smallest thing we can do.
    	int temp = first.val;
    	first.val = second.val;
    	second.val = temp;
    }
}
