package aimatoffer;

import java.util.Arrays;

/**
 * @author 木木漪
 */
public class Question60NTouZiSum {
	/*把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
	* 例子：输入: 2
	输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]*/
	public double[] twoSum(int n) {
		int numOfs = n * 5 + 1;
		int rowOfdp = n + 1;
		double[][] dp = new double[rowOfdp][6 * n + 1];
		dp[0][0] = 1.0;
		for (int i = 0; i < rowOfdp; i++) {
			dp[i][0] = 0.0;
		}
		for (int i = 1; i < numOfs + 1; i++) {
			dp[0][i] = 0.0;
		}
		for (int i = 1; i <= 6; i++) {
			dp[1][i] = 1.0 / 6.0;
		}

		for (int i = 2; i < rowOfdp; i++) {
			for (int j = 1; j < 6 * n + 1; j++) {
				if (j >= i) {
					for (int k = 1; k <= 6; k++) {
						dp[i][j] += j - k >= 0 ? dp[i - 1][j - k] : 0;
					}
					dp[i][j] /= 6.0;
				} else {
					dp[i][j] = 0.0;
				}
			}

		}
		return Arrays.copyOfRange(dp[n], n, 6 * n + 1);
	}

	public static void main(String[] args) {
		Question60NTouZiSum nTouZiSum = new Question60NTouZiSum();
		System.out.println(Arrays.toString(nTouZiSum.twoSum(2)));

	}
}
