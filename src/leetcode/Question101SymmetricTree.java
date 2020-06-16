package leetcode;

import java.util.*;

import aimatoffer.Question37SerializeBinaryTree;
import aimatoffer.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author ZhouPan
 * @date 2020-06-15
 */
public class Question101SymmetricTree {
	/**
	 * 这个问题解法的关键在于两个指针
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetricIteration(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			TreeNode q = queue.poll();
			if (p == null && q == null) continue;
			if (p == null || q == null) return false;
			if (p.val != q.val) return false;
			queue.offer(p.left);
			queue.offer(q.right);
			queue.offer(p.right);
			queue.offer(q.left);
		}
		return true;
	}

	public boolean isSymmetric(TreeNode root) {
		return recursion(root, root);
	}

	public boolean recursion(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		return p.val == q.val && recursion(p.right, q.left) && recursion(p.left, q.right);
	}

	public static void main(String[] args) {
		Question101SymmetricTree symmetricTree = new Question101SymmetricTree();
		Question37SerializeBinaryTree serializeBinaryTree = new Question37SerializeBinaryTree();
		System.out.println(symmetricTree.isSymmetric(serializeBinaryTree.deserialize("[1,2,2,3,4,4,3]")));
	}
}
