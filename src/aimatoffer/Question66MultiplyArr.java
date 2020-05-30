package aimatoffer;

import java.util.stream.Stream;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。(总之B[i]的值跟A[i]没有关系)
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * @author ZhouPan
 * @date 2020-05-29
 */
public class Question66MultiplyArr {
	public int[] constructArr(int[] a) {
		if (a == null || a.length == 0) {
			return new int[0];
		}
		int len = a.length;
		int[] leftArr = new int[len];
		int[] rightArr = new int[len];
		int[] b = new int[len];
		leftArr[0] = 1;
		rightArr[len - 1] = 1;
		for (int i = 1; i < len; i++) {
			leftArr[i] = leftArr[i - 1] * a[i - 1];
		}
		for (int i = len - 2; i >= 0; i--) {
			rightArr[i] = rightArr[i + 1] * a[i + 1];
		}
		for (int i = 0; i < len; i++) {
			b[i] = rightArr[i] * leftArr[i];
		}
		return b;
	}

	public int[] constructArrFaster(int[] a) {
		if (a.length == 0) return new int[0];
		int[] b = new int[a.length];
		b[0] = 1;
		int temp = 1;
		for (int i = 1; i < a.length; i++) {
			b[i] = b[i - 1] * a[i - 1];
		}
		for (int i = a.length - 2; i >= 0; i--) {
			temp *= a[i + 1];
			b[i] *= temp;
		}
		return b;
	}


	public static void main(String[] args) {
		Question66MultiplyArr multiplyArr = new Question66MultiplyArr();
		multiplyArr.constructArrFaster(new int[]{1, 2, 3, 4, 5});
	}
}
