package leetcode;

import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @author ZhouPan
 * @date 2020-06-07
 */
public class Question416PartitionSubset {
	/** dp解 13ms
	 * @param nums
	 * @return
	 */
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if ((sum & 1) == 1) return false;
		sum >>>= 1;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int num : nums) {
			if (num > sum) return false;
			for (int j = dp.length - 1; j >= num; j--) {
				dp[j] = dp[j] || dp[j - num];
			}
			if (dp[sum]) return true;
		}
		return false;
	}

	/** dfs解  1ms
	 * @param nums
	 * @return
	 */
	public boolean canPartitionDfs(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if ((sum & 1) == 1) return false;
		sum >>>= 1;
		Arrays.sort(nums);
		return dfsHelper(nums, nums.length - 1, sum);
	}

	public boolean dfsHelper(int[] nums, int i, int target) {
		if (nums[i] == target) return true;
		if (i == 0) return false;
		if (nums[i] > target) return false;
		return dfsHelper(nums, i - 1, target - nums[i]) || dfsHelper(nums, i - 1, target);
	}

	public static void main(String[] args) {
		Question416PartitionSubset partitionSubset = new Question416PartitionSubset();
		System.out.println("dp:");
		System.out.println(partitionSubset.canPartition(new int[]{1, 5, 11, 5}));
		System.out.println(partitionSubset.canPartition(new int[]{1, 2, 5}));
		System.out.println(partitionSubset.canPartition(new int[]{1, 2, 3, 5}));
		System.out.println(partitionSubset.canPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
				1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
				,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
		System.out.println("dfs:");
		System.out.println(partitionSubset.canPartitionDfs(new int[]{1, 5, 11, 5}));
		System.out.println(partitionSubset.canPartitionDfs(new int[]{1, 2, 5}));
		System.out.println(partitionSubset.canPartitionDfs(new int[]{1, 2, 3, 5}));
		System.out.println(partitionSubset.canPartitionDfs(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
				1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
				,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
	}

}
