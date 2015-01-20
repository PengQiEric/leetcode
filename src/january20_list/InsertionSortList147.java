package january20_list;

import aTool.ListNode;

/**
 * @author PAUL QI 
 * 
 * Sort a linked list using insertion sort.
 */

public class InsertionSortList147 {
	public ListNode insertionSortList(ListNode head) {
		ListNode newHead = head;
		if(head == null || head.next == null){
			return head;
		}
		ListNode cur = head.next,//from the second element 
				next = null;
		head.next = null;
		while (cur != null) {
			next = cur.next;

			cur.next = null; // make sure the whole link can terminate
			// insert cur;
			if (cur.val < newHead.val) {
				cur.next = newHead;
				newHead = cur;
			} 
			else 
			{
				ListNode temp = newHead;
				while (temp.next != null && temp.next.val < cur.val) {
					temp = temp.next;
				}
				cur.next = temp.next;
				temp.next = cur;
			}
			cur = next;
		}
		return newHead;
	}

	public void insertSortArray(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] < nums[j]) {
					int temp = nums[i];
					for (int k = i; k > j; k--) {
						nums[k] = nums[k - 1];
					}
					nums[j] = temp;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		InsertionSortList147 test = new InsertionSortList147();
//		int[] nums = new int[] { 2, 3, 1, 8, 5, 4, 7 };
//		test.insertSortArray(nums);
//		for (int i : nums) {
//			System.out.print(i + " ");
//		}
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n0.next = n2; n2.next = n1;
		
		ListNode head = test.insertionSortList(n0);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}
