package aimatoffer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 * @author ZhouPan
 * @date 2020-06-04
 */
public class Question20StringReprentsNum {
	public boolean isNumber(String s) {
		s = s.trim();
		int countOperator = 0, countDot = 0, len = s.length(),countE =0;
		if(len==0) return false;
		for (int i = 0; i < len; i++) {
			char cur = s.charAt(i);
			if (cur == '-' || cur == '+') {
				if (i > 0 || ++countOperator > 1 || i == len - 1 || countOperator+countDot==len) return false;
				continue;
			}
			if (cur == '.') {
				if (++countDot > 1 || len == 1 || countOperator+countDot==len) return false;
				continue;
			}
			if (cur == 'e') {
				if(i >=1){
					if(s.charAt(i-1)=='+' || s.charAt(i-1)=='-') return false;
				}
				if(i >= 2 && s.charAt(i-1)=='.'){
					if(s.charAt(i-2)=='+' || s.charAt(i-2)=='-') return false;
				}
				if(++countE > 1) return false;
				if (s.substring(i + 1, len).contains(".") || i == len - 1 || i==0) return false;
				if(i==1 && s.charAt(i-1)=='.')return false;
				char next = s.charAt(i + 1);
				if(next == '-'||next=='+') {
					i++;
					if(i>=len-1){
						return false;
					}
				}
				continue;
			}
			if (cur - '0' < 0 || cur - '0' > 9) return false;
		}
		return true;
	}


	public static void main(String[] args) {
		Question20StringReprentsNum bool = new Question20StringReprentsNum();
		System.out.println("should be true:");
		System.out.println(bool.isNumber("1 "));
		System.out.println(bool.isNumber("6.e10"));
		System.out.println(bool.isNumber("+100"));
		System.out.println(bool.isNumber("5e2"));
		System.out.println(bool.isNumber("-123"));
		System.out.println(bool.isNumber("3.1416"));
		System.out.println(bool.isNumber("0123"));
		System.out.println(bool.isNumber("12."));
		System.out.println(bool.isNumber("   1 "));
		System.out.println(bool.isNumber("-.6"));



		System.out.println("shoule be false:");
		System.out.println(bool.isNumber("e"));
		System.out.println(bool.isNumber("12e"));
		System.out.println(bool.isNumber("1a3.14"));
		System.out.println(bool.isNumber("1.2.3"));
		System.out.println(bool.isNumber("+-5"));
		System.out.println(bool.isNumber("-1E-16"));
		System.out.println(bool.isNumber("12e+5.4"));
		System.out.println(bool.isNumber(".e10"));
		System.out.println(bool.isNumber("."));
		System.out.println(bool.isNumber("3.5e+"));
		System.out.println(bool.isNumber(" -."));
		System.out.println(bool.isNumber("6ee66"));
		System.out.println(bool.isNumber("-.e5"));
		System.out.println(bool.isNumber("-e5"));



		//字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
		// 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
	}
}
