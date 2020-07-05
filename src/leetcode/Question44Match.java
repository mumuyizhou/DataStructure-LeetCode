package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouPan
 * @date 2020-07-04
 */
public class Question44Match {
	public boolean isMatch(String s, String p) {
		List<Integer> list=  new ArrayList<>();
		new ArrayList<Integer>(list).add(4);
		int lenS = s.length();
		int lenP = p.length();
		boolean[][] dp = new boolean[lenS + 1][lenP + 1];
		dp[0][0] = true;
		for (int i = 0; i <= lenS; i++) {
			for (int j = 1; j <= lenP; j++) {
				char curPattern = p.charAt(j - 1);
				if (curPattern == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
				} else if (curPattern == '?' || curPattern == s.charAt(i)) {
					dp[i][j] = dp[i - 1][j - 1];
				}
			}
		}
		return dp[lenS][lenP];
	}

	public static void main(String[] args) {
		Question44Match match = new Question44Match();
		System.out.println(match.isMatch("", "*"));
	}
}
