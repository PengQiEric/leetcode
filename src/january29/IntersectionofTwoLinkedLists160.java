package january29;

import java.util.Stack;

import aTool.ListNode;
import aTool.TreeNode;

/**
 * @author PAUL QI
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.

	For example, the following two linked lists:
	
	A:          a1 → a2
	                   ↘
	                     c1 → c2 → c3
	                   ↗            
	B:     b1 → b2 → b3
	begin to intersect at node c1.
	
	Notes:
	
	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class IntersectionofTwoLinkedLists160 {
	
	/*
	 *  Two pointer solution (O(n+m) running time, O(1) memory):
		Maintain two pointers pA and pB initialized at the head of A and B, respectively. 
		Then let them both traverse through the lists, one node at a time.
		When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); 
		similarly when pB reaches the end of a list, redirect it the head of A.
		If at any point pA meets pB, then pA/pB is the intersection node.
		Similar as mine
	 */
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	// calculate the length first.
        int lengthA = 0, lengthB = 0;
        ListNode currentA = headA, currentB = headB;
        while(currentA!=null){
            lengthA++;
            currentA = currentA.next;
        }
        while(currentB!=null){
            lengthB++;
            currentB = currentB.next;
        }
        if(lengthA<lengthB){
            int gap = lengthB - lengthA;
            currentB = headB;
            while(gap--!=0)
                currentB = currentB.next;
            currentA = headA;
        }
        else if(lengthB<lengthA){
            int gap = lengthA - lengthB;
            currentA = headA;
            while(gap--!=0){
                currentA = currentA.next;
            }
            currentB = headB;
        }
        else{ // test case: the same length, we need reset the currentA and currentB.
            currentA = headA;
            currentB = headB;
        }
        
        while(currentA!=null){
            if(currentA == currentB){
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }
}


class BSTIterator {
    private Stack<TreeNode> stack =  new Stack<TreeNode>(); 
    public BSTIterator(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        int value = cur.val;		// really need to be careful, cur has changed.
        cur = cur.right;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        return value;
    }
}