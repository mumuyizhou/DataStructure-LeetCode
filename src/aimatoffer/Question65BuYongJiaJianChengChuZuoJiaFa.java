package aimatoffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *  
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * @author 木木漪
 */
public class Question65BuYongJiaJianChengChuZuoJiaFa {
	public int add(int a, int b) {
		StringBuilder strA = new StringBuilder(Integer.toBinaryString(a));
		StringBuilder strB = new StringBuilder(Integer.toBinaryString(b));
		int pA = strA.length();
		int pB = strB.length();
		for (int i = pA; i < 32; i++) {
			strA.insert(0, "0");
		}
		for (int i = pB; i < 32; i++) {
			strB.insert(0, "0");
		}
		int carry = 0;
		StringBuilder s = new StringBuilder(32);
		for (int i = 31; i >= 0; i--) {
			s.append((strA.charAt(i) ^ strB.charAt(i)) ^ carry);
			int inA = Integer.parseInt(String.valueOf(strA.charAt(i)));
			int inB = Integer.parseInt(String.valueOf(strB.charAt(i)));
			carry = (inA & inB) | (inA & carry) | (inB & carry);
		}
		return (int) Long.parseLong(s.reverse().toString(), 2);
	}

	public int addSimplyfied(int a, int b) {
		int carry;
		while (b != 0) {
			carry = a ^ b;
			b = ((a & b) << 1);
			a = carry;

		}
		return a;
	}

	public static void main(String[] args) {
		Question65BuYongJiaJianChengChuZuoJiaFa add = new Question65BuYongJiaJianChengChuZuoJiaFa();
		System.out.println(add.add(-2, -1));
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(add.addSimplyfied(7, 1));

	}
}
