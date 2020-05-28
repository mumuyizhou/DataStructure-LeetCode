package aimatoffer;

import aimatoffer.Question22KthNodeofNodeList.ListNode;

/**
 * @author ZhouPan
 * @date 2020-05-28
 */
public class Question52FirstCommonNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode pA = headA,pB = headB;
		while(pA != pB){
			pA = pA == null? headB: pA.next;
			pB = pB == null? headA: pB.next;
		}
		return pA;
	}
}
