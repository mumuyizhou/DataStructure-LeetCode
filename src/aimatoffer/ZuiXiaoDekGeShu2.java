package aimatoffer;

import java.util.Arrays;

/**
 *
 */
public class ZuiXiaoDekGeShu2 {
	/**
	 * @return
	 */
	public int[] getLeastNumbers(int[] nums, int k) {
		if (k == 0) {
			return new int[0];
		}
		int[] heap = new int[k];
		for (int i = 0; i < k; i++) {
			heap[i] = nums[i];
		}
		buildHeap(heap);
		for (int i = k; i < nums.length; i++) {
			if (nums[i] < heap[0]) {
				heap[0] = nums[i];
				heapify(heap, 0);
			}
		}
		return heap;
	}

	public void buildHeap(int[] heap) {
		int lastNode = heap.length - 1;
		int startHeapifyNode = (lastNode - 1) / 2;
		while (startHeapifyNode >= 0) {
			heapify(heap, startHeapifyNode--);
		}
	}

	public void heapify(int[] heap, int k) {
		int length = heap.length;
		int max = k;
		int c1 = (k << 1) + 1, c2 = (k << 1) + 2;
		if (c1 < length && heap[c1] > heap[max]) {
			max = c1;
		}
		if (c2 < length && heap[c2] > heap[max]) {
			max = c2;
		}
		if (max != k) {
			swap(heap, k, max);
			heapify(heap, max);
		}
	}

	public void swap(int[] nums, int i, int j) {
		nums[i] = nums[j] + nums[i] - (nums[j] = nums[i]);
	}

	public static void main(String[] args) {
		ZuiXiaoDekGeShu2 xiao2 = new ZuiXiaoDekGeShu2();
		System.out.println(Arrays.toString(xiao2.getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8)));
	}
}
