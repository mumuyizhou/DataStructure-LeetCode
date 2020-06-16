package leetcode;

/**
 * @author ZhouPan
 * @date 2020-06-16
 */
public class Question517SuperLaundry {
	public int findMinMoves(int[] machines) {
		int sum = 0;
		int len = machines.length;
		int finalEach = 0;
		int result = 0;
		for (int i = 0; i < len; i++) {
			sum += machines[i];
		}
		if (sum % len != 0) {
			return -1;
		} else {
			finalEach = sum / len;
		}

		return 0;
	}

	public static void main(String[] args) {
		Question517SuperLaundry superLaundry = new Question517SuperLaundry();
		System.out.println(superLaundry.findMinMoves(new int[]{1, 0, 5}));
	}
}
