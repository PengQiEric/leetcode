package aNext.first.feb19;

import aTool.ListNode;

public class ListSummary {

	
	/*
	 * Remove Duplicates from Sorted List II 
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	// we need two pointer
    	ListNode pre = null, cur = head;
    	
    	while(cur!=null && cur.next!=null){	// time to terminate the loop why? because I can guarantee it differ from before 
    		if(cur.val!=cur.next.val){
    			pre = cur;
    		}
    		else{	// they are the same;
    			while(cur.next!= null && cur.next.val == cur.val){	// is it a good situation to stop?
    				cur.next = cur.next.next;
    			}
    			if(pre == null){
    				head = cur.next;
    			}
    			else{
    				pre.next = cur.next;	// this is great, I never move the pre pointer
    			}
    		}
    		cur = cur.next;
    	}
    	return head;
    }
    
    public ListNode deleteDuplicates_dummyNode(ListNode head){
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;

    	ListNode pre = dummy;
    	while(head!=null && head.next != null){
    		if(head.val!=head.next.val){
    			pre.next = head;
    			pre = pre.next;
    		}
    		else{
    			while(head.next!=null && head.next.val == head.val){
    				head = head.next;
    			}
    			pre.next = head.next;	// this is great! you pointer to the next possible solution
    		}
    		head = head.next;
    	}
    	return dummy.next;
    }
	
    /*
     * Swap Nodes in Pairs
     */
    public ListNode swapPairs(ListNode head) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode pre = dummy, cur = head;			// pre-> X(cur) X -> it's kind of this relationship
    	while(cur!=null && cur.next!=null){
    		pre.next = cur.next;	// we store pre.next, i.e. cur
    		cur.next = cur.next.next;
    		pre.next.next = cur;
    		
    		pre = cur;
    		cur = cur.next;
    	}
    	return dummy.next;
    }
    
    /*
     * Remove Nth Node From End of List 
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	// first make sure, when to stop.
    	ListNode fast = head;
    	for(int i=1; i<=n && fast!=null ; i++){
    		fast = fast.next;
    	}
    	if(fast == null){
    		return head.next;
    	}
    	ListNode slow = head;
    	while(fast.next!=null){	// very important, when to stop the loop.
    		slow = slow.next;
    		fast = fast.next;
    	}
    	slow.next = slow.next.next;
    	return head;
    }
    
    
    /*
     * Partition List 
     */
    public ListNode partition(ListNode head, int x) {
    	// need a smaller pointer and cur point
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode smaller = dummy, cur = dummy;
    	while(cur.next!=null && cur.next.val<x){
    		smaller = smaller.next;
    		cur = cur.next;
    	}
    	// if you want to change something based on for example, they are not adjacent, make sure it is not
    	while(cur.next!=null){	// it means every time we change the postion of current.NEXT 
    		if(cur.next.val<x){
    			ListNode temp = cur.next.next;
//    			cur.next = smaller.next;
    			cur.next.next = smaller.next;
    			smaller.next = cur.next;
    			smaller = smaller.next;
    			
    			cur.next = temp;
    		}
    		else{
    			cur = cur.next;
    		}
    	}
    	return dummy.next;
    }
    
    
    /*
     * Insertion Sort List 
     */
    public ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	
    	ListNode cur = head.next;
    	head.next = null;
    	do{
    		ListNode temp = cur.next;
    		cur.next = null;
    		
    		if(cur.val<head.val){
    			cur.next = head;
    			head = cur;
    		}
    		else{
    			ListNode node = head;
    			while(node.next!=null && node.next.val<cur.val){ // get the previous node of the first node > current node
    				node = node.next;
    			}
    			cur.next = node.next;
    			node.next = cur;
    		}
    		cur = temp;
    	}while(cur!=null);
    	return head;
    }
    
    
}
