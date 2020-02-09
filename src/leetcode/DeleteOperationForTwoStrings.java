package leetcode;

/**
 * @author 木木漪
 */
public class DeleteOperationForTwoStrings {
	public int minDistance(String word1, String word2) {
		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = new StringBuilder("ab");
		if (sb1.compareTo(sb2) == 0) {

		}
		return 0;
	}

	public static void main(String[] args) {
		DeleteOperationForTwoStrings dofts = new DeleteOperationForTwoStrings();
		dofts.minDistance("abc", "abc");
	}
}
