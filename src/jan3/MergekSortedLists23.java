package jan3;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Paul Qi
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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

public class MergekSortedLists23 {
	ListNode last = new ListNode(0);

    public ListNode mergeKLists(List<ListNode> lists) {
    	
    	// create the heap;
    	ListNode[] heap = new ListNode[lists.size()];
    	heap[0] = lists.get(0);
    	for(int i=1; i<lists.size(); i++){
    		heapInsert(heap, i, lists.get(i));
    	}
    	int result = 0;
    	ListNode head = last;
    	do{
    		result = heapDelete(heap,null, result);
    	}while(result!=(lists.size()));
    	
    	return head.next;
    }
    
    public int heapDelete(ListNode[] heap,ListNode last1, int start){
    	last.next = heap[start];
    	
    	if(heap[start].next!=null){
    		ListNode element = heap[start].next;
    		heapAdjust(heap, start, element);
    		last = last.next;
    		return start;
    	}
    	else{
    		if(start == heap.length-1){
    			return heap.length;
    		}
    		heapAdjust(heap,start+1, heap[start+1]);
    		last = last.next;
    		return start+1;
    	}
    }
    
    public static void heapAdjust(ListNode[] heap, int start, ListNode element){
    	int end = heap.length-1;
    	for(int i=(start+1)*2-1; i<=end; i = (i+1)*2-1){
    		if(i<end && heap[i].val>heap[i+1].val)i++;
    		if(element.val <= heap[i].val) break;
    		heap[start] = heap[i];
    		start = i;
    	}    	
    	heap[start] = element;
    }
    
    public void heapInsert(ListNode[] heap, int i, ListNode element){
    	for(int j=i/2; j>=0 && i!=0; j = j/2){
    		if(heap[j].val <= element.val){
    			heap[i] = element; break;
    		}
    		else{
    			heap[i] = heap[j];
    			i=j;
    		}
    	}
    	heap[i] = element;
    }
    
    
    public static void main(String[] args){
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	ListNode n6 = new ListNode(6);
    	ListNode n7 = new ListNode(7);
    	ListNode n8 = new ListNode(8);
    	ListNode n9 = new ListNode(9);
    	ListNode n10 = new ListNode(10);
    	ListNode n11 = new ListNode(11);
    	ListNode n12 = new ListNode(12);
    	n1.next = n4; n4.next = n7; n7.next=n10;
    	n2.next = n5; n5.next = n8; n8.next = n11;
    	n3.next = n6; n6.next = n9; n9.next = n12;
    	List<ListNode> lists = new LinkedList<ListNode>();
//    	lists.add(n11);
//    	lists.add(n9);
//    	lists.add(n7);
    	lists.add(n3);
    	lists.add(n2);
    	lists.add(n1);
//    	lists.add(n5);
    	MergekSortedLists23 test = new MergekSortedLists23();
    	ListNode result = test.mergeKLists(lists);
    	while(result!=null){
    		System.out.print(result.val+"->");
    		result = result.next;
    	}
    }
    
}
