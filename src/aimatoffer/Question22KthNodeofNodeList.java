package aimatoffer;

/**
 * @author 木木漪
 */
public class Question22KthNodeofNodeList {
	/*输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
	即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
	它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。


示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

	* */
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode p = head;
		int count = 0;
		while (p.next != null) {
			count++;
			p = p.next;
		}
		int fromTop = count - k + 1;
		for (int i = 0; i < fromTop; i++) {
			head = head.next;
		}
		return head;
	}


	/**
	 * 大家的思路：使用快慢指针，快指针先走，走k步时，慢指针出发，此后快慢指针同步前进，
	 * 直到快指针走完，慢指针的位置就是倒数第k个节点。
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode getKthFromEndUsingFastSlowPointer(ListNode head, int k) {
		ListNode fp = head;
		ListNode sp = head;
		int count = 0;
		while (count < k) {
			fp = fp.next;
			count++;
		}
		while(fp != null){
			fp = fp.next;
			sp = sp.next;
		}
		return sp;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}
}
