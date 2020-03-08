package aimatoffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * @author 木木漪
 */
public class Question21TiaoZhengShuZuJiOuShunXu {
	public int[] exchange(int[] nums) {
		int len = nums.length;
		int even = 1;
		for (int i = 0; i < len; i++) {
			if (nums[i] % 2 == 0) {
				while (even < len) {
					if (nums[even] % 2 != 0 ) {
						swap(nums, i, even);
						break;
					} else {
						even++;
					}
				}
			} else {
				even++;
			} ;
		}
		return nums;
	}

	public void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
	}

	public static void main(String[] args) {
		Question21TiaoZhengShuZuJiOuShunXu shunXu = new Question21TiaoZhengShuZuJiOuShunXu();
		int[] a = new int[50000];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		System.out.println(Arrays.toString(shunXu.exchange(new int[]{1,11,14})));
	}
}
