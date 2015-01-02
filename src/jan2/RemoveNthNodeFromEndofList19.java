package jan2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Paul Qi
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
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

public class RemoveNthNodeFromEndofList19 {
	
	// precondition : Given n will always be valid.
	// two pointers
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	ListNode slow = head, fast = head;
//    	for(int i=1; i<n; i++){
    	for(int i=0; i<n; i++){
    		if(fast.next == null){
    			return head.next;
    		}
    		fast = fast.next;
    	}
    	
//    	if(fast.next == null){
//    		
//    	}
    	
    	while(fast.next!=null){
    		fast = fast.next;
    		slow = slow.next;
    	}
    	slow.next = slow.next.next;
//    	slow = slow.next;  //it only works in C++, because java always pass by reference
    	return head;
    }
	
	// This is not elegant enough
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
    	Deque<ListNode> stack = new ArrayDeque<ListNode>();
    	ListNode pointer = head;
    	while(pointer!=null){
    		stack.push(pointer);
    		pointer = pointer.next;
    	}
    	int i = n;
    	while(i>1){
    		stack.pop();
    		i--;
    	}
    	
    	ListNode deletedNode = stack.pop();
    	if(stack.isEmpty()){
    		return head.next;
    	}
    	else{
    		ListNode prevNode = stack.pop();
    		prevNode.next = deletedNode.next;
    	}
        return head;
    }
    
    public static void main(String[] args){
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
//    	n1.next = n3;
//    	n2 = n3; // because n1 refer to the object that n2 refer to.
    	ListNode result = removeNthFromEnd(n1, 5);
    	while(result!=null){
    		System.out.print(result.val+"->");
    		result = result.next;
    	}
    	
    }
}
