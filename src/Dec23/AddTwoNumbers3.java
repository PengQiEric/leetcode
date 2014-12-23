package Dec23;

/**
 * @author Paul Qi 
 * You are given two linked lists representing two non-negative
 * numbers. The digits are stored in reverse order and each of their
 * nodes contain a single digit. Add the two numbers and return it as a
 * linked list. 
 *         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
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

public class AddTwoNumbers3 {
	public static void main(String[] args){
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode la = new ListNode(5);
		ListNode lb = new ListNode(6);
		ListNode lc = new ListNode(4);
		l1.next = l2; l2.next = l3;
		la.next = lb; lb.next = lc;
		ListNode r = addTwoNumbers(l1, la);
		do{
			System.out.print(r.val+"->");
			r = r.next;
		}while(r!=null);
	}
	// precondition: l1, l2 not null 
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode nextL1 = l1.next, nextL2 = l2.next;    	
    	// need to store the root
    	int carryBit = (l1.val+l2.val)/10;
    	ListNode nextResult = new ListNode((l1.val+l2.val)%10);
    	ListNode root = nextResult;
    	
    	while(nextL1!=null && nextL2!=null){
    		nextResult.next = new ListNode((nextL1.val+nextL2.val+carryBit)%10);
    		carryBit = (nextL1.val+nextL2.val+carryBit)/10;
    		
    		nextL1 = nextL1.next; nextL2 = nextL2.next; nextResult = nextResult.next;
    	}
    	if(carryBit == 1){
    		nextResult.next = new ListNode(carryBit);
    	}
        return root;
    }
}
