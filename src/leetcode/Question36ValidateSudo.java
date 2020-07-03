package leetcode;

/**
 * @author ZhouPan
 * @date 2020-07-03
 */
public class Question36ValidateSudo {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			int columnStatus = 0, rowStatus = 0, palaceStatus = 0;
			for (int j = 0; j < 9; j++) {
				int curColumn = board[j][i] - '0';
				int curRow = board[i][j] - '0';
				int curPalace = board[3 * (i / 3) + j % 3][3 * (i % 3) + j / 3] - '0';
				if (curColumn > 0 && (columnStatus = isValid(columnStatus, curColumn)) == 0) return false;
				if (curRow > 0 && (rowStatus = isValid(rowStatus, curRow)) == 0) return false;
				if (curPalace > 0 && (palaceStatus = isValid(palaceStatus, curPalace)) == 0) return false;
			}
		}
		return true;
	}

	public int isValid(int status, int val) {
		if (((status >>> (val - 1)) & 1) != 0) return 0;
		status = status ^ (1 << (val - 1));
		return status;
	}
}
