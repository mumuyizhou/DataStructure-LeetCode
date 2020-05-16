package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author 木木漪
 */
public class Question102BinaryTreeLevelOrderTraversal {
	List<List<Integer>> result = new ArrayList<>();
	int count = 0;

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<Integer> level = new ArrayList<>();
		if (root == null) {
			return result;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		prevIterator(root, 0, pq);
		int y = 0;
		while (!pq.isEmpty()) {
			int[] element = pq.poll();
			if (element[1] != y) {
				y++;
				result.add(new ArrayList<>(level));
				level.clear();
			}
			level.add(element[2]);
		}
		result.add(level);
		return result;
	}


	public void prevIterator(TreeNode root, int y, PriorityQueue<int[]> pq) {
		if (root != null) {
			pq.add(new int[]{++count, y, root.val});
			prevIterator(root.left, ++y, pq);
			prevIterator(root.right, y, pq);
		}
	}

	/**
	 * 没用到队列 就实现了 而且很快
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderNotUsingQueue(TreeNode root) {
		prevIterator(root, 1);
		return result;
	}


	public void prevIterator(TreeNode root, int level) {
		if (root != null) {
			if (result.size() < level) {
				result.add(new ArrayList<>());
			}
			result.get(level - 1).add(root.val);
			prevIterator(root.left, ++level);
			prevIterator(root.right, level);
		}
	}

	public static void main(String[] args) {
		Question102BinaryTreeLevelOrderTraversal levelOrderTraversal = new
				Question102BinaryTreeLevelOrderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		levelOrderTraversal.levelOrder(root).forEach(level -> System.out.println(level.toString()));

		List<List<Integer>> a = new ArrayList<>();
		a.add(new ArrayList<>());
		a.add(new ArrayList<>());
		System.out.println(a.size());

	}


}

