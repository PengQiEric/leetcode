package january24_list;

import aTool.ListNode;

/**
 * @author PAUL QI
 *  
 *  Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

	You should preserve the original relative order of the nodes in each of the two partitions.
	
	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
 */

public class PartitionList86 {
	// it is kind of reconstruction
    public ListNode partition_twonewnode(ListNode head, int x) {
    	ListNode head1 = new ListNode(0);
    	ListNode head2 = new ListNode(0);
    	ListNode cur1 = head1, cur2 = head2;
    	while(head!=null){
    		if(head.val<x){
    			cur1.next = head;
    			cur1 = cur1.next;
    		}
    		else{
    			cur2.next = head;
    			cur2 = cur2.next;
    		}
    		head = head.next;
    	}
    	
    	cur1.next = head2.next;
    	cur2.next = null;
    	return head1.next;
    }
    
	/*
	 *  what I can learn from this example? 
	 *  sometimes we need to handle the new head. And try to think about all the possible situation.
	 */
	
    public ListNode partition_1(ListNode head, int x) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode start = null, slow = head, fast = head.next;
    	if(slow.val<x){
    		start = slow;
    	}
    	
    	while(fast!=null){
    		if(fast.val<x){
    			if(start == null){   // {2,1} 2
    				start = fast;
    				fast = fast.next;
    				slow.next = fast;

    				start.next = head;
    				head = start;
    			}
    			else{
    				if(start == slow){
    					start = start.next;
    					
    					slow = slow.next;
    					fast = fast.next;
    				}
    				else{
    					ListNode temp = start.next;
    					
    					slow.next = fast.next;
    					
    					start.next = fast;
    					fast.next = temp;
    					start = fast;
    					
    					fast = slow.next;
    				}
    			}
    		}
    		else{
    			slow = slow.next;
    			fast = fast.next;
    		}
    	}
    	
    	return head;
    }
    
    public static void main(String[] args){
    	PartitionList86 test = new PartitionList86();
    	
    	ListNode n1 = new ListNode(2);
    	ListNode n2 = new ListNode(1);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(2);
    	ListNode n5 = new ListNode(5);
    	ListNode n6 = new ListNode(2);
	    n1.next = n2; //n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
		ListNode head = test.partition(n1, 2);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
    }
    
    private ListNode partition(ListNode head, int x){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = null;
        if(head.val<x){
            slow = head;
        }
        ListNode fast = head;   // [1,1] 2        
        while(fast.next!=null){
            if(fast.next.val>=x){
                fast = fast.next;
            }
            else{
                ListNode temp = fast.next.next;
                if(slow == null){
                    fast.next.next = head;
                    head = fast.next;
                    slow = head;
                    fast.next = temp;
                }
                else{
                    ListNode t = slow.next;
                    if(t == fast.next){
                        slow = slow.next;
                        fast = fast.next;
                    }else{
                        slow.next = fast.next;
                        fast.next.next = t;
                        slow = slow.next;
                        fast.next = temp;
                    }
                }
            }
        }
        return head;
    }
}
