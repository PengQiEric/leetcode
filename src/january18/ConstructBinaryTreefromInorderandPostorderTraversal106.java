package january18;

import java.util.HashMap;
import java.util.Map;

import aTool.TreeNode;

/**
 * @author Paul Qi
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */

// http://leetcode.com/2011/04/construct-binary-tree-from-inorder-and-preorder-postorder-traversal.html

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
    
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for(int i=0; i<inorder.length; i++){
			mapIndex.put(inorder[i], i);
		}
		return buildTree(postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }
	
	private TreeNode buildTree(int rootIndex, int iStart, int iEnd, int[] inorder, int[] postorder){
		if(iStart>iEnd){
			return null;
		}
		
		if(iStart == iEnd){
			return new TreeNode(inorder[iStart]);
		}
		
		TreeNode root = new TreeNode(postorder[rootIndex]);
		int rootPos = mapIndex.get(postorder[rootIndex]);
		int offset = iEnd-rootPos+1;
		root.left = buildTree(rootIndex-offset, iStart, rootPos-1, inorder, postorder);
		root.right = buildTree(rootIndex-1, rootPos+1, iEnd, inorder, postorder);
		return root;
	}
}
