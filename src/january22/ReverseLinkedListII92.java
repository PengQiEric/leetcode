package january22;

import aTool.ListNode;

/**
 * @author PAUL QI
 * 
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	return 1->4->3->2->5->NULL.
	
	Note:
	Given m, n satisfy the following condition:
	1 ² m ² n ² length of list.
 */

public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(m==1){
    		ListNode current = head;
    		int i=0;
    		while(i<n-m){	// why endless loop? because line 28, should be head, not head.next
    			ListNode next = current.next;
    			
    			current.next = next.next;
    			next.next = head;
    			head = next;
    			
    			i++;
    		}
    		return head;
    	}
    	
        ListNode current=head;
        int i=1;
        while(i<m-1){
        	current = current.next;
        	i++;
        }
        ListNode previous = current;
        current = current.next;
        
        i=0;
        while(i<n-m){
        	ListNode next = current.next;
        	
        	current.next = next.next;
        	next.next = previous.next;
        	previous.next = next;
        	
        	i++;
        }
        return head;
    }
    
    public static void main(String[] args){
    	ReverseLinkedListII92 test = new ReverseLinkedListII92();
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;
		ListNode head = test.reverseBetween(n0, 1, 4);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
    }
}
