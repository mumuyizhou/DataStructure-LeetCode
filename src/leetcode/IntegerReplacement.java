package leetcode;

/**
 * @author 木木漪
 */
public class IntegerReplacement {
	public int integerReplacement(int n) {
//		int count = 0;
//		String binaryN = Integer.toBinaryString(n);
//		System.out.println(1>>>1);
//		for (int i = 0; i < binaryN.length(); i++) {
//
//		}
//		return count;
		if (n == 1) {
			return 0;
		} else {
			return n % 2 == 0 ? integerReplacement(n >>> 1) + 1 :
					Integer.min(integerReplacement(((n - 3) >>> 1) + 2), integerReplacement((n - 1) >>> 1)) + 2;
		}

	}

	public static void main(String[] args) {
		IntegerReplacement ir = new IntegerReplacement();
		ir.integerReplacement(65535);
	}
}
