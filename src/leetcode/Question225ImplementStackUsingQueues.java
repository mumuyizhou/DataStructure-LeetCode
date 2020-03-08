package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author 木木漪
 */
public class Question225ImplementStackUsingQueues {
	Deque<Integer> stack;

	/**
	 * Initialize your data structure here.
	 */
	public Question225ImplementStackUsingQueues() {
		stack = new ArrayDeque<>();
	}

	/**
	 * Push element x onto stack.
	 */
	public void push(int x) {
		stack.push(x);
	}

	/**
	 * Removes the element on top of the stack and returns that element.
	 */
	public int pop() {
		return stack.pop();
	}

	/**
	 * Get the top element.
	 */
	public int top() {
		return stack.getFirst();

	}

	/**
	 * Returns whether the stack is empty.
	 */
	public boolean empty() {
		return stack.isEmpty();
	}
}
