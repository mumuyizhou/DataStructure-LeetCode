package leetcode;

/**
 * @author 木木漪
 */
public class Question160IntersectionOfTwoLinkedLists {
	/*输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
*/
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pointerA = headA;
		ListNode pointerB = headB;
		boolean a = false;
		boolean b = false;
		ListNode intersectVal = null;

		while (!(a && b)) {
			if (pointerA != null) {
				pointerA = pointerA.next;
			} else {
				pointerA = headB;
				a = true;
			}
			if (pointerB != null) {
				pointerB = pointerB.next;
			} else {
				pointerB = headA;
				b = true;
			}
		}

		while (pointerA != null && pointerB != null) {
			if (pointerA != pointerB) {
				intersectVal = null;
			} else if (intersectVal == null) {
				intersectVal = pointerA;
			}
			pointerA = pointerA.next;
			pointerB = pointerB.next;
		}

		return intersectVal;
	}

	/**
	 * 借用大神的奇思妙想思路写的
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNodeSimplified(ListNode headA, ListNode headB) {
		ListNode pointerA = headA, pointerB = headB;
		while (pointerA != pointerB) {
			pointerA = pointerA == null ? headB : pointerA.next;
			pointerB = pointerB == null? headA : pointerB.next;
		}
		return pointerA;
	}

	public void traversal(ListNode first) {
		System.out.print(first.val + " ");
		if (first.next != null) {
			traversal(first.next);
		} else {
			System.out.println();
		}
	}

	public void init() {
		ListNode nodeA = new ListNode(1);
		ListNode nodeB = new ListNode(2);
		ListNode nodeC = new ListNode(3);
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		ListNode inter = getIntersectionNode(nodeA, nodeA);
		traversal(nodeA);
		System.out.println(inter.val + " " + inter.next);
	}

	public ListNode reverseNodeList(ListNode first) {
		ListNode watcherNode;
		ListNode tempNode;
		tempNode = first;
		first = first.next;
		tempNode.next = null;
		watcherNode = tempNode;
		boolean a = true;
		boolean b = false;
		while (first != null) {
			tempNode = first;
			first = first.next;
			tempNode.next = watcherNode;
			watcherNode = tempNode;
		}
		return watcherNode;
	}

	public static void main(String[] args) {
		Question160IntersectionOfTwoLinkedLists lists = new Question160IntersectionOfTwoLinkedLists();
		lists.init();

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
