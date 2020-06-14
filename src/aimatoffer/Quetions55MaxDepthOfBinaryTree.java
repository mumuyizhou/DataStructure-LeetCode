package aimatoffer;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 返回它的最大深度 3 。
 * 提示：
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author ZhouPan
 * @date 2020-06-14
 */
public class Quetions55MaxDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		int maxDepth = 0;
		queue.add(new Pair<>(root, 1));
		while (!queue.isEmpty()) {
			Pair<TreeNode, Integer> pairCur = queue.poll();
			int depth = pairCur.getValue();
			maxDepth = Math.max(depth, maxDepth);
			TreeNode node = pairCur.getKey();
			if (node.left != null) queue.add(new Pair<>(node.left, depth + 1));
			if (node.right != null) queue.add(new Pair<>(node.right, depth + 1));
		}
		return maxDepth;
	}

	public int maxDepthDfs(TreeNode root) {
		return inorderTraversal(root, 0);
	}

	public int inorderTraversal(TreeNode node, int depth) {
		if (node == null) return depth;
		return Math.max(
				inorderTraversal(node.left, depth + 1),
				inorderTraversal(node.right, depth + 1));
	}

	public int maxDepthSimpleEntry(TreeNode root) {
		if (root == null) return 0;
		Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();
		int maxDepth = 0;
		queue.add(new AbstractMap.SimpleEntry<>(root, 1));
		while (!queue.isEmpty()) {
			AbstractMap.SimpleEntry<TreeNode, Integer> pairCur = queue.poll();
			int depth = pairCur.getValue();
			maxDepth = Math.max(depth, maxDepth);
			TreeNode node = pairCur.getKey();
			if (node.left != null) queue.add(new AbstractMap.SimpleEntry<>(node.left, depth + 1));
			if (node.right != null) queue.add(new AbstractMap.SimpleEntry<>(node.right, depth + 1));
		}
		return maxDepth;
	}

}
