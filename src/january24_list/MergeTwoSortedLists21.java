package january24_list;

import aTool.ListNode;

/**
 * @author PAUL QI
 * 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */

public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null && l2==null){
    		return null;
    	}
    	
    	ListNode head = null;
    	if(l2 == null || (l1!=null && l1.val<l2.val)){
    		head = l1;
    		l1 = l1.next;
    	}
    	else{
    		head = l2;
    		l2 = l2.next;
    	}
    	ListNode cur = head;
    	while(l1!=null && l2!=null){
    		if(l1.val<l2.val){
    			cur.next = l1;
    			cur = cur.next;
    			l1 = l1.next;
    		}
    		else{
    			cur.next = l2;
    			cur = cur.next;
    			l2 = l2.next;
    		}
    	}
    	if(l1!=null){
    		cur.next = l1;
    	}
    	if(l2!=null){
    		cur.next = l2;
    	}
    	return head;
    }
}
