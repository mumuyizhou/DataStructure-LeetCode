package leetcode;

/**
 * @author 木木漪
 */
public class MedianOfTwoSortedArrays {
	int[] numsA;
	int[] numsB;

	/**
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length >= nums2.length) {
			this.numsA = nums1;
			this.numsB = nums2;
		} else {
			this.numsA = nums2;
			this.numsB = nums1;
		}
		int lenA = numsA.length;
		int lenB = numsB.length;
		boolean even = (lenA + lenB) % 2 == 0;
		if (lenB == 0) {
			return even ? (numsA[lenA / 2 - 1] + numsA[lenA / 2]) / 2.0 : numsA[lenA / 2];
		}
		int halfLen = (lenA + lenB) / 2;
		int halfLenth = findKthNumber(0, lenA - 1,
				0, lenB - 1, halfLen);
		int halfLenthP = findKthNumber(0, lenA - 1,
				0, lenB - 1, halfLen + 1);
		return even ? (halfLenth + halfLenthP) / 2.0 : halfLenthP;
	}


	/**
	 * @param numsaLowerBound
	 * @param numsaUpperBound
	 * @param numsbLowerBound
	 * @param numsbUpperBound
	 * @param k
	 * @return
	 */
	public int findKthNumber(int numsaLowerBound, int numsaUpperBound,
							 int numsbLowerBound, int numsbUpperBound, int k) {
		if (numsaLowerBound > numsaUpperBound) {
			return numsB[numsbLowerBound + k - 1];
		}
		if (numsbLowerBound > numsbUpperBound) {
			return numsA[numsaLowerBound + k - 1];
		}
		if (k == 1) {
			return Math.min(numsA[numsaLowerBound], numsB[numsbLowerBound]);
		}
		int lenb = numsbUpperBound - numsbLowerBound + 1;
		int formerK = Math.min(k / 2, lenb);
		int remainK = k - formerK;
		if (numsA[numsaLowerBound + formerK - 1] > numsB[numsbLowerBound + formerK - 1]) {
			return findKthNumber(numsaLowerBound, numsaUpperBound,
					numsbLowerBound + formerK, numsbUpperBound, remainK);
		} else if (numsA[numsaLowerBound + formerK - 1] < numsB[numsbLowerBound + formerK - 1]) {
			return findKthNumber(numsaLowerBound + formerK, numsaUpperBound,
					numsbLowerBound, numsbUpperBound, remainK);
		} else {
			return k % 2 == 0 ? numsA[numsaLowerBound + remainK - 1] :
					lenb > (numsaLowerBound + formerK) ?
							Math.min(numsA[numsaLowerBound + remainK - 1], numsB[numsbLowerBound + remainK - 1])
							: numsA[numsaLowerBound + remainK - 1];
		}
	}


	public static void main(String[] args) {
		MedianOfTwoSortedArrays sortedArrays = new MedianOfTwoSortedArrays();
		int[] numsA = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
		int[] numsB = new int[]{0, 6};
		System.out.println(sortedArrays.findMedianSortedArrays(numsA, numsB));
	}
}
