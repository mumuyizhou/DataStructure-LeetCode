package aimatoffer;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 *
 * @author 木木漪
 */
public class Question47LiWuDeZuiDaJiaZhi {

	/**
	 * 动态规划解 别的没什么好说的
	 *
	 * @param grid
	 * @return
	 */
	public int maxValue(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = grid[m - 1][n - 1];
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i + 1];
		}
		if (m == 1 || n == 1) return dp[0][0];

		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {
				dp[j][i] = grid[j][i] + Math.max(dp[j + 1][i], dp[j][i + 1]);
			}
		}
		return dp[0][0];
	}
}
