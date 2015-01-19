package january18;

import aTool.ListNode;
import aTool.TreeNode;

/**
 * @author Paul Qi
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class ConvertSortedListtoBinarySearchTree109 {
    
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
        	return null;
        }
        if(head.next == null){
        	return new TreeNode(head.val);
        }
        
        ListNode fast = head, slow = head, prev=null;
        while(fast!=null && fast.next!=null){
        	fast = fast.next.next;
        	prev = slow;
        	slow = slow.next;
        }
        prev.next = null;
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
