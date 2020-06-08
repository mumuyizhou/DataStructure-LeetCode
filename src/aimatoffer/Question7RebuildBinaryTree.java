package aimatoffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author ZhouPan
 * @date 2020-06-08
 */
public class Question7RebuildBinaryTree {
	/**
	 * 执行用时 :5 ms, 在所有 Java 提交中击败了39.80%的用户
	 *
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return traversalHelper(preorder, inorder, 0, preorder.length, 0, inorder.length);
	}

	public TreeNode traversalHelper(int[] preorder, int[] inorder, int startP, int endP, int startI, int endI) {
		if (startP >= endP) return null;
		if (startP == endP - 1) return new TreeNode(preorder[startP]);
		TreeNode root = new TreeNode(preorder[startP]);
		for (int i = startI; i < endI; i++) {
			if (inorder[i] == preorder[startP]) {
				int sub = i - startI + startP + 1;
				root.left = traversalHelper(preorder, inorder, startP + 1, sub, startI, i);
				root.right = traversalHelper(preorder, inorder, sub, endP, i + 1, endI);
				break;
			}
		}
		return root;
	}

	;

	public static void main(String[] args) {
		Question7RebuildBinaryTree binaryTree = new Question7RebuildBinaryTree();

	}
}
