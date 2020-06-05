package aimatoffer;

import java.beans.beancontext.BeanContext;

/**
 * @author ZhouPan
 * @date 2020-06-05
 */
public class Question4SearchInTwoDimensionArr {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int length = matrix[0].length;
		int height = matrix.length;
		int start = 0;
		int end = length - 1;
		int p = 0;
		while (p <= height - 1 - p) {
			for (int j = end; j >= 0; j--) {
				if (matrix[p][j] == target) return true;
				if (matrix[p][j] > target) end--;
			}
			for (int j = start; j <= end; j++) {
				if (matrix[height - 1 - p][j] == target) return true;
				if (matrix[height - 1 - p][j] < target) start++;
			}
			p++;
		}
		return false;
	}


	public static void main(String[] args) {
		Question4SearchInTwoDimensionArr search = new Question4SearchInTwoDimensionArr();
		System.out.println(search.findNumberIn2DArray(
				new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
						{3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
//		System.out.println(search.findNumberIn2DArray(null, 6));
		System.out.println(search.findNumberIn2DArray(new int[][]{{5}, {6}}, 6));
	}
}
