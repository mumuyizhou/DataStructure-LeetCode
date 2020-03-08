package aimatoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @author 木木漪
 */
public class Question57HeWeiSdeLianXuZhengShuXuLie {
	/**
	 * 自己写的，超过65的提交，比较暴力的方法。
	 *
	 * @param target
	 * @return
	 */
	public int[][] findContinuousSequence(int target) {
		List<int[]> output = new ArrayList<>();
		int half = (target / 2) + 1;
		int count = 0;
		for (int i = 1; i < half; i++) {
			int k = i;
			while (count < target) {
				count += k;
				if (count == target) {
					int[] arr = new int[k - i + 1];
					for (int j = i; j <= k; j++) {
						arr[j - i] = j;
					}
					output.add(arr);
					count = 0;
					break;
				} else if (count > target) {
					count = 0;
					break;
				}
				k++;
			}
		}
		return output.toArray(new int[output.size()][]);
	}

	/**
	 * 滑动窗口
	 *
	 * @param target
	 * @return
	 */
	public int[][] findContinuousSequenceSlideWindow(int target) {
		int i = 1;
		int j = 2;
		int sum = 1;
		int half = target / 2;
		List<int[]> out = new ArrayList<>();
		while (i <= half) {
			if (sum == target) {
				int[] arr = new int[j - i];
				for (int k = i; k < j; k++) {
					arr[k - i] = k;
				}
				out.add(arr);
				sum = ++i;
				j = i + 1;
			} else if (sum < target) {
				sum += j++;
			} else {
				sum -= i++;
			}
		}
		return out.toArray(new int[0][]);

	}

	/**
	 * 看到的比叫牛的算法，利用的是数学性质
	 * x + (x + 1) + ... + (x + m - 1) == target => m * x + m * (m - 1) / 2 == target
	 * 根据这个等式，遍历m，找到符合的x即可获得相关序列
	 *
	 * @param target
	 * @return
	 */
	public int[][] findContinuousSequenceSlideWindowMath(int target) {
		int i = 1;
		List<int[]> result = new ArrayList<>();
		int half = target / 2;
		while (i <= half) {
			/*根据上面注释的内容 target = m * x + m * (m - 1) / 2,m为序列个数。也就是这里的i。
			* 比如，找符合要求包含两个连续数字的序列，[7,8],那么这里m=2，m*(m-1)/2=1*/
			target -= i++;
			if (target % i == 0 && target > 0) {
				int[] arr = new int[i];
				int start = target / i;
				for (int j = 0; j < i; j++) {
					arr[j] = start + j;
				}
				result.add(arr);
			}
		}
		Collections.reverse(result);
		return result.toArray(new int[0][]);
	}


	public static void main(String[] args) {
		Question57HeWeiSdeLianXuZhengShuXuLie lie = new Question57HeWeiSdeLianXuZhengShuXuLie();
		Arrays.stream(lie.findContinuousSequenceSlideWindowMath(15)).forEach(x -> System.out.println(Arrays.toString(x)));
	}

}
