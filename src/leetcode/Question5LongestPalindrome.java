package leetcode;

import java.util.ArrayList;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author ZhouPan
 * @date 2020-06-19
 */
public class Question5LongestPalindrome {
	public String longestPalindrome(String s) {
		if (s.equals("") || s.length() == 1) return s;
		int len = s.length();
		String longest = s.substring(0, 1);
		for (int i = 0; i < len; i++) {
			int offset = 1;
			while (offset + i < len && i - offset >= 0 && s.charAt(offset + i) == s.charAt(i - offset)) {
				offset++;
			}

			String tmp = s.substring(i - offset + 1, i + offset);
			if (tmp.length() > longest.length()) longest = tmp;
			if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
				int left = i, right = i + 1;
				while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
					left--;
					right++;
				}
				tmp = s.substring(left + 1, right);
				if (tmp.length() > longest.length()) longest = tmp;
			}
		}
		return longest;
	}

	public String longestPalindromeDp(String s) {
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		int maxLen = 0;
		int startPos = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (i - j > 1) {
						dp[j][i] = dp[j + 1][i - 1];
					} else {
						dp[j][i] = true;
					}
				} else {
					dp[j][i] = false;
				}
				if (dp[j][i] && i - j + 1 > maxLen) {
					maxLen = i - j + 1;
					startPos = j;
				}
			}

		}
		return s.substring(startPos, maxLen + startPos);
	}

	public static void main(String[] args) {
		Question5LongestPalindrome palindrome = new Question5LongestPalindrome();
		System.out.println(palindrome.longestPalindromeDp("asdhkjhhasd"));
	}
}
