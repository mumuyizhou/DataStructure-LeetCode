package leetcode;

import java.util.Arrays;

/**
 * @author ZhouPan
 * @date 2020-07-02
 */
public class Question34FirstPosAndLastPos {
	private  final int[] IND_ARR = new int[]{-1, -1};

	public int[] searchRange(int[] nums, int target) {
		if (nums.length != 0) {
			binSearch(nums, 0, nums.length - 1, target);
		}
		return IND_ARR;
	}

	public void binSearch(int[] nums, int left, int right, int target) {
		if (left < 0 || right == nums.length || left > right) return;
		if (left == right) {
			if (nums[right] == target) {
				if (right == nums.length - 1 || nums[right + 1] != nums[right]) {
					IND_ARR[1] = right;
				}
				if (left == 0 || nums[left - 1] != nums[left]) {
					IND_ARR[0] = left;
				}
			}
			return;
		}
		int mid = (left + right) >>> 1;
		if (nums[mid] > target) {
			if (nums[left] > target) return;
			binSearch(nums, left, mid, target);
		} else if (nums[mid] < target) {
			if (nums[right] < target) return;
			binSearch(nums, mid + 1, right, target);
		} else {
			if (mid == 0) {
				IND_ARR[0] = mid;
			}
			if (mid != nums.length - 1 && nums[mid + 1] == nums[mid]) {
				binSearch(nums, mid + 1, right, target);
			} else {
				IND_ARR[1] = mid;
			}

			if (mid == nums.length - 1) {
				IND_ARR[1] = mid;
			}
			if (mid != 0 && nums[mid - 1] == nums[mid]) {
				binSearch(nums, left, mid - 1, target);
			} else {
				IND_ARR[0] = mid;
			}
		}
	}

	public static void main(String[] args) {
		Question34FirstPosAndLastPos firstPosAndLastPos = new Question34FirstPosAndLastPos();
		System.out.println(Arrays.toString(firstPosAndLastPos.searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3)));
	}
}
