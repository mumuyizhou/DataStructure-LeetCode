package aimatoffer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
 * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * @author ZhouPan
 * @date 2020-06-10
 */
public class Question14CutRopeII {

	public int cuttingRope(int n) {
		if (n <= 3) return n - 1;
		int remainder = n % 3;
		int num = n / 3;
		switch (remainder) {
			case 1:
				return (int) (solveBigInteger(num - 1) * 4 % 1000000007);
			case 2:
				return (int) (solveBigInteger(num) * 2 % 1000000007);
			default:
				return (int) (solveBigInteger(num) % 1000000007);
		}
	}

	public long solveBigInteger(int n) {
		long result = 1;
		while (n-- > 0) {
			result *= 3;
			result %= 1000000007;
		}
		return result;
	}

	public static void main(String[] args) {
		Question14CutRopeII cutRope = new Question14CutRopeII();
		System.out.println(cutRope.cuttingRope(
				1000));
	}

}
