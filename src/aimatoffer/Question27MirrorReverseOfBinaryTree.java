package aimatoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author ZhouPan
 * @date 2020-06-04
 */
public class Question27MirrorReverseOfBinaryTree {
	public TreeNode mirrorTree(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode temp, result = root;
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root == null) continue;
			queue.add(root.right);
			queue.add(root.left);
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
