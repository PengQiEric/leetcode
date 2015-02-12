package aNext.first.feb11;

/**
 * @author PAUL QI
 * 
 *  Follow up for problem "Populating Next Right Pointers in Each Node".

	What if the given tree could be any binary tree? Would your previous solution still work?
	
	Note:
	
	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
 */

public class PopulatingNextRightPointersinEachNodeII117 {
    
	public void connect(TreeLinkNode root) {
		TreeLinkNode previous = root;
		while(previous!=null){
			TreeLinkNode current = null;
			TreeLinkNode levelHead = null;
			TreeLinkNode head = previous;
			while(head!=null){
				if(head.left!=null){
					if(current == null){
						current = head.left;
						levelHead = current;
					}
					else{
						current = current.next = head.left;
					}
				}
				if(head.right!=null){
					if(current == null){
						current = head.right;
						levelHead = current;
					}
					else{
						current = current.next = head.right;
					}
				}
				head = head.next;
			}
			previous = levelHead;	// just need to record the head of the level traversal
		}
    }
}
