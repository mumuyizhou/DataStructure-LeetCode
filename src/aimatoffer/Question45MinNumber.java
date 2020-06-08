package aimatoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 提示:
 * 0 < nums.length <= 100
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * @author ZhouPan
 * @date 2020-06-08
 */
public class Question45MinNumber {
	public String minNumber(int[] nums) {
		// TODO: 2020/6/8 解出来！
		StringBuilder builder = new StringBuilder(2 * nums.length);
		PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> Integer.parseInt(o1 + o2) - Integer.parseInt(o2 + o1));
		for (int num : nums) {
			pq.add(String.valueOf(num));
		}
		while (!pq.isEmpty()) {
			builder.append(pq.poll());
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		Question45MinNumber minNumber = new Question45MinNumber();
		System.out.println(minNumber.minNumber(new int[]{3, 304564561, 344563212, 5, 9, 0}));
	}
}
