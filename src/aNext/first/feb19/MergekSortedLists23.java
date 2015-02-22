package aNext.first.feb19;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import sun.tools.tree.Node;
import aTool.ListNode;

/**
 * @author PAUL QI
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class MergekSortedLists23 {
    public ListNode mergeKLists(List<ListNode> lists) {
    	if(lists.size() == 0){
    		return null;
    	}
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
    				public int compare(ListNode l1, ListNode l2){
    					return l1.val-l2.val;
    				}
    	});
    	
    	for(ListNode l: lists){
    	    if(l!=null)
    		    queue.add(l);
    	}
    	
    	ListNode head = new ListNode(0);
    	ListNode cur = head;
    	while(!queue.isEmpty()){
    		ListNode temp = queue.poll();
    		if(temp.next!=null){
    			queue.add(temp.next);
    		}
    		
    		cur.next = temp;
    		cur = cur.next;
    	}
    	return head.next;
    }
}
