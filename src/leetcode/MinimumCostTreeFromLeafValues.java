package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 木木漪
 */
public class MinimumCostTreeFromLeafValues {
	/**
	 * 动态规划
	 *
	 * @param arr
	 * @return
	 */
	public int mctFromLeafValues(int[] arr) {
		int length = arr.length;
		int[][] dp = new int[length][length];
		int[][] maxLeaf = new int[length][length];

		for (int i = length - 1; i >= 0; i--) {
			for (int j = 0; j < length; j++)
				if (i == j) {
					dp[i][j] = 0;
				} else if (j - i == 1) {
					dp[i][j] = arr[i] * arr[j];
				} else if (j - i >= 2) {
					int min = Integer.MAX_VALUE;
					for (int k = 1; k <= j - i; k++) {
						if (maxLeaf[i][i + k - 1] == 0) {
							int[] leftArr = Arrays.copyOfRange(arr, i, i + k);
							maxLeaf[i][i + k - 1] = Arrays.stream(leftArr).max().getAsInt();
						}
						if (maxLeaf[i + k][j] == 0) {
							int[] rightArr = Arrays.copyOfRange(arr, i + k, j + 1);
							maxLeaf[i + k][j] = Arrays.stream(rightArr).max().getAsInt();
						}
						int result = maxLeaf[i][i + k - 1] * maxLeaf[i + k][j] + dp[i][i + k - 1] + dp[i + k][j];
						if (result < min) {
							min = result;
						}
					}
					dp[i][j] = min;
				}
		}
		return dp[0][length - 1];
	}

	/**
	 * 单调递减栈
	 *
	 * @param arr
	 * @return
	 */
	public int mctFromLeafValuesUsingStack(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(Integer.MAX_VALUE);
		int res = 0;
		for (int leaf : arr) {
			while (leaf > stack.peek()) {
				int mid = stack.pop();
				res += mid * Math.min(stack.peek(), leaf);
			}
			stack.push(leaf);
		}
		while (stack.size() > 2) {
			res += stack.pop() * stack.peek();
		}
		return res;
	}

	public static void main(String[] args) {
		MinimumCostTreeFromLeafValues cost = new MinimumCostTreeFromLeafValues();
		long start = System.currentTimeMillis();
//		System.out.println(cost.mctFromLeafValues(new int[]{10, 2, 15, 9, 1, 3, 8, 5, 13, 6, 11, 3, 8, 6, 5, 13, 13, 7}));
		System.out.println(cost.mctFromLeafValuesUsingStack(
				new int[]{10, 2, 15, 9, 1, 3, 8, 5, 13, 6, 11, 3, 8, 6, 5, 13, 13, 7}));
		System.out.println(System.currentTimeMillis() - start);
		int[][][] te = new int[2][2][2];
	}
}
