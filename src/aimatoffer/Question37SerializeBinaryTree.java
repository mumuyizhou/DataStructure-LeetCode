package aimatoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 示例: 
 * 你可以将以下二叉树：
 * 	    1
 *     / \
 *    2   3
 *       / \
 *      4   5
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
		List<List<TreeNode>> list = new ArrayList<>();
		list = serializeTravelsal(root, 0, list);
		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			int size = list.get(i).size();
			for (int j = 0; j < size; j++) {
				TreeNode currentNode = list.get(i).get(j);
				builder.append(currentNode == null ? "null" : currentNode.val).append(",");
			}
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
		if (data.length() == 2) {
			return null;
		}
		TreeNode[] nodes = parseStrToNodeArr(data);
		int len = nodes.length;
		List<List<TreeNode>> list = new ArrayList<>();
		int prev, p = 0, layer = 0;
		if (nodes[0] != null) {
			list.add(new ArrayList<>());
			list.get(0).add(nodes[0]);
			prev = 1;
			p++;
			layer++;
		} else {
			return null;
		}
		while (p < len) {
			int endOfThisLayer = p - 1 + 2 * prev;
			prev = 0;
			while (p <= endOfThisLayer && p < len) {
				if (list.size() <= layer) list.add(new ArrayList<>());
				list.get(layer).add(nodes[p]);
				prev = nodes[p] == null ? prev : prev + 1;
				p++;
			}
			++layer;
		}
		int numOfLayers = list.size();
		for (int i = 1; i < numOfLayers; i++) {
			int layerSize = list.get(i).size();
			int pLayer = 0, j = 0;
			while (j < layerSize) {
				while (list.get(i - 1).get(pLayer) == null) {
					pLayer++;
				}
				list.get(i - 1).get(pLayer).left = list.get(i).get(j++);
				list.get(i - 1).get(pLayer).right = j < layerSize ? list.get(i).get(j++) : null;
				pLayer++;
			}
		}
		return list.get(0).get(0);
	}

	private List<List<TreeNode>> serializeTravelsal(TreeNode root, int layer, List<List<TreeNode>> list) {
		if (list.size() <= layer) list.add(new ArrayList<>());
		if (root == null) {
			list.get(layer).add(null);
			return list;
		}
		list.get(layer).add(root);
		list = serializeTravelsal(root.left, ++layer, list);
		list = serializeTravelsal(root.right, layer, list);
		return list;
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

	public static void main(String[] args) {
		Question37SerializeBinaryTree tree = new Question37SerializeBinaryTree();
		tree.serialize(tree.deserialize("[1,2,3,null,null,4,5]"));
	}
}
