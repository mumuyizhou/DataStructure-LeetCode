package aimatoffer;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author ZhouPan
 * @date 2020-05-29
 */
public class Question6ReversePrintListNode {
	public int[] reversePrint(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		int[] arr = new int[stack.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop().val;
		}
		return arr;
	}


}
