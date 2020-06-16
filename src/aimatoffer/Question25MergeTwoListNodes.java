package aimatoffer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * @author ZhouPan
 * @date 2020-05-29
 */
public class Question25MergeTwoListNodes {
	public ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
		ListNode2 p1 = l1, p2 = l2, head = l1.val < l2.val ? l1 : l2;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				while (l1 != null && l1.val < l2.val) {
					p1 = l1;
					l1 = l1.next;
				}
				p1.next = l2;
			} else {
				while (l2 != null && l2.val <= l1.val) {
					p2 = l2;
					l2 = l2.next;
				}
				p2.next = l1;
			}
		}
		return head;
	}
}
