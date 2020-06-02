package leetcode;

import aimatoffer.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数
 * 是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
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

