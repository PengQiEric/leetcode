package january20_list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PAUL QI
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
	  int label;
	  RandomListNode next, random;
	  RandomListNode(int x) { this.label = x; }
};

public class CopyListwithRandomPointer138 {
	// brute force O(n^2) O(N) copy the next pointer, O(N^2) copy the N random pointer
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode cur = head, cloneCur, prev=null;
    	if(head == null){
    		return null;
    	}
    	Map<RandomListNode, RandomListNode> cloneMap = new HashMap<RandomListNode, RandomListNode>();
    	while(cur!=null){
    		cloneCur = new RandomListNode(cur.label);
    		cloneMap.put(cur,cloneCur);
    		if(prev!=null){
    			prev.next = cloneCur;
    		}
    		
    		prev = cloneCur;
    		cur = cur.next;
    	}
    	RandomListNode newHead = cloneMap.get(head);
    	cur = head;
    	cloneCur = newHead;
    	while(cur!=null){
    		RandomListNode linked = cur.random;
    		if(linked == null){
    			cloneCur.random = null;
    		}
    		else{
    			cloneCur.random = cloneMap.get(linked);
    		}
    		
    		cur = cur.next;
    		cloneCur = cloneCur.next;
    	}
    	
    	return newHead;
    }
}
