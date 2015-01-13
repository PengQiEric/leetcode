package january13;

/**
 * 
 * @author Paul Qi
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class RotateList61 {
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null || n == 0)
    		return head;
    	
    	ListNode slow = head, fast = head;
    	for(int i=0; i<n; i++){
    		if(fast.next!=null){
    			fast = fast.next;
    		}
    		else{
    			fast = head;   // it is important here, just like cyclic linked list.
    		}
    	}
    	
    	while(fast.next!=null){
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	fast.next = head;
    	head = slow.next;
    	slow.next = null;
    	
    	return head;
    }
    
    public static void main(String[] args){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);
    	l1.next = l2;// l2.next = l3; l3.next = l4; l4.next = l5;
    	
    	RotateList61 test = new RotateList61();
    	ListNode head = test.rotateRight(l1, 3);
    	while(head!=null){
    		System.out.print(head.val+"->");
    		head = head.next;
    	}
    }
}
