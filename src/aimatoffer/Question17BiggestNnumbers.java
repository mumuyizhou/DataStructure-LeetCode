package aimatoffer;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * @author ZhouPan
 * @date 2020-06-05
 */
public class Question17BiggestNnumbers {
	public int[] printNumbers(int n) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			s = s * 10 + 9;
		}
		int[] result = new int[s];
		for (int i = 0; i < s; i++) {
			result[i] = i + 1;
		}
		return result;
	}

	public static void main(String[] args) {
		Question17BiggestNnumbers nnumbers = new Question17BiggestNnumbers();
		System.out.println(Arrays.toString(nnumbers.printNumbers(100)));
	}
}
