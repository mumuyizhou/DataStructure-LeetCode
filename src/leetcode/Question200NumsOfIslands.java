package leetcode;

import java.util.ArrayList;

/**
 * @author ZhouPan
 * @date 2020-07-19
 */
public class Question200NumsOfIslands {
	private int[][][] fatherArr;

	public int numIslands(char[][] grid) {
		int rows = grid.length;
		if (rows == 0) return 0;
		int columns = grid[0].length;
		fatherArr = new int[rows][columns][2];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				fatherArr[i][j] = new int[]{i, j};
			}
		}
		for (int i = 1; i < rows; i++) {
			if (grid[i][0] == '1' && grid[i - 1][0] == '1') {
				union(new int[]{i - 1, 0}, new int[]{i, 0});
			}
		}
		for (int i = 1; i < columns; i++) {
			if (grid[0][i] == '1' && grid[0][i - 1] == '1') {
				union(new int[]{0, i - 1}, new int[]{0, i});
			}
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (grid[i][j] == '1' && grid[i][j - 1] == '1' && grid[i - 1][j] == '1') {
					union(new int[]{i - 1, j}, new int[]{i, j});
					union(new int[]{i - 1, j}, new int[]{i, j - 1});
				} else if (grid[i][j] == '1' && grid[i - 1][j] == '1') {
					union(new int[]{i - 1, j}, new int[]{i, j});
				} else if (grid[i][j] == '1' && grid[i][j - 1] == '1') {
					union(new int[]{i, j - 1}, new int[]{i, j});
				}
			}
		}
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == '1') list.add(fatherArr[i][j]);
			}
		}
		list.sort((o1, o2) -> {
			if (o1[0] != o2[0] && o1[1] != o2[1]) {
				return o1[1] - o2[1] + o1[0] - o2[0];
			}
			return 0;
		});
		int[] prev = new int[]{-1, -1};
		int size = 0;
		for (int[] cur : list) {
			if (cur[0] != prev[0] || cur[1] != prev[1]) {
				size++;
				prev = cur;
			}
		}
		return size;
	}

	public int[] find(int[] pos) {
		int[] father = fatherArr[pos[0]][pos[1]];
		if (!(fatherArr[father[0]][father[1]][0] == father[0] && father[1] == fatherArr[father[0]][father[1]][1])) {
			father = find(father);
		}
		fatherArr[pos[0]][pos[1]] = father;
		return father;
	}

	public void union(int[] prev, int[] cur) {
		int[] pFather = find(prev);
		int[] cFather = find(cur);
		fatherArr[cFather[0]][cFather[1]] = pFather;
		find(cur);
	}

	public static void main(String[] args) {
		Question200NumsOfIslands iss = new Question200NumsOfIslands();
		System.out.println(iss.numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}}));
	}
}
