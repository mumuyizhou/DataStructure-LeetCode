package aimatoffer;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        		 1
 *       		/ \
 *     		   2   2
 *            / \
 *           3   3
 *         / \
 *        4   4
 * 返回 false 。
 *
 * @author ZhouPan
 * @date 2020-06-04
 */
public class Question55BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return postOrderTraversal(root)[1] == 1;
	}

	/**
	 * 这么写其实是非常非主流的 其实只需要一个整型存储状态即可，
	 * 比如当它为-1，就说明子树不平衡了。大于等于零，说明子树为平衡的，
	 * 返回的是子树中最大深度的值
	 *
	 * @param root
	 * @return
	 */
	public int[] postOrderTraversal(TreeNode root) {
		if (root == null) return new int[]{0, 1};
		int[] lenL = postOrderTraversal(root.left);
		int[] lenR = postOrderTraversal(root.right);
		if (lenL[1] == 0 || lenR[1] == 0) return new int[]{0, 0};
		if (lenL[0] - lenR[0] <= 1 && lenL[0] - lenR[0] >= -1)
			return new int[]{Math.max(lenL[0], lenR[0]) + 1, 1};
		return new int[]{0, 0};
	}
}
