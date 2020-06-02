package aimatoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这个解法虽然没我本身写的快（自己写的超过62.88,这个55.79）,但它的可读性好太多了，巧妙地使用了队列
 *
 * @author ZhouPan
 * @date 2020-06-02
 * @see Question37SerializeBinaryTree
 */
public class Question37SerializeBinaryTreeUsingQueue {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) return "[]";
		StringBuilder builder = new StringBuilder(10);
		builder.append("[");
		Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
			add(root);
		}};//匿名内部类的静态代码块
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				queue.add(node.left);
				queue.add(node.right);
				builder.append(node.val + ",");
			} else {
				builder.append("null,");
			}
		}
		return builder.deleteCharAt(builder.length() - 1).append("]").toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		data = data.substring(1, data.length() - 1);
		String[] dataArr = data.split(",");
		int i = 1;
		int len = dataArr.length;
		if (data.isEmpty() || "null".equals(data)) return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
			add(new TreeNode(Integer.parseInt(dataArr[0])));
		}};
		TreeNode result = queue.peek();
		while (!queue.isEmpty()) {
			TreeNode fatherNode = queue.poll();
			if (fatherNode == null) continue;
			if (i < len) {
				fatherNode.left = "null".equals(dataArr[i]) ? null :
						new TreeNode(Integer.parseInt(dataArr[i]));
				queue.add(fatherNode.left);
				i++;
			}
			if (i < len) {
				fatherNode.right = "null".equals(dataArr[i]) ? null :
						new TreeNode(Integer.parseInt(dataArr[i]));
				queue.add(fatherNode.right);
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Question37SerializeBinaryTreeUsingQueue usingQueue = new Question37SerializeBinaryTreeUsingQueue();
		usingQueue.serialize(usingQueue.deserialize("[]"));
	}
}
