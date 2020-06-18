package aimatoffer;

import java.util.*;

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
		int rawLow = low;
		int rawHigh = high--;
		outer:
		while (high > low) {
			while (arr[high] >= bench) {
				high--;
				if (high == low){
					arr[high] = bench;
					break outer;
				}
			}
			arr[low++] = arr[high];
			if (high == low){
				arr[high] = bench;
				break;
			}
			while (arr[low] <= bench) {
				low++;
				if (high == low){
					arr[high] = bench;
					break outer;
				}
			}
			arr[high--] = arr[low];
		}
		arr[high] = bench;
		quickSort(arr, rawLow, low);
		quickSort(arr, low + 1, rawHigh);
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

	public static void main(String[] args) {
		Question61StraightInCards cards = new Question61StraightInCards();
		int len = 10000000;
		int[] randonArr = new int[len];
		Random random = new Random();
		for (int i = 0; i < randonArr.length; i++) {
			randonArr[i] = random.nextInt(len);
		}
		int[] ints = {15, 30, 6, 7, 17, 5};
		cards.quickSort(randonArr, 0, randonArr.length);
		for (int i = 1; i < randonArr.length; i++) {
			if(randonArr[i] < randonArr[i-1]){
				System.out.println("排序错误");
				break;
			}
		}
		System.out.println("");
	}
}
