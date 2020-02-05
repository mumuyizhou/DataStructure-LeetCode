package leetcode;

import java.util.*;

/**
 * @author ZhouPan
 * @date 2019-12-03
 **/
public class MaxSlidingWindow {
	public static void main(String[] args) {
		int[] data = {7, 1, 2, 3, 4, 5};
		MaxSlidingWindow max = new MaxSlidingWindow();
		System.out.println(Arrays.toString(max.maxSlidingWindow(data, 2)));
	}


	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deque = new ArrayDeque<>(k);
		for(int i = 0; i < 3;i++ ){
			deque.push(nums[i]);
        }
		List<Integer> output = new ArrayList<>();
		LinkedList<Integer> temp = new LinkedList<>();
		temp.
		int  size = nums.length;
		output.add(Collections.max(deque));
		for(int i =3;i<size;i++){
			deque.push(nums[i]);
			deque.removeLast();
			output.add(Collections.max(deque));
		}
		return output.stream().mapToInt(Integer::valueOf).toArray();
	}
}
