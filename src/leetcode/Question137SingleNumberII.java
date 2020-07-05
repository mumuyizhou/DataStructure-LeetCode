package leetcode;

import java.util.Stack;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * @author ZhouPan
 * @date 2020-06-20
 */
public class Question137SingleNumberII {
	/**
	 * 用状态机解
	 *
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		int len = nums.length, one = 0, two = 0;
		for (int num : nums) {
			one = (num ^ one) & ~two;
			two = (num ^ two) & ~one;
		}
		return one;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE  + 1);
	}
}
