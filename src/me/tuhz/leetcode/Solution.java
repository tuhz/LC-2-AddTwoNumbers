package me.tuhz.leetcode;

public class Solution {

	/* runtime: 5ms*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ptr = new ListNode((l1.val + l2.val) % 10);
		ListNode ans = ptr;
		boolean first = true;
		int temp, carry = (l1.val + l2.val) / 10;
		l1 = l1.next; l2= l2.next;
		while (l1 != null || l2 != null) {
			temp = carry;
			if (l1 != null) {
				temp += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				temp += l2.val;
				l2 = l2.next;
			}
			
			if (temp >= 10) {
				carry = 1;
				temp = temp % 10;
			}
			else {
				carry = 0;
			}
			ptr.next = new ListNode(temp);
			if (first) {
				ans = ptr;
				first = false;
			}
			ptr = ptr.next;
		}
		if (carry != 0) {
			ptr.next = new ListNode(1);
			if (first) {
				ans = ptr;
				first = false;
			}
		}
		
		return ans;        
    }
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		ListNode l2 = l1;
		System.out.println(l2.val);
		l1.val = 4;
		System.out.println(l2.val);		
	}
}
