package aimatoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *  3
 * / \
 * 9  20
 *   /  \
 *  15   7
 * 返回：
 * [3,9,20,15,7]
 * 提示：
 * 节点总数 <= 1000
 *
 * @author ZhouPan
 * @date 2020-06-12
 */
public class Question32IlevelOrderTraversalBT {
	public int[] levelOrder(TreeNode root) {
		if (root == null) return new int[0];
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		int p = 0;
		while (list.size() > p) {
			TreeNode curret = list.get(p++);
			if (curret.left != null) list.add(curret.left);
			if (curret.right != null) list.add(curret.right);
		}
		int[] output = new int[list.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = list.get(i).val;
		}
//		return list.stream().mapToInt(k-> k.val).toArray();
		return output;
	}
}
