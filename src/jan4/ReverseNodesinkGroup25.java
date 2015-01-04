package jan4;

/**
 * @author Paul Qi
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
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

public class ReverseNodesinkGroup25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null){
    		return null;
    	}
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        do{
	        int i;
	        for(i=1; i<k; i++){
	        	if(fast.next!=null){
	        		fast = fast.next;
	        	}
	        	else{
	        		break;
	        	}
	        }
	        if(i<k){
	        	return head;
	        }
	        
	        ListNode temp = fast.next;
	        if(prev == null){
	        	head = fast;
	        }
	        else{
	        	prev.next = fast;
	        }
	        
	        //internal relation reverse the order
	        ListNode tmpPrev = slow;
	        ListNode tmpNext = slow.next;
	        for(int j=1; j<k; j++){
	        	ListNode t = tmpNext.next;
	        	tmpNext.next = tmpPrev;
	        	tmpPrev = tmpNext;
	        	tmpNext = t;
	        }	        
	        slow.next = temp;
	        prev = slow;
	        slow = temp;
	        fast = temp;
        }while(fast!=null);
        
    	return head;
    }
    
    public static void main(String[] args){
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
    	
    	ListNode result = reverseKGroup(n1, 2);
    	while(result!=null){
    		System.out.print(result.val+"->");
    		result = result.next;
    	}
    }
}
