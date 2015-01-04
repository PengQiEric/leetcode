package jan3;

/**
 * @author Paul Qi
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 */

/**
 * Definition for singly-linked list.
 */


public class SwapNodesinPairs24 {
    
	public static ListNode swapPairs(ListNode head) {
		ListNode current = head;
		ListNode prev=null;
		while(current!=null){
			if(current.next == null){
				break;
			}
			ListNode next = current.next;
			if(prev == null){
				head = next;
			}
			else{
				prev.next = next;
			}
			ListNode temp = next.next;
			next.next = current;
			current.next = temp;
			prev = current;
			current = current.next;
		}
		return head;
    }
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2; n2.next = n3; n3.next = n4;
		
		ListNode result = swapPairs(n1);
		while(result!=null){
			System.out.print(result.val+"->");
			result = result.next;
		}
	}
}
