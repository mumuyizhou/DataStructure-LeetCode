package aimatoffer;

/**
 * @author ZhouPan
 * @date 2020-05-30
 */
public class Question12PathExistInMetrics {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0) return false;
		int numOfColumns = board[0].length;
		int numOfRows = board.length;
		boolean[][] isPassed = new boolean[numOfRows][numOfColumns];
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				if (searchPath(board, word, 0, i, j, isPassed)) return true;
			}
		}
		return false;
	}

	public boolean searchPath(char[][] board, String word, int charIndex,
							  int rowIndex, int columnIndex, boolean[][] isPassed) {
		if (word.charAt(charIndex) != board[rowIndex][columnIndex]) return false;
		if (++charIndex >= word.length()) return true;
		isPassed[rowIndex][columnIndex] = true;
		if (rowIndex + 1 < board.length && !isPassed[rowIndex + 1][columnIndex]) {
			if (searchPath(board, word, charIndex, rowIndex + 1, columnIndex, isPassed)) return true;
		}
		if (rowIndex - 1 >= 0 && !isPassed[rowIndex - 1][columnIndex]) {
			if (searchPath(board, word, charIndex, rowIndex - 1, columnIndex, isPassed)) return true;
		}
		if (columnIndex + 1 < board[rowIndex].length && !isPassed[rowIndex][columnIndex + 1]) {
			if (searchPath(board, word, charIndex, rowIndex, columnIndex + 1, isPassed)) return true;
		}
		if (--columnIndex >= 0 && !isPassed[rowIndex][columnIndex]) {
			if (searchPath(board, word, charIndex, rowIndex, columnIndex, isPassed)) return true;
		}
		isPassed[rowIndex][++columnIndex] = false;
		return false;
	}
}
