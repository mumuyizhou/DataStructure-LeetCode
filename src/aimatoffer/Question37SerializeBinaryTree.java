package aimatoffer;

import java.util.Arrays;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 示例: 
 * 你可以将以下二叉树：
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * @author ZhouPan
 * @date 2020-06-01
 */
public class Question37SerializeBinaryTree {
	/**
	 * Encodes a tree to a single string.
	 *
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode root) {
		final int INIT_CAPACITY = 10;
		StringBuilder builder = new StringBuilder(INIT_CAPACITY);
		builder.append("[");
		TreeNode[] orderArr = new TreeNode[INIT_CAPACITY];
		orderArr = serializeTravelsal(root, 0, orderArr);
		int lastNotNullIndex = 0;
		for (int i = 0; i < orderArr.length; i++) {
			if (orderArr[i] != null) lastNotNullIndex = i;
		}
		for (int i = 0; i <= lastNotNullIndex; i++) {
			builder.append(orderArr[i] == null ? "null" : orderArr[i].val).append(",");
		}
		builder.delete(builder.length() - 1, builder.length());
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Decodes your encoded data to tree.
	 *
	 * @param data
	 * @return
	 */
	public TreeNode deserialize(String data) {
		TreeNode[] nodes = parseStrToNodeArr(data);
		deserializeTraversal(nodes, 0);
		return nodes[0];
	}

	private TreeNode[] serializeTravelsal(TreeNode root, int currentOrder, TreeNode[] orderArr) {
		if (root == null) return orderArr;
		if (currentOrder > orderArr.length) orderArr = doubleGrowArr(orderArr);
		orderArr[currentOrder] = root;
		orderArr = serializeTravelsal(root.left, currentOrder * 2 + 1, orderArr);
		orderArr = serializeTravelsal(root.right, currentOrder * 2 + 2, orderArr);
		return orderArr;
	}

	private <T> T[] doubleGrowArr(T[] orderArr) {
		int len = orderArr.length;
		int newLen = len << 1 + 2;
		if (newLen - len < 0) newLen = len;
		return Arrays.copyOf(orderArr, newLen);
	}

	private void deserializeTraversal(TreeNode[] nodes, int currentOrder) {
		if (nodes[currentOrder] == null) return;
		int leftSonPos = currentOrder * 2 + 1;
		int rightSonPos = currentOrder * 2 + 2;
		if (leftSonPos < nodes.length) {
			nodes[currentOrder].left = nodes[leftSonPos];
			deserializeTraversal(nodes, leftSonPos);
		}
		if (rightSonPos < nodes.length) {
			nodes[currentOrder].right = nodes[rightSonPos];
			deserializeTraversal(nodes, rightSonPos);
		}
	}

	private TreeNode[] parseStrToNodeArr(String nodeStr) {
		nodeStr = nodeStr.substring(1, nodeStr.length() - 1);
		String[] strings = nodeStr.split(",");
		TreeNode[] nodes = new TreeNode[strings.length];
		int len = strings.length;
		for (int i = 0; i < len; i++) {
			if (!"null".equals(strings[i])) {
				nodes[i] = new TreeNode(Integer.parseInt(strings[i]));
			}
		}
		return nodes;
	}
}
