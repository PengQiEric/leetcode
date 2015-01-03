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
    	// input []
    	if(lists.size() == 0){
    		return null;
    	}
    	// create the heap;
    	int size = 0;
    	for(int i=0; i<lists.size(); i++){
    		if(lists.get(i)!=null){
    			size++;
    		}
    	}
    	ListNode[] heap = new ListNode[size];
    	

    	for(int i=0, j=0; i<lists.size(); i++){
    		if(lists.get(i) != null){
        		heapInsert(heap, j, lists.get(i));
        		j++;
    		}
    	}
    	int heapSize = heap.length-1;
    	ListNode head = last;
    	while(heapSize>=0){
    		heapSize = heapDelete(heap, heapSize);
    	}
    	return head.next;
    }
    
    public int heapDelete(ListNode[] heap, int end){
    	last.next = heap[0];
    	
    	if(heap[0].next!=null){
    		ListNode element = heap[0].next;
    		heapAdjust(heap, end, element);
    		last = last.next;
    		return end;
    	}
    	else{
    		if(end == 0){
    			return -1;
    		}
    		heap[0] = heap[end];
    		heapAdjust(heap,end-1, heap[0]);
    		last = last.next;
    		return end-1;
    	}
    }
    
    public static void heapAdjust(ListNode[] heap, int end, ListNode element){
    	int begin = 0;
    	for(int i=1; i<=end; i = (i+1)*2-1){
    		if(i<end && heap[i].val>heap[i+1].val)i++;
    		if(element.val <= heap[i].val) break;
    		heap[begin] = heap[i];
    		begin = i;
    	}    	
    	heap[begin] = element;
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
    	//n1.next = n4; //n4.next = n7; n7.next=n10;
//    	n2.next = n5; n5.next = n8; n8.next = n11;
    	n3.next = n6; n6.next = n9; n9.next = n12;
    	List<ListNode> lists = new LinkedList<ListNode>();
//    	lists.add(n11);
//    	lists.add(n9);
//    	lists.add(n7);
//    	lists.add(n3);
    	n1 = null;
//    	n2 = null;
    	lists.add(n1);
    	lists.add(n2);
//    	lists.add(n5);
    	System.out.println(lists.toString());
    	MergekSortedLists23 test = new MergekSortedLists23();
    	ListNode result = test.mergeKLists(lists);
    	while(result!=null){
    		System.out.print(result.val+"->");
    		result = result.next;
    	}
    }
    
}
