package leetcode;

/**
 * @author ZhouPan
 * @date 2020-07-04
 */
public class Question42TrapRain {
	public int trap(int[] height) {
		int fast = 1;
		int slow = 0;
		int len = height.length;
		int rainCnt = 0;
		while (fast < len) {
			if (height[fast] < height[slow]) {
				fast++;
			} else {
				rainCnt += height[slow] * (fast - slow - 1);
				while (slow  < fast) {
					rainCnt -= height[slow];
				}
			}
		}
		int max = slow;
		slow = len - 1;
		fast = len - 2;
		while (fast >= max) {
			if (height[fast] < height[slow]) {
				fast--;
			} else {
				rainCnt += height[slow] * (slow - fast - 1);
				while (--slow < fast) {
					rainCnt -= height[slow];
				}
			}
		}
		return rainCnt;
	}

	public static void main(String[] args) {
		Question42TrapRain trapRain = new Question42TrapRain();
		System.out.println(trapRain.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
	}
}
