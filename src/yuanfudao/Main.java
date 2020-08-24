package yuanfudao;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import aimatoffer.Question37SerializeBinaryTree;
import aimatoffer.TreeNode;

/**
 * @author ZhouPan
 * @date 2020-08-24
 */
public class Main {
	private static final Question37SerializeBinaryTree serializer = new Question37SerializeBinaryTree();

	/**
	 * 打印二叉树边界节点，逆时针。使用递归
	 */
	private static void question1(TreeNode root) {
		List<List<TreeNode>> ans = new ArrayList<>();
		dfs(root, 0, ans);
		for (List<TreeNode> aLevel : ans) {
			System.out.print(aLevel.get(0).val + " ");
		}
		if (ans.size() <= 1) return;
		List<TreeNode> lastLine = ans.get(ans.size() - 1);
		for (int i = 1; i < lastLine.size(); i++) {
			System.out.print(lastLine.get(i).val + " ");
		}
		List<TreeNode> secondLast = ans.get(ans.size() - 2);
		for (int i = 1; i < secondLast.size(); i++) {
			TreeNode cur = secondLast.get(i);
			if (cur.left == null && cur.right == null) {
				System.out.print(cur.val + " ");
			}
		}
		for (int i = ans.size() - 3; i > 0; i--) {
			List<TreeNode> cur = ans.get(i);
			if (cur.size() > 1) {
				System.out.print(cur.get(cur.size() - 1).val + " ");
			}
		}
	}

	/**
	 * 用迭代
	 *
	 * @param root
	 */
	private static void question1II(TreeNode root) {
		Deque<TreeNode> deque = new ArrayDeque<>();
		if (root == null) return;
		deque.addLast(root);
		Deque<TreeNode> lineLastStack = new ArrayDeque<>();
		Deque<TreeNode> leafStack = new ArrayDeque<>();
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = deque.pollFirst();
				if (i == 0) {
					System.out.print(cur.val + " ");
					if (cur.left != null) {
						deque.addLast(cur.left);
					}
					if (cur.right != null) {
						deque.addLast(cur.right);
					}
					continue;
				}
				if (cur.left == null && cur.right == null && i != size - 1) {
					if (deque.size() == size - i + 1) {
						System.out.print(cur.val + " ");
					} else {
						leafStack.addLast(cur);
					}
				}
				if (i == size - 1) {
					lineLastStack.push(cur);
				}
				if (cur.left != null) {
					deque.addLast(cur.left);
				}
				if (cur.right != null) {
					deque.addLast(cur.right);
				}
			}
		}
		while (!leafStack.isEmpty()) {
			System.out.print(leafStack.poll().val + " ");
		}
		while (!lineLastStack.isEmpty()) {
			System.out.print(lineLastStack.poll().val + " ");
		}
	}

	private static void dfs(TreeNode node, int level, List<List<TreeNode>> list) {
		if (node == null) return;
		if (list.size() < level + 1) {
			list.add(new ArrayList<>());
		}
		list.get(level).add(node);
		dfs(node.left, ++level, list);
		dfs(node.right, level, list);
	}

	public static void main(String[] args) {
		String serializedTree = "[1,2,3,4,5,6,7,8]";
		TreeNode root = serializer.deserialize(serializedTree);
		question1(root);
		System.out.println();
		question1II(root);
	}
}
