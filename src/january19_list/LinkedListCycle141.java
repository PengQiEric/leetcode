package january19_list;

import aTool.ListNode;

/**
 * @author Paul Qi
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */

public class LinkedListCycle141 {
    
	public boolean hasCycle(ListNode head) {
		boolean first = true;
		ListNode fast = head, slow = head;
		while((fast!=null && fast.next!=null) && (first || (!slow.equals(fast) ))){ // slow!=fast
			first = false;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast == null || fast.next==null){
			return false;
		}
		else{
			return true;
		}
    }
	
	public static void main(String[] args){
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		n0.next = n0;
		n1.next = n0;
		
		LinkedListCycle141 test = new LinkedListCycle141();
		System.out.println(test.hasCycle(n0));
	}
}
