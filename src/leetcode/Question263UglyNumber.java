package leetcode;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 *
 * @author 木木漪
 */
public class Question263UglyNumber {
	public boolean isUgly(int num) {
		switch (num) {
			case 0:
				return false;
			case 1:
			case 2:
			case 3:
			case 5:
				return true;
			default:
				return num % 2 == 0 ? isUgly(num / 2) :
						num % 3 == 0 ? isUgly(num / 3) :
								num % 5 == 0 && isUgly(num / 5);
		}
	}

	public static void main(String[] args) {
		Question263UglyNumber uglyNumber = new Question263UglyNumber();
		System.out.println(uglyNumber.isUgly(6));
	}
}
