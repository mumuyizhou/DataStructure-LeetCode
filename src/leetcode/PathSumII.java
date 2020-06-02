package leetcode;

import java.util.ArrayList;
import java.util.List;

import aimatoffer.TreeNode;

public class PathSumII {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */

	List<Integer> candidate = new ArrayList<>();
	List<List<Integer>> output = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return new ArrayList<>();
		}
		int valRoot = root.val;
		int remain = sum - valRoot;
		candidate.add(valRoot);
		int size = candidate.size();
		if (valRoot == sum && root.left == null && root.right == null) {
			output.add(new ArrayList<>(candidate));
		}
		if (root.left != null) {
			pathSum(root.left, remain);
		}
		if (root.right != null) {
			pathSum(root.right, remain);
		}

		candidate.remove(size - 1);
		return output;
	}

	public static void main(String[] args) {
		int n=2;
		System.out.println(n+((int)(Math.pow(n,2))-n>>>1));
	}


}
