package aimatoffer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ZhouPan
 * @date 2020-06-06
 */
public class Temp {
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
		System.out.println(Integer.toBinaryString(121));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
}
