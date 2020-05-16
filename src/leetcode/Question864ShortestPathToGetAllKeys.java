package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A", "B", ...）代表锁。
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。
 * 如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
 * 假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。
 * 换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 * 示例 1：
 * 输入：["@.a.#","###.#","b.A.B"]
 * 输出：8
 * 示例 2：
 * 输入：["@..aA",
 * "..B#.",
 * "....b"]
 * 输出：6
 *  
 * 提示：
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
 * 钥匙的数目范围是 [1, 6]，每个钥匙都对应一个不同的字母，正好打开一个对应的锁。
 *
 * @author 木木漪
 */
public class Question864ShortestPathToGetAllKeys {
	private int k;

	public int shortestPathAllKeys(String[] grid) {
		int[] startPoint = new int[2];
		k = initGridInfos(grid, startPoint);
		Set<Character> currentKeys = new HashSet<>();
		return stepForward(startPoint[0], startPoint[1], grid, currentKeys);
	}

	public int initGridInfos(String[] grid, int[] startPoint) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			int len = grid[i].length();
			for (int j = 0; j < len; j++) {
				/*a-f的ascii*/
				if (grid[i].charAt(j) < 71 && grid[i].charAt(j) > 64) {
					count++;
				}
				/*64-@*/
				if (grid[i].charAt(j) == 64) {
					startPoint[0] = i;
					startPoint[1] = j;
				}
			}
		}
		return count;
	}

	public int stepForward(int row, int column, String[] grid, Set<Character> currentKeys) {
		char currentChar = grid[row].charAt(column);
		if (currentChar > 64 && currentChar < 71) {
			currentKeys.add(currentChar);
			if (currentKeys.size() == k) {
				return 0;
			}
		}

		int minStep = Integer.MAX_VALUE;
		if (row > 0 && grid[row - 1].charAt(column) != 35) {
			minStep = Math.min(minStep, 1 + stepForward(row - 1, column, grid, currentKeys));
		}
		if (row < grid.length - 1 && grid[row + 1].charAt(column) != 35) {
			minStep = Math.min(minStep, 1 + stepForward(row + 1, column, grid, currentKeys));
		}
		if (column > 0 && grid[row].charAt(column - 1) != 35) {
			minStep = Math.min(minStep, 1 + stepForward(row, column - 1, grid, currentKeys));
		}
		if (column < grid[row].length() - 1 && grid[row].charAt(column + 1) != 35) {
			minStep = Math.min(minStep, 1 + stepForward(row, column + 1, grid, currentKeys));
		}
		return minStep;
	}


	public static void main(String[] args) {
		Question864ShortestPathToGetAllKeys path = new Question864ShortestPathToGetAllKeys();
		System.out.println(path.shortestPathAllKeys(new String[]{"@..aA", "..B#.", "....b"}));
	}
}
