package leetcode;

import java.util.*;

/**
 * @author ZhouPan
 * @date 2019-12-03
 **/
public class MaxSlidingWindow {
	int[] nums;
	int k;

	public static void main(String[] args) {
		int[] data = {1,3,1,2,0,5};
		MaxSlidingWindow max = new MaxSlidingWindow();
		System.out.println(Arrays.toString(max.maxSlidingWindow(data, 3)));
		System.out.println(Arrays.toString(max.maxSlideWindowOpt(data, 3)));
	}


	/**
	 * 每次要对窗口内所有值取最大值
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 1) {
			return nums;
		}
		Deque<Integer> deque = new ArrayDeque<>(k);
		for (int i = 0; i < k; i++) {
			deque.push(nums[i]);
		}
		List<Integer> output = new ArrayList<>();
		int size = nums.length;
		output.add(Collections.max(deque));
		for (int i = k; i < size; i++) {
			deque.push(nums[i]);
			deque.removeLast();
			output.add(Collections.max(deque));
		}
		return output.stream().mapToInt(Integer::valueOf).toArray();
	}

	public int[] maxSlideWindowOpt(int[] nums, int k) {
		this.nums = nums;
		this.k = k;
		int len = nums.length;
		if (k == 1 || len == 0) {
			return nums;
		}
		int[] output = new int[len - k + 1];
		Deque<Integer> window = new ArrayDeque<>();
		output[0] = nums[0];
		for (int i = 0; i < k; i++) {
			cleanWindow(window,i);
			window.addLast(i);
			if (nums[i] > output[0]) {
				output[0] = nums[i];
			}
		}
		for (int i = k; i < len; i++) {
			cleanWindow(window, i);
			window.addLast(i);
			output[i - k + 1] = nums[window.getFirst()];

		}
		return output;
	}

	public void cleanWindow(Deque<Integer> window, int n) {
		if (!window.isEmpty() && window.getFirst() < n - k + 1) {
			window.removeFirst();
		}
		while (!window.isEmpty() && nums[window.getLast()] < nums[n]) {
			window.removeLast();
		}
	}


}
