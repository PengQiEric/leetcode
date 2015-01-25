package january24_list;

import aTool.ListNode;

/**
 * @author PAUL QI
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 */

public class RemoveDuplicatesfromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}

    	ListNode newHead = new ListNode(0);
    	ListNode cur = newHead;
    	
    	boolean isDiffAsPrevious = true;
    	// whether I can add the node into the new list depending on both previous and next value
    	while(head!=null){
    		if(head.next == null && isDiffAsPrevious){
    			cur.next = head;
    			cur = head;
    			head = head.next;
    		}
    		else if(head.next == null){	// test case {1,1}
    			head = head.next;
    		}
    		else if(head.val != head.next.val && isDiffAsPrevious){
    			cur.next = head;
    			cur = cur.next;
    			head = head.next;
    		}
    		else if(head.val!=head.next.val){
    			head = head.next;
    			isDiffAsPrevious = true;
    		}
    		else{
    			isDiffAsPrevious = false;
    			head = head.next;
    		}
    	}
    	cur.next = null;
    	return newHead.next;
    }
    
    // A recursive version
    public ListNode deleteDuplicates_recursive(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
    
    public static void main(String[] args){
    	RemoveDuplicatesfromSortedListII82 test = new RemoveDuplicatesfromSortedListII82();
    	
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(1);
    	ListNode n3 = new ListNode(2);
    	ListNode n4 = new ListNode(3);
    	ListNode n5 = new ListNode(4);
    	ListNode n6 = new ListNode(4);
    	ListNode n7 = new ListNode(5);
	    n1.next = n2; //n2.next = n3; n3.next = n4;// n4.next = n5; n5.next = n6; n6.next = n7;
		ListNode head = test.deleteDuplicates(n1);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
    }
}
