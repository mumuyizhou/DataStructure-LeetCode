package leetcode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author 木木漪
 */
public class Question206ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p = head.next;
		head.next = null;
		ListNode tempNode = head;
		while (p != null) {
			head = p;
			p = p.next;
			head.next = tempNode;
			tempNode = head;
		}
		return tempNode;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
