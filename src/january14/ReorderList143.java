package january14;

import january13.RotateList61;
import aTool.ListNode;

/**
 * @author Paul Qi
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class ReorderList143 {
    public void reorderList(ListNode head) {
        ListNode secondHalf = splitListInTwo(head);
        if(secondHalf==null){
        	return;
        }
        ListNode headOfSecondReverse = reverseList(secondHalf);
        
        // precondition: head is not NULL
        mergeTwoList(head, headOfSecondReverse);
    }
    
    private ListNode splitListInTwo(ListNode head){
    	ListNode slow = head, fast = head;
    	if(slow == null){
    		return slow;
    	}
    	
    	while(fast!=null && fast.next!=null){
    		slow = slow.next; fast = fast.next.next;
    	}
    	
    	ListNode temp = slow.next; // head of the second part
    	slow.next = null; // end of the first part
    	return temp;
    }
    
    // precondition : head is not NULL
    private ListNode reverseList(ListNode head){
    	ListNode current = head.next;
    	head.next = null;  // end of the second list
    	while(current!=null){ // add one element at the first position
    		ListNode temp = current.next;
    		current.next = head;
    		head = current;
    		
    		current = temp;
    	}
    	return head;
    }
    
    private void mergeTwoList(ListNode head, ListNode second){
    	ListNode first = head;
    	ListNode current = second;
    	while(current!=null){
    		ListNode temp = first.next;
    		first.next = current;
    		current = current.next;
    		first.next.next = temp;
    		
    		first = temp;
    	}
    }
    
    public static void main(String[] args){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);
    	l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;
    	
    	ReorderList143 test = new ReorderList143();
    	test.reorderList(l1);
    	while(l1!=null){
    		System.out.print(l1.val+"->");
    		l1 = l1.next;
    	}
    }
}
