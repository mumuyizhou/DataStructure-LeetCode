package aimatoffer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * 提示：
 * 0 <= n <= 100
 *
 * @author ZhouPan
 * @date 2020-06-17
 */
public class Question10IFibonacci {
	public int fib(int n) {
		if (n == 0) return 0;
		int len = n + 1;
		int[] dp = new int[len];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < len; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}
		return dp[n];
	}
}
