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
    	System.out.println(heap[0].val+"->");
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
    	int k=0;
    	for(int j=(i+1)/2-1; j>=0 && i!=0; j = (j+1)/2-1){
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
    	ListNode n1 = new ListNode(-6);
    	ListNode n2 = new ListNode(-6);
    	ListNode n3 = new ListNode(-4);
    	ListNode n4 = new ListNode(2);
//    	ListNode n4 = new ListNode(-2);
//    	ListNode n4 = new ListNode(-2);
    	n1.next = n2; n2.next = n3; n3.next = n4;
    	
    	ListNode n5 = new ListNode(-10);
    	ListNode n6 = new ListNode(-5);
    	ListNode n60 = new ListNode(0);
    	ListNode n61 = new ListNode(1);
    	ListNode n62 = new ListNode(1);
    	ListNode n63 = new ListNode(1);
    	ListNode n64 = new ListNode(1);
    	ListNode n65 = new ListNode(3);
    	ListNode n66 = new ListNode(3);
    	n5.next = n6; n6.next = n60; n60.next=n61; n61.next=n62; n62.next=n63; n63.next=n64; n64.next=n65; n65.next=n66;
    	
    	ListNode n7 = new ListNode(-10);
    	ListNode n8 = new ListNode(-10);
    	ListNode n81 = new ListNode(-4);
    	ListNode n82 = new ListNode(-3);
    	ListNode n83 = new ListNode(0);
    	ListNode n84 = new ListNode(1);
    	ListNode n85 = new ListNode(1);
    	n7.next = n8; n8.next= n81; n81.next=n82; n82.next=n83; n83.next=n84;n84.next=n85;
    	
    	ListNode n9 = new ListNode(-10);
    	ListNode n10 = new ListNode(-6);
    	ListNode n11 = new ListNode(-6);
    	ListNode n12 = new ListNode(-4);
    	ListNode n02 = new ListNode(-4);
    	ListNode n03 = new ListNode(-3);
    	n9.next=n10;n10.next=n11;n11.next=n12; n12.next=n02; n02.next=n03;

    	ListNode n13 = new ListNode(-10);
    	ListNode n14 = new ListNode(-7);
    	ListNode n15 = new ListNode(-6);
    	n13.next = n14;n14.next = n15;

    	ListNode n16 = new ListNode(0);
    	
    	ListNode n17 = new ListNode(-5);
    	ListNode n18 = new ListNode(-5);
    	n17.next = n18;
    	
    	ListNode n19 = new ListNode(0);
    	ListNode n20 = new ListNode(0);
    	ListNode n21 = new ListNode(0);
    	ListNode n22 = new ListNode(0);
    	ListNode n23 = new ListNode(0);

    	
    	List<ListNode> lists = new LinkedList<ListNode>();
    	
    	ListNode n24 = null;
//    	lists.add(n11);
    	lists.add(n1);
    	lists.add(n5);
    	lists.add(n7);

    	lists.add(n9);
    	lists.add(n16);
    	lists.add(n17);
    	lists.add(n24);
    	lists.add(n13);

//    	lists.add(n5);
//    	System.out.println(lists.toString());
    	MergekSortedLists23 test = new MergekSortedLists23();
    	ListNode result = test.mergeKLists(lists);
    	while(result!=null){
    		System.out.print(result.val+"->");
    		result = result.next;
    	}
    }
    
}
