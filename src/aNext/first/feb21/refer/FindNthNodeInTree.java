package aNext.first.feb21.refer;

import java.util.Stack;

import aTool.TreeNode;

public class FindNthNodeInTree {
	TreeNode result = null;
	public TreeNode findNth(TreeNode root, int k){
		findNthHelper(root, k);
		return result;
	}
	
	public int findNthHelper(TreeNode root, int k){
		if(root == null){
			return k;
		}
		if(k == -1){
			return -1;
		}
		int pos;
		pos = findNthHelper(root.left,k);
		pos = findNthHelper(root.right,pos);
		if(pos == -1){
			return -1;
		}
		if(pos == 1){
			result = root;
			return -1;
		}
		return pos-1;
	}
	
	public TreeNode findNth_iterative(TreeNode root, int k){
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur!=null){
			s.push(cur);
			cur = cur.left;
		}
		
		while(!s.isEmpty()){
			if(k == 1){
				return s.pop();
			}
			TreeNode current = s.pop();
			k--;
			current = current.right;
			while(current!=null){
				s.push(current);
				current = current.left;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	TreeNode n3 = new TreeNode(3);
    	TreeNode n4 = new TreeNode(4);
    	TreeNode n5 = new TreeNode(5);
    	TreeNode n6 = new TreeNode(6); 
    	/*
	    n1
	    / \
	  n2   n3
	  /   / \
	n4   n5  n6

	 */
    	n1.right = n3;
    	n1.left = n2;  n2.left = n4; n3.left = n5; n3.right = n6;
    	FindNthNodeInTree test = new FindNthNodeInTree();
    	for(int k=1; k<=6; k++){
	    	TreeNode l1 = test.findNth(n1, k);
	    	TreeNode l2 = test.findNth_iterative(n1, k);
	    	System.out.print(l1.val+" ");
	    	System.out.print(l1 == l2);
	    	System.out.println();
    	}
	}
}
