package leetcode;

/**
 * @author 木木漪
 */
public class CheckIfWordIsValidAfterSubstitutions {
	/**
	 * 删除
	 *
	 * @param S
	 * @return
	 */
	public boolean isValid(String S) {
		StringBuilder sb = new StringBuilder(S);
		while (sb.length() >= 6) {
			int startIndex = sb.indexOf("abc");
			if (startIndex < 0) {
				return false;
			} else {
				sb.delete(startIndex, startIndex + 3);
				if (sb.length() < 6) {
					return sb.toString().equals("abc");
				} else {
					continue;
				}
			}
		}
		return sb.toString().equals("abc");
	}

	/**
	 * 增加
	 *
	 * @param S
	 * @return
	 */
	public boolean isValid2(String S) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'a') {
				if (i > sb.length()) {
					return false;
				}
				sb.insert(i, "abc");
			}
		}
		return sb.toString().equals(S);
	}

	/**
	 * 栈方法
	 *
	 * @param S
	 * @return
	 */
	public boolean isValid3(String S) {
		char[] s = S.toCharArray();
		char[] stack = new char[s.length];
		int index = 0;
		for (char cs : s) {
			if (cs != 'c') {
				stack[index++] = cs;
			} else {
				// 当前字符是c,如果前面不是"ab"串,肯定是false
				if (index < 2 || stack[--index] != 'b' || stack[--index] != 'a') {
					return false;
				}
			}
		}
		return index == 0;
	}


	public static void main(String[] args) {
		CheckIfWordIsValidAfterSubstitutions cf = new CheckIfWordIsValidAfterSubstitutions();
		System.out.println(cf.isValid3("abcabcababcc"));
	}
}
