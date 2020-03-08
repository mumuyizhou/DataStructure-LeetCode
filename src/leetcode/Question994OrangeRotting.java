package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * 示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 * 提示：
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * @author 木木漪
 */
public class Question994OrangeRotting {
	public int orangesRotting(int[][] grid) {
		int rotMinutes = 0;
		int rows = grid.length;
		int columns = grid[0].length;
		boolean rottedOranges = false;
		List<int[]> rotList = new ArrayList<>();
		boolean hasFresh;
		while (true) {
			hasFresh = false;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if (grid[i][j] == 2) {
						rotList.add(new int[]{i, j});
					} else if (grid[i][j] == 1) {
						if (checkIfKeepFresh(grid, i, j)) {
							return -1;
						}
						hasFresh = true;
					}
				}
			}

			if (hasFresh) {
				for (int[] pos : rotList) {
					rottedOranges = rotNearOranges(grid, pos[0], pos[1]) || rottedOranges;
				}
				if (rottedOranges) {
					rotList.clear();
					rotMinutes++;
					rottedOranges = false;
				} else {
					return -1;
				}
			} else {
				break;
			}
		}
		return rotMinutes;
	}

	public boolean rotNearOranges(int[][] grid, int row, int column) {
		int rows = grid.length;
		int columns = grid[0].length;
		boolean rottedOranges = false;
		if (row - 1 >= 0 && grid[row - 1][column] == 1) {
			grid[row - 1][column] = grid[row - 1][column] << 1;
			rottedOranges = true;
		}
		if (row + 1 < rows && grid[row + 1][column] == 1) {
			grid[row + 1][column] = grid[row + 1][column] << 1;
			rottedOranges = true;
		}
		if (column + 1 < columns && grid[row][column + 1] == 1) {
			grid[row][column + 1] = grid[row][column + 1] << 1;
			rottedOranges = true;
		}
		if (column - 1 >= 0 && grid[row][column - 1] == 1) {
			grid[row][column - 1] = grid[row][column - 1] << 1;
			rottedOranges = true;
		}
		return rottedOranges;
	}

	public boolean checkIfKeepFresh(int[][] grid, int row, int column) {
		int rows = grid.length;
		int columns = grid[0].length;
		return (row + 1 >= rows || grid[row + 1][column] == 0) && (row - 1 < 0 || grid[row - 1][column] == 0)
				&& (column + 1 >= columns || grid[row][column + 1] == 0)
				&& (column - 1 < 0 || grid[row][column - 1] == 0);
	}

	public static void main(String[] args) {
		Question994OrangeRotting rotting = new Question994OrangeRotting();
		System.out.println(rotting.orangesRotting(new int[][]{{1, 1}}));
	}
}
