package leetcode;

import java.util.Arrays;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 *
 * @author 木木漪
 */
public class Question10RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		boolean firstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
		if (p.length() >= 2 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
		} else {
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		}
	}

	/**
	 * 动态规划
	 *
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatchUsingDp(String s, String p) {
		int lenS = s.length();
		int lenP = p.length();

		int lenSp = lenS + 1;
		int lenPp = lenP + 1;
		boolean[][] dp = new boolean[lenSp][lenPp];
		dp[0][0] = true;
		if (p == "*") {
			if (s.isEmpty()) {
				return true;
			}
		}
		for (int i = 1; i < lenSp; i++) {
			dp[i][0] = false;
		}
		for (int i = 0; i < lenP; i++) {
			dp[0][i + 1] = p.charAt(i) == '*' && dp[0][i - 1];
		}
		for (int i = 0; i < lenP; i++) {
			for (int j = 0; j < lenS; j++) {
				if (s.charAt(j) == p.charAt(i) || p.charAt(i) == '.') {
					dp[j + 1][i + 1] = dp[j][i];
				} else if (p.charAt(i) == '*') {
					dp[j + 1][i + 1] = (s.charAt(j) == p.charAt(i-1) || p.charAt(i-1) == '.' )
							&& (dp[j + 1][i - 1] || dp[j][i + 1]
							|| dp[j + 1][i]);
				} else {
					dp[j + 1][i + 1] = false;
				}

			}
		}
		Arrays.stream(dp).forEach(a -> System.out.println(Arrays.toString(a)));
		return dp[lenS][lenP];
	}

	public static void main(String[] args) {
		Question10RegularExpressionMatching regular = new Question10RegularExpressionMatching();
		String s = "abcdmmcd";
		String p = "a.*cd*";
		System.out.println(regular.isMatchUsingDp(s, p));
	}
}
