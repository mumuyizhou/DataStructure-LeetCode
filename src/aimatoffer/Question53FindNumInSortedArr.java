package aimatoffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 限制：
 * 0 <= 数组长度 <= 50000
 *  注意：本题与主站 34 题相同（仅返回值不同）：
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author ZhouPan
 * @date 2020-06-12
 */
public class Question53FindNumInSortedArr {
	public int search(int[] nums, int target) {
		int len = nums.length;
		int start = searchStart(nums, target, 0, len);
		int end = searchEnd(nums, target, 0, len);
		if (start == -1 || end == -1) return 0;
		return end - start + 1;
	}

	public int searchStart(int[] nums, int target, int start, int end) {
		if (start == end - 1) return nums[start] == target ? start : -1;
		if (nums[start] == target) return start;
		if (nums[start] > target || nums[end - 1] < target) return -1;
		int mid = (start + end) >>> 1;
		int left = searchStart(nums, target, start, mid);
		int right = searchStart(nums, target, mid, end);
		if (left == -1) return right;
		if (right == -1) return left;
		return Math.min(left, right);
	}

	public int searchEnd(int[] nums, int target, int start, int end) {
		int endP = end - 1;
		if (start == endP) return nums[endP] == target ? endP : -1;
		if (nums[endP] == target) return endP;
		if (nums[endP] < target || nums[start] > target) return -1;
		int mid = (start + end) >>> 1;
		int left = searchEnd(nums, target, start, mid);
		int right = searchEnd(nums, target, mid, end);
		if (left == -1) return right;
		if (right == -1) return left;
		return Math.max(left, right);
	}


	public static void main(String[] args) {
		Question53FindNumInSortedArr arr = new Question53FindNumInSortedArr();
//		System.out.println(arr.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
		int[] arr50000 = new int[50000];
		for (int i = 0; i < arr50000.length; i++) {
			arr50000[i] = i;
		}
		long current = System.nanoTime();
		System.out.println(arr.search(arr50000, 25000));
		System.out.println(System.nanoTime() - current);
		current = System.nanoTime();
		System.out.println(arr.search(arr50000, 60000));
		System.out.println(System.nanoTime() - current);
	}

}
