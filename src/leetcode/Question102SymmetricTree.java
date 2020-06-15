package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.IntersectionType;

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
public class Question102SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		List<Integer> list = new ArrayList<>(1000);
		inorderTraversal(root, list);
		int size = list.size();
		if (size % 2 == 0) return false;
		int mid = size / 2;
		for (int i = 0; i <= mid; i++) {
			if (!list.get(i).equals(list.get(size - 1 - i))) return false;
		}
		return true;
	}

	public void inorderTraversal(TreeNode node, List<Integer> travList) {
		if (node != null) {
			if (node.left == null && node.right == null) {
				travList.add(node.val);
			} else {
				if (node.left == null) {
					travList.add(Integer.MIN_VALUE);
				} else {
					inorderTraversal(node.left, travList);
				}
				travList.add(node.val);
				if (node.right == null) {
					travList.add(Integer.MIN_VALUE);
				} else {
					inorderTraversal(node.right, travList);
				}
			}
		}
	}

		public static void main (String[]args){
			Question102SymmetricTree symmetricTree = new Question102SymmetricTree();
			Question37SerializeBinaryTree serializeBinaryTree = new Question37SerializeBinaryTree();
			System.out.println(symmetricTree.isSymmetric(serializeBinaryTree.deserialize("[1,2,2,2,null,2]")));
		}
	}
