package leetcode;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 * @author 木木漪
 */
public class Question674LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		int lenOfNums = nums.length;
		if(lenOfNums == 0){
			return 0;
		}
		int longestLength = 1;
		int currentLength = 1;
		for(int i = 1; i < lenOfNums ; i++){
			if(nums[i] > nums[i - 1]){
				currentLength++;
			}else{
				longestLength = Math.max(currentLength, longestLength);
				currentLength = 1;
			}
		}
		longestLength = Math.max(currentLength, longestLength);
		return longestLength;
	}

	public static void main(String[] args) {

	}
}
