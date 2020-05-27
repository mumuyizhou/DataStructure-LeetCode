package leetcode;

/**
 * @author ZhouPan
 * @date 2020-05-27
 */
public class Question2AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int unit = l1.val + l2.val;
		int carry = unit / 10;
		int digit = unit % 10;
		l1 = l1.next;
		l2 = l2.next;
		ListNode startNode = new ListNode(digit);
		ListNode p = startNode;
		while (l1 != null || l2 != null) {
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			digit = sum % 10;
			carry = sum / 10;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			ListNode temp = new ListNode(digit);
			p.next = temp;
			p = temp;
		}

		return startNode;
	}

	public static void main(String[] args) {

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

