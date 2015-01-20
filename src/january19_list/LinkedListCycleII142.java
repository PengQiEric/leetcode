package january19_list;

import aTool.ListNode;

/**
 * @author PAUL QI
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */
// if we can use HASHSET, the problem become so easy.

public class LinkedListCycleII142 {
	
	//https://oj.leetcode.com/discuss/18393/share-complexity-constant-space-code-original-list-comments
	public ListNode detectCycle_On(ListNode head){
		// when the slow meet the fast, what it means? 
		// it means the fast pointer runs more than K loop size than slow pointer
		// k=1 why? because fast pointer will not miss the first meet chance, because every time, it only catch 1 steps.
		// that's the reason why we only two time fast.
		
		// and based on this, slow pointer has walked at exact 1 loop size.   
		// because fast - slow  = 1 loop size   fast = 2 * slow.
		// then slow just need to walk N path to the joint point, where N is the length of from the head to the joint
		
		ListNode fast= head, slow = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				fast = head;
				while(fast!=slow){
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
	
	
	// O(n^2) AC solution, but based on the refer, we can have O(n) solution
    public ListNode detectCycle(ListNode head) {
		boolean first = true;
		ListNode fast = head, slow = head;
		while((fast!=null && fast.next!=null) && (first || (!slow.equals(fast) ))){ // slow!=fast
			first = false;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast == null || fast.next==null){
			return null;
		}
		else{
			boolean isFirst = true;
			ListNode current = fast;
			System.out.println(fast.val);
			ListNode begin = head;
			while(fast!=begin || isFirst){
				if(fast == begin){
					first = false;
				}
				do{
					if(current == begin){
						return begin;
					}
					current = current.next;
				}while(current!=fast);
				begin = begin.next;
			}
		}
		return null;
    }
    
    public static void main(String[] args){
    	ListNode n0 = new ListNode(0);
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	n0.next = n1;
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n1;
    	
    	LinkedListCycleII142 test = new LinkedListCycleII142();
    	System.out.println(test.detectCycle(n0).val);
    }
    
    
    
    
    // O(n^2) not good
/*    	public ListNode detectCycle(ListNode head) {
    	ListNode slow = head;
    	while(slow!=null){
    		ListNode fast = slow.next;
    		while(fast!=null){
    			if(fast == slow){
    				return slow;
    			}
    			fast = fast.next;
    		}
    		slow = slow.next;
    	}
    	return null;
    }
*/}
