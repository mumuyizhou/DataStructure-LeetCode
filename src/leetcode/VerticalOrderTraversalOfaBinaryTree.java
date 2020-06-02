package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import aimatoffer.TreeNode;

/**
 * @author 木木漪
 */
public class VerticalOrderTraversalOfaBinaryTree {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> out = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> {
			if (c1[0] != c2[0]) {
				return c1[0] - c2[0];
			} else if (c1[1] != c2[1]) {
				return c2[1] - c1[1];
			}
			return c1[2] - c2[2];
		});
		prevIterator(root, 0, 0, pq);
		int[] node = pq.poll();
		int prev = node[0];
		List<Integer> xCord = new ArrayList<>();
		xCord.add(node[2]);
		while (!pq.isEmpty()) {
			node = pq.poll();
			if (node[0] != prev) {
				out.add(xCord);
				xCord = new ArrayList<>();
				xCord.add(node[2]);
			} else {
				xCord.add(node[2]);
			}
			prev = node[0];
		}
		out.add(xCord);

		return out;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		VerticalOrderTraversalOfaBinaryTree verticalOrderBinaryTree
				= new VerticalOrderTraversalOfaBinaryTree();
		verticalOrderBinaryTree.verticalTraversal(root);
		List<List<Integer>> out = new ArrayList<>();


	}

	public void midIterator(TreeNode root) {
		if (root != null) {
			midIterator(root.left);
			System.out.println(root.val);
			midIterator(root.right);
		}
	}

	public PriorityQueue<int[]> prevIterator(TreeNode root, int x, int y, PriorityQueue<int[]> pq) {
		if (root != null) {
			pq.add(new int[]{x, y, root.val});
			prevIterator(root.left, x - 1, y - 1, pq);
			prevIterator(root.right, x + 1, y - 1, pq);
		}
		return pq;
	}
}

