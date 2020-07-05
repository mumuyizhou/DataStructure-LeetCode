package leetcode;

/**
 * @author ZhouPan
 * @date 2020-07-05
 */
public class Question50Pow {
	public double myPow(double x, int n) {
		if (n == 0) return 1;
		if (x == 0) return 0;
		boolean nPositive = n > 0;
		long ln = (long) (Math.abs((long) n));
		long remain = ln;
		double result = 1;
		while (remain != 0) {
			long m = 1;
			double k = x;
			while (remain >= m) {
				result *= k;
				remain -= m;
				k = k * k;
				m <<= 1;
			}
		}
		return nPositive ? result : 1 / result;
	}

	public static void main(String[] args) {
		Question50Pow pow = new Question50Pow();
		System.out.println(pow.myPow(1, Integer.MIN_VALUE));
		System.out.println(Integer.MIN_VALUE);
	}
}
