package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author ZhouPan
 * @date 2020-06-21
 */
public class Question7IntegerReverse {
	public int reverse(int x) {
		List<Long> list = new ArrayList<>();
		boolean pos = x > 0;
		long k = pos ? (long) x : -(long) x;
		while (k != 0) {
			list.add(k % 10);
			k = k / 10;
		}
		for (Long aLong : list) {
			k = k * 10 + aLong;
		}
		if (pos) return k > Integer.MAX_VALUE ? 0 : (int) k;
		return k > 1 + (long) Integer.MAX_VALUE ? 0 : (int) -k;
	}

	public static void main(String[] args) {
		Question7IntegerReverse question7IntegerReverse = new Question7IntegerReverse();
		question7IntegerReverse.reverse(Integer.MIN_VALUE);
	}
}
