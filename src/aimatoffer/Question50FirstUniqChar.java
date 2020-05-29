package aimatoffer;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 *
 * @author ZhouPan
 * @date 2020-05-29
 */
public class Question50FirstUniqChar {
	public char firstUniqChar(String s) {
		int[] arr = new int[26];
		int len = s.length();
		for (int i = 0; i < len; i++) {
			arr[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < len; i++) {
			if (arr[s.charAt(i) - 'a'] == 1) {
				return s.charAt(i);
			}
		}
		return ' ';
	}
}
