package aimatoffer;

/**
 * @author ZhouPan
 * @date 2020-05-27
 */
public class Question51ReversePairs {
	private int countReversePair = 0;

	public int reversePairs(int[] nums) {
		mergeCount(nums, 0, nums.length);
		return countReversePair;
	}

	public int[] mergeCount(int[] nums, int lowerBound, int upperBound) {
		if (lowerBound == upperBound - 1) {
			return new int[]{nums[lowerBound]};
		} else {
			int mid = (lowerBound + upperBound) / 2;
			int[] left = mergeCount(nums, lowerBound, mid);
			int[] right = mergeCount(nums, mid, upperBound);
			return mergeSortedArrays(left, right);
		}
	}

	public int[] mergeSortedArrays(int[] left, int[] right) {
		int lenLeft = left.length;
		int lenRight = right.length;
		int[] result = new int[lenLeft + lenRight];
		int pLeft = 0;
		int pRight = 0;
		int countSorted = 0;
		while (pLeft < lenLeft && pRight < lenRight) {
			if (left[pLeft] > right[pRight]) {
				countReversePair++;
				result[countSorted] = right[pRight];
				pRight++;
			} else {
				result[countSorted] = left[pLeft];
				pLeft++;
			}
			countSorted++;
		}
		result[countSorted] = pLeft == lenLeft ? right[pRight] : left[pLeft];
		return result;
	}

	public static void main(String[] args) {
		Question51ReversePairs reversePairs = new Question51ReversePairs();
		System.out.println(reversePairs.reversePairs(new int[]{7, 5, 6, 4}));
	}
}
