package leetcode;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author 木木漪
 */
public class Question32CoinExchange {
	int ans = Integer.MAX_VALUE;

	/**
	 * dfs+剪枝 14ms超过65%
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		subCoins(coins, coins.length - 1, 0, amount);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

	public void subCoins(int[] coins, int lastIndex, int count, int amount) {
		if (lastIndex < 0) {
			return;
		}

		for (int i = amount / coins[lastIndex]; i >= 0; i--) {
			int remain = amount - i * coins[lastIndex];
			int ncount = count + i;
			if (remain == 0) {
				ans = Math.min(ncount, ans);
				break;
			}
			if (ncount > ans) {
				break;
			}
			subCoins(coins, lastIndex - 1, ncount, remain);
		}
		// TODO: 2020/3/9 动态规划方法解！
	}


	public static void main(String[] args) {
		Question32CoinExchange coinExchange = new Question32CoinExchange();
		System.out.println(coinExchange.coinChange(new int[]{1, 2, 5}, 11));
	}
}
