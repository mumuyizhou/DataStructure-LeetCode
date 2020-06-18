package aimatoffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * 限制：
 * 数组长度为 5 
 * 数组的数取值为 [0, 13] .
 *
 * @author ZhouPan
 * @date 2020-06-18
 */
public class Question61StraightInCards {
	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int prev = 0;
		int accum = 0;
		boolean flag = true;
		for (int i = 0; i < 5; i++) {
			if (nums[i] == 0) continue;
			if (flag) {
				prev = nums[i];
				flag = false;
				continue;
			}
			if (nums[i] == prev) return false;
			accum += nums[i] - prev;
			prev = nums[i];
		}
		return accum <= 4;
	}

	public void quickSort(int[] arr, int low, int high) {
		if (low >= high - 1) return;
		int bench = arr[low];

		for (; ; ) {
			while (arr[high] >= bench) {
				high--;
			}
			arr[low++] = arr[high];
			while(arr[low] <= bench){
				low++;
			}
			arr[high--] = arr[low];
		}
	}

	public boolean isStraightBySet(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num == 0) continue;
			if (set.contains(num)) return false;
			max = Math.max(max, num);
			min = Math.min(min, num);
			set.add(num);
		}
		return max - min < 5;
	}
}
