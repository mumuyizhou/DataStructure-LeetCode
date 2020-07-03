package leetcode;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 * 注意:
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 *
 * @author ZhouPan
 * @date 2020-06-07
 */
public class Question494TargetSum {
	/**动态规划 3ms 击败86.66%
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWays(int[] nums, int S) {
		int len = nums.length, sumNums = 0, sum;
		for (int num : nums) {
			sumNums += num;
		}
		if (sumNums < S || (S + sumNums) % 2 != 0) return 0;
		sum = (sumNums + S) >>> 1;
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int j = sum; j > 0; j--) {
				dp[j] = dp[j] + (j - num >= 0 ? dp[j - num] : 0);
			}
		}
		return dp[sum];
	}

	/**深度优先搜索 364ms 击败44.58%
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWaysDFS(int[] nums, int S) {
		return traversal(nums, 0, S);
	}

	public int traversal(int[] nums, int i, int S) {
		if (i == nums.length - 1) {
			int count = 0;
			count += S==nums[i]?1:0;
			count += S==-nums[i]?1:0;
			return  count;
		}
		return traversal(nums, i + 1, S - nums[i]) + traversal(nums, i + 1, S + nums[i]);
	}


	public static void main(String[] args) {
		Question494TargetSum targetSum = new Question494TargetSum();
//		System.out.println(targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
		System.out.println(targetSum.findTargetSumWaysDFS(new int[]{1, 1, 1, 1, 1}, 3));
	}
}
