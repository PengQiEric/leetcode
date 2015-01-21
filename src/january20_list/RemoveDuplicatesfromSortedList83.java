package january20_list;

import aTool.ListNode;

/**
 * @author PAUL QI
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */

public class RemoveDuplicatesfromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
        	return head;
        }
        ListNode slow = head, fast = head.next;
        while(fast!=null){
        	if(slow.val == fast.val){
        		fast = fast.next;
        		slow.next = fast;
        	}
        	else{
        		slow = slow.next;
        		fast = fast.next;
        	}
        }
        return head;
    }
}
