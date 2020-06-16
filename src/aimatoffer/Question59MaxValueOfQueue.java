package aimatoffer;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * 限制：
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * @author ZhouPan
 * @date 2020-06-16
 */
public class Question59MaxValueOfQueue {
	ListNode2 dequeHead;
	ListNode2 dequeTail;
	ListNode2 head;
	ListNode2 tail;

	public Question59MaxValueOfQueue() {

	}

	public int max_value() {
		return dequeHead == null ? -1 : dequeHead.val;
	}

	public void push_back(int value) {
		if (dequeHead == null) {
			dequeHead = new ListNode2(value);
			dequeTail = dequeHead;
		} else {
			while (dequeTail.val < value) {
				dequeTail = dequeTail.prev;
				if (dequeTail == null) {
					dequeHead = null;
					break;
				}
			}
			ListNode2 tmp = new ListNode2(value);
			if (dequeHead == null) {
				dequeHead = tmp;
				dequeTail = dequeHead;
			} else {
				dequeTail.next = tmp;
				tmp.prev = dequeTail;
				dequeTail = tmp;
			}
		}

		if (tail == null) {
			head = new ListNode2(value);
			tail = head;
		} else {
			tail.next = new ListNode2(value);
			tail = tail.next;
		}
	}

	public int pop_front() {
		if (head == null) return -1;
		int headVal = head.val;
		if (headVal == dequeHead.val) {
			dequeHead = dequeHead.next;
			if (dequeHead == null) {
				dequeTail = null;
			} else {
				dequeHead.prev = null;
			}
		}
		head = head.next;
		if (head == null) tail = null;
		return headVal;
	}

	public static void main(String[] args) {
		Question59MaxValueOfQueue question59MaxValueOfQueue = new Question59MaxValueOfQueue();
		question59MaxValueOfQueue.push_back(94);
		question59MaxValueOfQueue.push_back(16);
		question59MaxValueOfQueue.push_back(89);
		question59MaxValueOfQueue.pop_front();
		question59MaxValueOfQueue.push_back(22);
		question59MaxValueOfQueue.pop_front();

	}
}


class ListNode2 {
	int val;
	ListNode2 next;
	ListNode2 prev;

	public ListNode2(int val) {
		this.val = val;
	}
}
