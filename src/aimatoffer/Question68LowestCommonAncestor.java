package aimatoffer;


/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * @author ZhouPan
 * @date 2020-05-28
 */
public class Question68LowestCommonAncestor {
	TreeNode ancestor;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ancestor = root;
		inOrderTraversal(root, p, q);
		return ancestor;
	}

	public boolean inOrderTraversal(TreeNode root, TreeNode p, TreeNode q) {
		boolean rootIsPq = root == p || root == q;
		boolean leftContainsPq = false;
		boolean rightContainsPq = false;
		if (root != null) {
			leftContainsPq = inOrderTraversal(root.left, p, q);
			//root
			rightContainsPq = inOrderTraversal(root.right, p, q);
		}
		if (rootIsPq && (leftContainsPq || rightContainsPq) || (leftContainsPq && rightContainsPq)) {
			ancestor = root;
		}
		return rootIsPq || rightContainsPq || leftContainsPq;
	}

	/**
	 * 这道题后序遍历好做很多
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestorPostOrder(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == q || root == p) {
			return root;
		}
		TreeNode left = lowestCommonAncestorPostOrder(root.left, p, q);
		TreeNode right = lowestCommonAncestorPostOrder(root.right, p, q);
		if (left == null) return right;
		if (right == null) return left;
		return root;
	}
}
