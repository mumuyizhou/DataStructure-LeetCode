package aimatoffer;

/**
 * @author ZhouPan
 * @date 2020-06-04
 */
public class Question67TransformStrToInt {
	public int strToInt(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char cur = str.charAt(i);
			if (cur == ' ') continue;
			if (cur == '+' || cur == '-') {
				int intStart = i + 1;
				for (int j = intStart; j < len; j++) {
					int curOffsetZero = str.charAt(j) - '0';
					if (curOffsetZero >= 0 && curOffsetZero <= 9) continue;
					if (j == intStart) return 0;
					return parseInt(cur == '+' ? 0 : 1, str.substring(intStart, j));
				}
				return parseInt(cur == '+' ? 0 : 1, str.substring(intStart, len));
			}
			int offsetZero = cur - '0';
			if (offsetZero >= 0 && offsetZero <= 9) {
				for (int j = i; j < len; j++) {
					int curOffsetZero = str.charAt(j) - '0';
					if (curOffsetZero >= 0 && curOffsetZero <= 9) continue;
					return parseInt(0, str.substring(i, j));
				}
				return parseInt(0, str.substring(i, len));
			}
			return 0;
		}
		return 0;
	}

	public int parseInt(int sign, String str) {
		int len = str.length();
		int p = 0;
		int max = 2147483647;
		int min = -2147483648;
		for (int i = 0; i < len; i++) {
			int cur = str.charAt(i) - '0';
			if (sign == 0 && (p > 214748364 || (p == 214748364 && cur > 7))) return max;
			if (sign == 1 && (p > 214748364 || (p == 214748364 && cur > 8))) return min;
			p = p * 10 + str.charAt(i) - '0';
		}
		return sign == 1 ? -p : p;
	}


	public static void main(String[] args) {
		Question67TransformStrToInt strToInt = new Question67TransformStrToInt();
		System.out.println("++42:" + strToInt.strToInt("++42"));
		System.out.println("9999999999999999999999999999999999999999999999999999999:" + strToInt.strToInt("9999999999999999999999999999999999999999999999999999999"));
		System.out.println(" 42 :" + strToInt.strToInt(" 42 "));
		System.out.println(" -1241241231276537612538ii " + strToInt.strToInt(" -1241241231276537612538ii "));
		System.out.println("-42:" + strToInt.strToInt("-42"));
	}
}
