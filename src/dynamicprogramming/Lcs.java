package dynamicprogramming;

import java.util.Arrays;

/**
 * @author 木木漪
 */
public class Lcs {
	public void longestCommonSeries(String a, String b) {
		int lena = a.length();int lenb = b.length();
		int[][] dp = new int[lena+1][lenb+1];
		System.out.println(dp[0][0]);
		for (int i = 0; i < lena; i++) {
			for (int j = 0; j < lenb; j++) {
				dp[i][j] = 0;
			}
		}
		for (int i = 0; i < lena; i++) {
			for (int j = 0; j < lenb; j++) {
				if(a.charAt(i) == b.charAt(j)){
					dp[i+1][j+1] = dp[i][j] +1;
				}else{
					int aDropLast = dp[i][j+1];
					int bDropLast = dp[i+1][j];
					dp[i+1][j+1] = Math.max(aDropLast,bDropLast);
				}
			}
		}

		for (int i = 1; i < dp.length ; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[lena][lenb]);
	}

	public static void main(String[] args) {
		Lcs lcs  = new Lcs();
		lcs.longestCommonSeries("ABCB","BDCA");
	}
}
