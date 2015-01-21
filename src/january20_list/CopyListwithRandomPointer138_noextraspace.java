package january20_list;

public class CopyListwithRandomPointer138_noextraspace {
    // first solution using hash map, can we clone it without extra space?
	public RandomListNode copyRandomList(RandomListNode head) {

		/*
		 * As an optimised solution, we could reduce the space complexity into constant. 
		 * The idea is to associate the original node with its copy node in a single linked list. 
		 * In this way, we don't need extra space to keep track of the new nodes.
		 * 
		 * The algorithm is composed of the follow three steps which are also 3 iteration rounds.
		 * 1. Iterate the original list and duplicate each node. 
		 * 	  The duplicate of each node follows its original immediately.
		 * 2. Iterate the new list and assign the random pointer for each duplicated node.
		 * 3. Restore the original list and extract the duplicated nodes.
		 */
		
		 RandomListNode current = head, next;
		 while(current != null){
			 next = current.next;
			 RandomListNode clone = new RandomListNode(current.label);
			 current.next = clone;
			 clone.next = next;
			 
			 current = next;
		 }
		 current = head;
		 while(current!=null){
			 if(current.random == null){
				 current.next.random = null;
			 }
			 else{
				 current.next.random = current.random.next;
			 }
			 current = current.next.next;
		 }
		 if(head == null){
			 return null;
		 }
		 else{
			 RandomListNode newHead = head.next, newCurrent=null;
			 current = head;
			 while(current!=null){
				 next = current.next.next;
				 newCurrent = current.next;
				 
				 current.next = newCurrent.next; // restore the original linked list
				 if(next!=null){
					 newCurrent.next = next.next; // get the new clone list
				 }else{
					 newCurrent.next = null;
				 }
				 
				 current = next;
			 }
			 return newHead;
		 }
    }
}
