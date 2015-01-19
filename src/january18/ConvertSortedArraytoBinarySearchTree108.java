package january18;

import aTool.TreeNode;

/**
 * @author Paul Qi
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }
    
    private TreeNode sortedArrayToBST(int[] num, int start, int end){
    	if(start > end){
    		return null;   // for some asymmetric situation
    	}
    	if(start == end){
    		return new TreeNode(num[start]);
    	}
    	
    	int mid = (start+end)/2;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = sortedArrayToBST(num, start, mid-1);
    	root.right = sortedArrayToBST(num, mid+1, end);
    	return root;
    }
/*    
    private TreeNode insert(TreeNode root, int element){
    	if(root == null){
    		return new TreeNode(element);
    	}
    	
    	if(element < root.val){
    		root.left = insert(root.left, element);
    	}
    	else{
    		root.right = insert(root.right, element);
    	}
    	return root;
    }*/
}
