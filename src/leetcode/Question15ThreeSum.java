package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author ZhouPan
 * @date 2020-05-27
 */
public class Question15ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		if (len < 3) {
			return new ArrayList<>();
		}

		return null;
	}
}
