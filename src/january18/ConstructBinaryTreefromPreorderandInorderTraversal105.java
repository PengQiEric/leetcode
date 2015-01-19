package january18;

import java.util.HashMap;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * Given pre-order and in-order traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
	
	// http://leetcode.com/2011/04/construct-binary-tree-from-inorder-and-preorder-postorder-traversal.html
	
	HashMap<Integer,Integer> mapIndex = new HashMap<Integer,Integer>();
	// it is divide and conquer. The element of preorder can split in-order element into two part
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for(int i=0; i<inorder.length; i++){
			mapIndex.put(inorder[i], i); // used to accelerate the speed.
		}
		return buildTree(0,0,inorder.length-1,preorder,inorder);
    }
	
	private TreeNode buildTree(int pindex, int istart, int iend, int[] preorder, int[] inorder){
		if(istart > iend){
			return null;
		}
		
		if(istart == iend){
			return new TreeNode(inorder[istart]);
		}
		
		TreeNode root = new TreeNode(preorder[pindex]);
		int rootPos = mapIndex.get(preorder[pindex]);
		int offset = rootPos - istart+1;
		root.left = buildTree(pindex+1, istart, rootPos-1,preorder, inorder);
		root.right = buildTree(pindex+offset, rootPos+1,iend, preorder, inorder);

		return root;
	}
}
