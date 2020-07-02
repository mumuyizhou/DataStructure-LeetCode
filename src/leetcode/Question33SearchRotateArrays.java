package leetcode;

/**
 * @author ZhouPan
 * @date 2020-07-02
 */
public class Question33SearchRotateArrays {
	public int search(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) return -1;
		return biSearch(nums, 0, len - 1, target);
	}

	public int biSearch(int[] nums, int left, int right, int target) {
		if (left == right) return nums[left] == target ? left : -1;
		int mid = (left + right) >>> 1;
		int result = -1;
		if ((nums[left] <= nums[mid] && target >= nums[left] && target <= nums[mid]) ||
				(nums[left] >= nums[mid] && (target >= nums[left] || target <= nums[mid]))) {
			if (target == nums[left] || target == nums[mid]) {
				return nums[left] == target ? left : mid;
			}
			result = Math.max(result, biSearch(nums, left, mid, target));

		}
		int midNext = mid + 1;
		if ((nums[midNext] <= nums[right] && target >= nums[midNext] && target <= nums[right]) ||
				nums[midNext] >= nums[right] && (target >= nums[midNext] || target <= nums[right])) {
			if (target == nums[midNext] || target == nums[right]) {
				return target == nums[midNext] ? midNext : right;
			}
			result = Math.max(result, biSearch(nums, midNext, right, target));

		}
		return result;
	}

	public static void main(String[] args) {
		Question33SearchRotateArrays rotateArrays = new Question33SearchRotateArrays();
		System.out.println(rotateArrays.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
	}
}
