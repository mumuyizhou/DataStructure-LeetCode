package aimatoffer;

import java.util.Random;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * 限制：
 * 2 <= nums.length <= 10000
 *
 * @author ZhouPan
 * @date 2020-06-19
 */
public class Question56ISingleNumbersInArr {
	/**
	 * 任何数和自己异或得0！
	 *
	 * @param nums
	 * @return
	 */
	public int[] singleNumbers(int[] nums) {
		return null;
	}

	public int[] singleNumbersStupidWay(int[] nums) {
		int[] result = new int[2];
		int len = nums.length;

		fastSort(nums, 0, len);
		int pResult = 0;
		int pNums = 0;
		while (pNums < len) {
			if (pNums == len - 1) {
				result[pResult] = nums[pNums];
				return result;
			}
			if (nums[pNums] == nums[pNums + 1]) {
				pNums += 2;
			} else {
				result[pResult++] = nums[pNums++];
			}
		}
		return result;
	}

	public void fastSort(int[] arr, int start, int end) {
		if (start >= end - 1) return;
		int key = arr[start];
		int pRight = end - 1;
		int pLeft = start;
		for (; ; ) {
			while (arr[pRight] > key) {
				pRight--;
				if (pLeft == pRight) {
					arr[pLeft] = key;
					fastSort(arr, start, pLeft);
					fastSort(arr, pRight + 1, end);
					return;
				}
			}
			arr[pLeft++] = arr[pRight];
			if (pLeft == pRight) {
				arr[pLeft] = key;
				fastSort(arr, start, pLeft);
				fastSort(arr, pRight + 1, end);
				return;
			}
			while (arr[pLeft] < key) {
				pLeft++;
				if (pLeft == pRight) {
					arr[pLeft] = key;
					fastSort(arr, start, pLeft);
					fastSort(arr, pRight + 1, end);
					return;
				}
			}
			arr[pRight--] = arr[pLeft];
			if (pLeft == pRight) {
				arr[pLeft] = key;
				fastSort(arr, start, pLeft);
				fastSort(arr, pRight + 1, end);
				return;
			}
		}
	}


	public static void main(String[] args) {
		Question56ISingleNumbersInArr singleNumbers = new Question56ISingleNumbersInArr();
		int len = 10000000;
		int[] randonArr = new int[len];
		Random random = new Random();
		for (int i = 0; i < randonArr.length; i++) {
			randonArr[i] = random.nextInt(len);
		}
		singleNumbers.fastSort(randonArr, 0, len);
		for (int i = 1; i < randonArr.length; i++) {
			if (randonArr[i] < randonArr[i - 1]) {
				System.out.println("排序错误");
				break;
			}
		}
	}
}
