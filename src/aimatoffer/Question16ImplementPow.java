package aimatoffer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^ 2 = 1/(2^2) = 1/4 = 0.25
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * @author ZhouPan
 * @date 2020-06-11
 */
public class Question16ImplementPow {
	public double myPow(double x, int n) {
		if (x == 0) return 0;
		if (n == 0) return 1;
		if (x == 1) return 1;
		if (x == -1) return n % 2 == 0 ? 1 : -1;
		double base = x > 0 ? x : -x;
		long exp = n > 0 ? n : -(long)n;
		long fastInd = 1;
		while (fastInd < exp) {
			base *= exp >= fastInd << 1 ? base : myPow(x > 0 ? x : -x, (int)(exp - fastInd));
			fastInd <<= 1;
			if (fastInd < 0) break;
			if ((n > 0 && base < 0.00001) || (n < 0 && base > 100000)) return 0;
		}
		base = x > 0 || n % 2 == 0 ? base : -base;
		return n > 0 ? base : 1 / base;
	}

	public static void main(String[] args) {
		Question16ImplementPow pow = new Question16ImplementPow();
		System.out.println(pow.myPow(2, -2147483648));

	}
}
