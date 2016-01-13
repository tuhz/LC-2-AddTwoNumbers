package me.tuhz.leetcode;

public class Solution2 {
	
	/* This solution beats 98.54% of submissions on LCoj (runtime: 3ms) */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0, val;
		ListNode ans = l1;
		//while neither l1 nor l2 has reached the last element
		while (l1.next != null && l2.next != null) {
			val = l1.val + l2.val + carry;
			l1.val = val % 10;
			carry = val / 10;
			l1 = l1.next; l2 = l2.next;
		}
		
		// summing up the last elements
		val = l1.val + l2.val + carry;
		l1.val = val % 10;
		carry = val / 10;
		
		// one of the Lists has reached its last element
		if (l1.next != null || l2.next != null) {		
			if (l2.next != null)
				l1.next = l2.next; 
			l1 = l1.next;
			
			while (carry != 0) {
				val = l1.val + carry;
				l1.val = val % 10;
				carry = val / 10;
				if (l1.next != null)
					l1 = l1.next;
				else 
					break;
			}
		}
		
		// if there's still a carry after the last element, 
		// then append a new node (1) to the last element
		if (carry != 0){
			l1.next = new ListNode(1);
			carry = 0;
		}
		
		return ans;
    }
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
