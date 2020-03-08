package aimatoffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true

 * 提示：
 * 数组长度 <= 1000

 * @author 木木漪
 */
public class Question33ErChaSouSuoShuDeHouXuBianLiXuLie {

	/**我的解法，解完后看了看大家的 思路都差不多
	 * @param postorder
	 * @return
	 */
	public boolean verifyPostorder(int[] postorder) {
		int len = postorder.length;
		return subTree(postorder,0, len-1);

	}
	public boolean subTree(int[] postorder, int start,int end) {
		if (start == end) return true;
		int rightSmaller = -1;
		int leftGreater = end;
		for (int i = end; i >= start; i--) {
			if (postorder[i] < postorder[end] && rightSmaller == -1) {
				rightSmaller = i;
			} else if (postorder[i] > postorder[end]) {
				leftGreater = i;
			}
		}
		if (leftGreater < rightSmaller) {
			return false;
		}
		return (rightSmaller <= 0 || subTree(postorder, start, rightSmaller)) &&
				(leftGreater >= end || subTree(postorder, leftGreater, end - 1));
	}

	public static void main(String[] args) {
		Question33ErChaSouSuoShuDeHouXuBianLiXuLie erCha =
				new Question33ErChaSouSuoShuDeHouXuBianLiXuLie();
		System.out.println(1< Integer.MAX_VALUE);
	}
}
