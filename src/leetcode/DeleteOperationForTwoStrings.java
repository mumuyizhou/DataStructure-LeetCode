package leetcode;

/**
 * @author 木木漪
 */
public class DeleteOperationForTwoStrings {
	public int minDistance(String word1, String word2) {
		int lenW1 = word1.length();int lenW2 = word2.length();
		if(lenW1 == 0 || lenW2 == 0)
			return lenW1 + lenW2;

		if(word1.equals(word2))
			return 0;
		int[][] dp = new int[lenW1+1][lenW2+1];
		for(int i=0;i<lenW1;i++){
			for(int j=0;j<lenW2;j++){
				if(word1.charAt(i)==word2.charAt(j)){
					dp[i+1][j+1]=dp[i][j] +1;
				}else{
					dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
				}
			}
		}
		return lenW1+lenW2-2*dp[lenW1][lenW2];
	}

	public static void main(String[] args) {
		DeleteOperationForTwoStrings dofts = new DeleteOperationForTwoStrings();
		dofts.minDistance("abc", "abc");
	}
}
