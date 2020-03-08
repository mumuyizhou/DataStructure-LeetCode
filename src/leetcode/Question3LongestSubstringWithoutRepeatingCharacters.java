package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author 木木漪
 */
public class Question3LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		Set<Character> set = new HashSet<>();
		int longest = 0;
		int count = 0;
		int i = 0;
		while (i < len) {
			a:
			for (int j = i; j < len; j++) {
				if (set.contains(s.charAt(j))) {
					longest = Math.max(count, longest);
					for (int m = i; m <= j; m++) {
						if (s.charAt(m) == s.charAt(j)) {
							count = m - i + 1;
							i = m + 1;
							break a;
						} else {
							set.remove(s.charAt(m));
						}
					}
				} else {
					count++;
					set.add(s.charAt(j));
				}
			}
		}
		return Math.max(count, longest);
	}

	public static void main(String[] args) {
		Question3LongestSubstringWithoutRepeatingCharacters characters = new
				Question3LongestSubstringWithoutRepeatingCharacters();
		System.out.println(characters.lengthOfLongestSubstring("pwwkewkjhvsgiugdasifg"));
		List<List<Integer>> a = new ArrayList<>();
		a.stream().map(x -> x.toArray()).toArray();
	}
}
