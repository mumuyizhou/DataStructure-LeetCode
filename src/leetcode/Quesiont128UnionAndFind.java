package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ZhouPan
 * @date 2020-07-18
 */
public class Quesiont128UnionAndFind {

	public int longestConsecutive(int[] nums) {
		UnionFind union = new UnionFind(nums);
		for (int num : nums) {
			if (union.fmap.containsKey(num - 1)) {
				union.union(num - 1, num);
			}
		}
		return union.max;
	}

	class UnionFind {
		private int max;
		private Map<Integer, Integer> fmap = new HashMap<>();
		private Map<Integer, Integer> sizeMap = new HashMap<>();

		public UnionFind(int[] nums) {
			int len = nums.length;
			for (int num : nums) {
				fmap.put(num, num);
				sizeMap.put(num, 1);
			}
		}

		public int findFather(int val) {
			int father = fmap.get(val);
			return father == val ? father : fmap.get(father);
		}

		public void union(int a, int b) {
			int aFather = findFather(a);
			int bFather = findFather(b);
			if (aFather != bFather) {
				int aSize = sizeMap.get(aFather);
				int bSize = sizeMap.get(bFather);
				if (aSize > bSize) {
					fmap.put(bFather, aFather);
					sizeMap.put(bSize, aSize + bSize);
				} else {
					fmap.put(aFather, bFather);
					sizeMap.put(aSize, aSize + bSize);
				}
				max = Math.max(max, aSize + bSize);
			}
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.println(scanner.nextLine());
		}
		Quesiont128UnionAndFind quesiont128UnionAndFind = new Quesiont128UnionAndFind();

		quesiont128UnionAndFind.longestConsecutive(new int[]{1, 2, 3, 4});
	}

}
