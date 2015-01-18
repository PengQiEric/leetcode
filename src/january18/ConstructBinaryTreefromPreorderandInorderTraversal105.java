package january18;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * Given pre-order and in-order traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
	
	// it is divide and conquer. The element of preorder can split in-order element into two part
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = null, current=null; 
		if(preorder.length>0){
			root = new TreeNode(preorder[0]);
			current = root;
		}
		
		/* 
		
		*/
		return root;
    }
	
	private TreeNode buildTree(int pindex, int istart, int iend, int[] preorder, int[] inorder){
		if(istart > iend){
			return null;
		}
		
		if(istart == iend){
			return new TreeNode(inorder[istart]);
		}
		
		int i;
		for(i=istart; i<=iend; i++){
			if(inorder[i] == preorder[pindex]){
				break;
			}
		}
		TreeNode root = new TreeNode(inorder[i]);
		
		return root;
	}
}
