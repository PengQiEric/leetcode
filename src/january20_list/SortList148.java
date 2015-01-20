package january20_list;

import aTool.ListNode;

/**
 * @author Paul Qi
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

// good time to review some sort algorithm.
public class SortList148 {
    public ListNode sortList(ListNode head) {
    	// how about use mergesort?
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode slow = head, fast = head.next;  // important, it is the really half cut
    	while(fast!=null && fast.next!=null){ //
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	ListNode second = slow.next;
    	slow.next = null;
    	head = sortList(head); // return sorted array
    	second = sortList(second);
    	return merge(head, second);
    }
    
    private ListNode merge(ListNode left, ListNode right){
    	ListNode head, current = null;
    	if(left == null && right == null){
    		return null;
    	}
    	else if(right== null || (left!=null && right.val>left.val)){
    		current = left;
    		head = left;
    		left = left.next;
    	}
    	else{
    		current = right;
    		head = right;
    		right = right.next;
    	}
    	
    	while(left!=null && right!=null){
    		if(left.val<right.val){
    			current.next = left;
    			left = left.next;
    		}
    		else{
    			current.next = right;
    			right = right.next;
    		}
    		current = current.next;
    	}
    	while(left!=null){
    		current.next = left;
    		left = left.next;
    		current = current.next;
    	}
    	while(right!=null){
    		current.next = right;
    		right = right.next;
    		current = current.next;
    	}
    	return head;
    }
    
    public static void main(String[] args){
    	SortList148 test = new SortList148();
		ListNode n0 = new ListNode(2);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n0.next = n1; n1.next = n2; //n2.next = n3;
		ListNode head = test.sortList(n0);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
    }
}
